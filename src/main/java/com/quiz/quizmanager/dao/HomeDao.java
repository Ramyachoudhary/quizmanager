/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizmanager.dao;

import com.quiz.quizmanager.pojos.Question;
import com.quiz.quizmanager.pojos.answersRecorded;
import com.quiz.quizmanager.pojos.professor;
import com.quiz.quizmanager.pojos.quiz;
import com.quiz.quizmanager.pojos.quizidquestionmapping;
import com.quiz.quizmanager.pojos.result;
import com.quiz.quizmanager.pojos.student;

import com.quiz.quizmanager.pojos.user;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramya
 */
@Repository
public class HomeDao implements IHomeDao {

    @Autowired
    SessionFactory factory;

    @Override
    public user getUserstatus(String userid, String password) {
        System.out.println("com.quiz.quizmanager.dao.HomeDao.getUserstatus()");

        Session session = factory.getCurrentSession();

        Criteria cr = session.createCriteria(user.class).add(Restrictions.and(Restrictions.eq("userLoginId", userid), Restrictions.eq("userpassword", password)));
        System.out.println("==============" + cr.list());
        List<user> mlist = cr.list();
        if (mlist.size() > 0) {
            return mlist.get(0);
        } else {
            return null;
        }

//        String status="professor";//dao action
        //  return u; 
    }

    @Override
    public void saveQuestion(Question qstion) {
        int x = 0;
        Session session = factory.getCurrentSession();
        Criteria cr = session.createCriteria(Question.class).setProjection(Projections.max("question_id"));
        if (cr.uniqueResult() != null) {
            x = (int) cr.uniqueResult();
        } else {
            x = 0;
        }
        qstion.setQuestion_id(x + 1);
        //   Transaction transaction = session.beginTransaction();

        session.save(qstion);
        //session.getTransaction().commit();
    }

    @Override
    public ArrayList<Question> getQuestions(String userId) {
        Session session = factory.getCurrentSession();
        Criteria cr = session.createCriteria(Question.class).add(Restrictions.and(Restrictions.eq("created_by", userId)));
        System.out.println("==============" + cr.list());
        ArrayList<Question> mlist = (ArrayList<Question>) cr.list();
        return mlist;
    }

    @Override
    public void saveqz(quiz qz, String[] questionsids) {

        int x = 0;
        Session session = factory.getCurrentSession();
        Criteria cr = session.createCriteria(quiz.class).setProjection(Projections.max("quizid"));
        if (cr.uniqueResult() != null) {
            x = (int) cr.uniqueResult();
        } else {
            x = 0;
        }
        x = x + 1;
        qz.setQuizid(x);
        session.save(qz);

        Criteria cr1 = session.createCriteria(quizidquestionmapping.class).setProjection(Projections.max("mappingid"));

        int t = 0;
        if (cr1.uniqueResult() != null) {
            t = (int) cr1.uniqueResult();
        } else {
            t = 0;
        }
        for (int i = 0; i < questionsids.length; i++) {
            t++;

            quizidquestionmapping map = new quizidquestionmapping();
            map.setMappingid(t);
            map.setQuestionid(questionsids[i]);
            map.setQuizid(x + "");
            session.save(map);
        }

    }

    @Override
    public ArrayList<quiz> getallquizList() {
        Session session = factory.getCurrentSession();
        Criteria cr = session.createCriteria(quiz.class);
        ArrayList<quiz> mlist = (ArrayList) cr.list();
        if (mlist.size() > 0) {
            return mlist;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Question> getQuestionsByid(String qzid) {
        Session session = factory.getCurrentSession();
        Criteria cr1 = session.createCriteria(quizidquestionmapping.class).add(Restrictions.eq("quizid", qzid));
        ArrayList<quizidquestionmapping> listqids = (ArrayList<quizidquestionmapping>) cr1.list();

        ArrayList<Question> retlist = new ArrayList<>();

        for (quizidquestionmapping map : listqids) {
            try {
                Criteria cr = session.createCriteria(Question.class);
                ArrayList<Question> qtnlist = (ArrayList<Question>) cr.list();
                for (Question qn : qtnlist) {
                    if (qn.getQuestion_id() == Integer.parseInt(map.getQuestionid())) {
                        retlist.add(qn);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return retlist;
    }

    @Override
    public boolean evaluteandinsert(String question_id, String[] answers, String qzid, int uid) {
        Session session = factory.getCurrentSession();
        Question qstn = null;

        Criteria cr = session.createCriteria(Question.class);
        ArrayList<Question> qtnlist = (ArrayList<Question>) cr.list();
        for (Question qn : qtnlist) {
            if (qn.getQuestion_id() == Integer.parseInt(question_id)) {
                //retlist.add(qn);
                qstn = qn;
            }
        }
        boolean retvalue = true;
        for (int i = 0; i < answers.length; i++) {
          
               int ansid = 0;
      
        Criteria cr_getmaxans_id = session.createCriteria(answersRecorded.class).setProjection(Projections.max("answerid"));
        
        
        if (cr_getmaxans_id.uniqueResult() != null) {
            ansid = (int) cr_getmaxans_id.uniqueResult();
        } else {
           ansid = 0;
        }
        ansid = ansid + 1;
            
            
            
            
            String ans = "+" + answers[i];
            if (ans.equalsIgnoreCase(qstn.getOption_one()) || ans.equalsIgnoreCase(qstn.getOption_two()) || ans.equalsIgnoreCase(qstn.getOption_three()) || ans.equalsIgnoreCase(qstn.getOption_four()) || ans.equalsIgnoreCase(qstn.getOption_five())) {
                //  retvalue=true;
            } else {
                retvalue = false;
            }
            answersRecorded ansobj = new answersRecorded();
            ansobj.setAnswerid(ansid);
            ansobj.setQuiz_id(qzid);
            ansobj.setStudent_id(uid + "");
            ansobj.setSaved_answer(answers[i]);
            ansobj.setAnswertimestamp(new Date());
            session.save(ansobj);

        }
        return retvalue;

    }

    @Override
    public void saveResult(String userId, String qzid, int totalquestions, int correct_answers,String quizname) {
        
       Session session=factory.getCurrentSession();
        result res=new result();
        res.setResultid(1);
      
        
        res.setUser_id(userId); 
        res.setQuiz_id(qzid);
        res.setQuiz_submited_at(new Date());
        res.setTotal_answered(totalquestions); 
        res.setTotal_no_questions(totalquestions);
        res.setCorrect_answers(correct_answers);
        res.setQuiz_name(quizname); 
        session.save(res);
       
    }
    @Override
    public boolean saveprofessor(user u, professor p) {
        try{
        int x = 0;
        Session session = factory.getCurrentSession();
        Criteria cr = session.createCriteria(professor.class).setProjection(Projections.max("professorId"));
        if (cr.uniqueResult() != null) {
            x = (int) cr.uniqueResult();
        } else {
            x = 0;
        }
        x = x + 1;
        p.setProfessorId(x);
        p.setPregisteredAt(new Date());
        u.setRoleId(x + "");
        session.save(p);
         
        
        
        
        
        
        
          int y= 0;
       
        Criteria cr2 = session.createCriteria(user.class).setProjection(Projections.max("userId"));
        if (cr2.uniqueResult() != null) {
            y = (int) cr2.uniqueResult();
        } else {
            y = 0;
        }
        y = y+ 1;
        
        
        
        
        
        u.setUserId(y); 
        
        
        
        session.save(u);
                return true;
        }catch(Exception e){
            return  false;
        }
    }

    @Override
    public boolean savestudent(user u, student s) {
           try{
        int x = 0;
        Session session = factory.getCurrentSession();
        Criteria cr = session.createCriteria(student.class).setProjection(Projections.max("studentid"));
        if (cr.uniqueResult() != null) {
            x = (int) cr.uniqueResult();
        } else {
            x = 0;
        }
        x = x + 1;
       s.setStudentid(x);
       // p.setPregisteredAt(new Date());
        u.setRoleId(x + "");
        session.save(s);
         
        
        
        
        
        
        
          int y= 0;
       
        Criteria cr2 = session.createCriteria(user.class).setProjection(Projections.max("userId"));
        if (cr2.uniqueResult() != null) {
            y = (int) cr2.uniqueResult();
        } else {
            y = 0;
        }
        y = y+ 1;
        
        
        
        
        
        u.setUserId(y); 
        
        
        
        session.save(u);
                return true;
        }catch(Exception e){
            return  false;
        }
    }

    @Override
    public ArrayList<result> getDashbardData() {
        Session session = factory.getCurrentSession();
        Criteria cr=session.createCriteria(result.class);
        return (ArrayList<result>)cr.list();
    }

}
