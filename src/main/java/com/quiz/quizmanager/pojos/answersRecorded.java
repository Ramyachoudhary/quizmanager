/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizmanager.pojos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ramya
 */
@Table(name = "answers_recorded")
@Entity
public class answersRecorded {
    @Id
    @Column(name = "answer_id")
    private int answerid;
     @Column(name = "student_id")
    private String student_id;
      @Column(name = "saved_answer")
    private String saved_answer;
       @Column(name = "	quiz_id")
    private String quiz_id;
        @Column(name = "answer_saved_timestamp")
    private Date answertimestamp;

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSaved_answer() {
        return saved_answer;
    }

    public void setSaved_answer(String saved_answer) {
        this.saved_answer = saved_answer;
    }

    public String getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(String quiz_id) {
        this.quiz_id = quiz_id;
    }

    public Date getAnswertimestamp() {
        return answertimestamp;
    }

    public void setAnswertimestamp(Date answertimestamp) {
        this.answertimestamp = answertimestamp;
    }
    
}
