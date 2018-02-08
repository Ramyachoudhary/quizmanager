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

/**
 *
 * @author Ramya
 */
public interface IHomeService {

    public user checklogin(user user);

    public void saveQuestion(Question qstion);

    public ArrayList<Question> getQuestions(String userId);

    public void saveQuiz(quiz q, String[] questionsids);

    public ArrayList<quiz> getallquizList();

    public ArrayList<Question> getQuestionsbyqzid(String qzid);

    public boolean insertsubmitedAns(String question_id, String[] answers, String qzid, int uid);

    public void saveResult(String userId, String qzid, int totalquestions, int correct_answers, String quizname);
//    

    public boolean saveuser(String name, user u);

    public ArrayList<result> getDashbardData();

}
