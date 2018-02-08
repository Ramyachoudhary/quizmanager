package com.quiz.quizmanager.pojos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "quizresult")
public class result{
    @Id
    @Column(name = "resultid")
    private int resultid;
        @Column(name = "quiz_id")

    private String quiz_id;
      @Column(name = "total_no_questions")
    private int total_no_questions;
         @Column(name = "total_answered")
    private int total_answered;
       @Column(name = "correct_answers")
    private int correct_answers;
     @Column(name = "quiz_submited_at")
    private Date quiz_submited_at;
     
     
     @Column(name = "user_id")
     private String user_id;
      @Column(name = "quiz_name")
     private String quiz_name;

    public String getUser_id() {
        return user_id;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getResultid() {
        return resultid;
    }

    public void setResultid(int resultid) {
        this.resultid = resultid;
    }

    public String getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(String quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getTotal_no_questions() {
        return total_no_questions;
    }

    public void setTotal_no_questions(int total_no_questions) {
        this.total_no_questions = total_no_questions;
    }

    public int getTotal_answered() {
        return total_answered;
    }

    public void setTotal_answered(int total_answered) {
        this.total_answered = total_answered;
    }

    public int getCorrect_answers() {
        return correct_answers;
    }

    public void setCorrect_answers(int correct_answers) {
        this.correct_answers = correct_answers;
    }

    public Date getQuiz_submited_at() {
        return quiz_submited_at;
    }

    public void setQuiz_submited_at(Date quiz_submited_at) {
        this.quiz_submited_at = quiz_submited_at;
    }
     
     
    
}