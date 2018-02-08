/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizmanager.dao;

import com.quiz.quizmanager.pojos.Question;
import com.quiz.quizmanager.pojos.professor;
import com.quiz.quizmanager.pojos.quiz;
import com.quiz.quizmanager.pojos.result;
import com.quiz.quizmanager.pojos.student;
import com.quiz.quizmanager.pojos.user;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ramya
 */

public interface IHomeDao {
    public user getUserstatus(String userid,String password);

    public void saveQuestion(Question qstion);

    public ArrayList<Question> getQuestions(String userId);

    public void saveqz(quiz qz, String[] questionsids);

    public ArrayList<quiz> getallquizList();

    public ArrayList<Question> getQuestionsByid(String qzid);

    public boolean evaluteandinsert(String question_id, String[] answers,String qzid,int uid);
    public void saveResult(String userId, String qzid, int totalquestions, int correct_answers,String quizname);

    public boolean saveprofessor(user u, professor p);

    public boolean savestudent(user u, student s);

    public ArrayList<result> getDashbardData();
}
