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
@Entity
@Table(name = "professors")
public class professor {

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorDesg() {
        return professorDesg;
    }

    public void setProfessorDesg(String professorDesg) {
        this.professorDesg = professorDesg;
    }
    @Id
    @Column(name = "professor_id")
    private int professorId;
       @Column(name = "professor_name")
    private String professorName;
          @Column(name = "professor_desg")
    private String professorDesg;
             @Column(name = "professor_registered_at")
             private Date pregisteredAt;

    public Date getPregisteredAt() {
        return pregisteredAt;
    }

    public void setPregisteredAt(Date pregisteredAt) {
        this.pregisteredAt = pregisteredAt;
    }
    
    
}
