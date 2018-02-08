/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizmanager;

import com.quiz.quizmanager.pojos.Question;
import com.quiz.quizmanager.pojos.quiz;
import com.quiz.quizmanager.pojos.result;
import com.quiz.quizmanager.pojos.user;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ramya
 */
@Controller
public class HomeController {

    @Autowired
    IHomeService homeservice;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String viewHome(Model model) {
        model.addAttribute("User", new user());
        return "home";
    }

    @RequestMapping(value = "/signup")
    public String showsignup(Model model, @RequestParam("name") String name, @RequestParam("uname") String username, @RequestParam("password") String password, @RequestParam("role") String role) {

        try {
            user u = new user();
            u.setUserName(name);
            u.setUserLoginId(username);
            u.setUserpassword(password);
            u.setUserRole(role);

            if (homeservice.saveuser(name, u)) {
                model.addAttribute("message", "user created");
                return "msg";
            } else {
                model.addAttribute("message", "un able to create user! please try with diffrent user");
                return "msg";
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "un able to create user! please try with diffrent user");
            return "message";

        }

    }

    @RequestMapping(value = "/logincheck", method = RequestMethod.POST)
    public String loginCheck(Model model, @ModelAttribute("User") user user, HttpSession session) {
        if (user.getUserLoginId().equalsIgnoreCase("") || user.getUserpassword().equalsIgnoreCase("")) {
            model.addAttribute("error", "please enter username and password");
            model.addAttribute("User", new user());
            return "home";
        }

        user usr = homeservice.checklogin(user);

        if (usr != null) {
            if (usr.getUserRole().endsWith("student")) {
                session.setAttribute("user", usr);
                model.addAttribute("User", usr);

                model.addAttribute("quizlist", homeservice.getallquizList());

                return "studenthome";
            } else if (usr.getUserRole().endsWith("professor")) {
                model.addAttribute("User", usr);
                session.setAttribute("user", usr);

                ArrayList<result> resultarray = homeservice.getDashbardData();
                model.addAttribute("resultarray", resultarray);

                return "professorhome";
            } else {
                model.addAttribute("User", new user());
                return "home";
            }
        } else {
            model.addAttribute("User", new user());
            return "home";
        }
        // return homeservice.getPage();
    }

    @RequestMapping(value = "/addq", method = RequestMethod.GET)
    public String addQuestion(Model model, HttpSession session) {
        user usr = (user) session.getAttribute("user");

        model.addAttribute("User", usr);
        model.addAttribute("question", new Question());
        return "addquestions";
    }

    @RequestMapping(value = "/submitquestion", method = RequestMethod.POST)
    public String submitquestion(Model model, @ModelAttribute("question") Question qstion, HttpSession session) {
        user usr = (user) session.getAttribute("user");
        qstion.setCreated_by(usr.getUserLoginId());
        qstion.setCreated_timestamp(new Date());
        homeservice.saveQuestion(qstion);
        model.addAttribute("question", new Question());
        model.addAttribute("message", "Question submited sucessfully");
        return "messagep";
    }

    @RequestMapping(value = "createqz", method = RequestMethod.GET)
    public String createQuiz(Model model, HttpSession session) {
        user usr = (user) session.getAttribute("user");
        ArrayList<Question> questions = homeservice.getQuestions(usr.getUserLoginId());
        model.addAttribute("questionsList", questions);

        model.addAttribute("User", usr);

        return "createqz";
    }

    @RequestMapping(value = "submitqz", method = RequestMethod.GET)
    public String submitqz(Model model, HttpSession session, @RequestParam("quizname") String quizname, @RequestParam("questions") String[] questionsids) {
        user usr = (user) session.getAttribute("user");

        quiz q = new quiz();
        q.setQuizname(quizname);
        q.setCreated_by(usr.getUserLoginId());
        q.setCreated_at(new Date());

        homeservice.saveQuiz(q, questionsids);
        model.addAttribute("message", "Quiz submited sucessfully");
        return "messagep";
    }

    @RequestMapping(value = "takeqz", method = RequestMethod.GET)
    public String takeqz(Model model, @RequestParam("qzid") String qzid, @RequestParam("qzname") String qzname, HttpSession session) {
        ArrayList<Question> qstions = homeservice.getQuestionsbyqzid(qzid);
        ArrayList<Question> qstions2 = new ArrayList<>();
        for (Question qs : qstions) {
            qs.setOption_one(qs.getOption_one().substring(1, qs.getOption_one().length()));
            qs.setOption_two(qs.getOption_two().substring(1, qs.getOption_two().length()));
            qs.setOption_three(qs.getOption_three().substring(1, qs.getOption_three().length()));
            qs.setOption_four(qs.getOption_four().substring(1, qs.getOption_four().length()));
            qs.setOption_five(qs.getOption_five().substring(1, qs.getOption_five().length()));

            qstions2.add(qs);
        }

        user usr = (user) session.getAttribute("user");
        model.addAttribute("username", usr.getUserLoginId());

        model.addAttribute("questionsList", qstions2);

        model.addAttribute("quizname", qzname);
        model.addAttribute("qzid", qzid);
        
        model.addAttribute("User", usr);

        return "takeqz";
    }

    @RequestMapping(value = "submittakenquiz", method = RequestMethod.GET)
    public String submittaketQz(Model model, HttpServletRequest request, HttpSession session, @RequestParam("sid") String sid, @RequestParam("qid") String qzid, @RequestParam("quizname") String quizname) {

        try {
            String[] question_ids = request.getParameterValues("questions");
            user usr = (user) session.getAttribute("user");
            int totalquestions = question_ids.length;
            int correct_answers = 0;

            for (int i = 0; i < question_ids.length; i++) {
                String[] answers = request.getParameterValues(question_ids[i]);

                if (homeservice.insertsubmitedAns(question_ids[i], answers, qzid, usr.getUserId())) {
                    correct_answers++;
                }

            }
            homeservice.saveResult(usr.getUserLoginId(), qzid, totalquestions, correct_answers, quizname);

//    mmap.get("qid");
//    String[] s= mmap.get("qid");
//    int c=1+2;
//    req.
            model.addAttribute("correct_answers", correct_answers);
            model.addAttribute("message", "You have scored :" + correct_answers + "/" + totalquestions);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "un able to submit quiz! only one quiz can be attend");
        }
        return "message";
    }

    @RequestMapping("pdashboard")
    public String showDashboard(Model model, HttpSession session) {

        ArrayList<result> resultarray = homeservice.getDashbardData();
        model.addAttribute("resultarray", resultarray);
        user usr = (user) session.getAttribute("user");

        model.addAttribute("User", usr);
        session.setAttribute("user", usr);
        return "professorhome";
    }

    @RequestMapping("shome")
    public String showstudentDashboard(Model model, HttpSession session) {
        user usr = (user) session.getAttribute("user");
        model.addAttribute("User", usr);
        model.addAttribute("quizlist", homeservice.getallquizList());
        return "studenthome";
    }

}
