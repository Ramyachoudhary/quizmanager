/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizmanager;

import com.quiz.quizmanager.dao.IHomeDao;
import com.quiz.quizmanager.pojos.Question;
import com.quiz.quizmanager.pojos.professor;
import com.quiz.quizmanager.pojos.quiz;
import com.quiz.quizmanager.pojos.result;
import com.quiz.quizmanager.pojos.student;
import com.quiz.quizmanager.pojos.user;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramya
 */
@Service
public class HomeService implements IHomeService {

    @Autowired
    IHomeDao dao;

    @Override
    @Transactional
    public user checklogin(user usr) {

        String usrid = usr.getUserLoginId();
        String usrpassword = usr.getUserpassword();
        return dao.getUserstatus(usrid, usrpassword);

    }

    @Override
    @Transactional
    public void saveQuestion(Question qstion) {
        dao.saveQuestion(qstion);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods    }

    }

    @Override
    @Transactional
    public ArrayList<Question> getQuestions(String userId) {

        return dao.getQuestions(userId);
//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates., choose Tools | Templates.
    }

    @Override
    @Transactional
    public void saveQuiz(quiz qz, String[] questionsids) {
        dao.saveqz(qz, questionsids);

    }

    @Override
    @Transactional
    public ArrayList<quiz> getallquizList() {
        return dao.getallquizList();
    }

    @Override
    @Transactional
    public ArrayList<Question> getQuestionsbyqzid(String qzid) {
        return dao.getQuestionsByid(qzid);
    }

    @Override
    @Transactional
    public boolean insertsubmitedAns(String question_id, String[] answers, String qzid, int uid) {
        return dao.evaluteandinsert(question_id, answers, qzid, uid);
    }

    @Override
    @Transactional
    public void saveResult(String userId, String qzid, int totalquestions, int correct_answers, String quizname) {
        dao.saveResult(userId, qzid, totalquestions, correct_answers, quizname);
    }

    @Override
    @Transactional
    public boolean saveuser(String name, user u) {
        if (u.getUserRole().equalsIgnoreCase("professor")) {
            professor p = new professor();
            p.setProfessorDesg(u.getUserRole());
            p.setProfessorName(name);

            return dao.saveprofessor(u, p);
        } else {

            student s = new student();
            s.setSdgid("student");
            s.setStudentname(name);

            return dao.savestudent(u, s);
        }
    }

    @Override
    @Transactional
    public ArrayList<result> getDashbardData() {
        return dao.getDashbardData();
    }

}
