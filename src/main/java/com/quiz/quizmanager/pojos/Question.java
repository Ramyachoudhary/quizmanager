/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizmanager.pojos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ramya
 */
@Entity
@Table(name = "questions")
public class Question {
    
    @Id
    @Column(name = "question_id")
      @GeneratedValue(strategy = GenerationType.AUTO)
    private int question_id;
    @Column(name = "question_title")
    private String question_title;
    
    @Column(name = "option_one")
    private String option_one;
    @Column(name = "option_two")
    private String option_two;
    @Column(name = "option_three")
    private String option_three;
        @Column(name = "option_four")
    private String option_four;
          @Column(name = "option_five")
    private String option_five;
              @Column(name = "created_by")
    private String created_by;
                     @Column(name = "created_timestamp")
    private Date created_timestamp;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getOption_one() {
        return option_one;
    }

    public void setOption_one(String option_one) {
        this.option_one = option_one;
    }

    public String getOption_two() {
        return option_two;
    }

    public void setOption_two(String option_two) {
        this.option_two = option_two;
    }

    public String getOption_three() {
        return option_three;
    }

    public void setOption_three(String option_three) {
        this.option_three = option_three;
    }

    public String getOption_four() {
        return option_four;
    }

    public void setOption_four(String option_four) {
        this.option_four = option_four;
    }

    public String getOption_five() {
        return option_five;
    }

    public void setOption_five(String option_five) {
        this.option_five = option_five;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(Date created_timestamp) {
        this.created_timestamp = created_timestamp;
    }
    
                     
                     
}
