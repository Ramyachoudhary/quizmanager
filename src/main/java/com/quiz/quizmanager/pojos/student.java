/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizmanager.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ramya
 */
@Entity
@Table(name = "student")
public class student {
    @Id
    @Column(name = "student_id")
    private int studentid;
     @Column(name = "student_name")
     private String studentname;
     @Column(name = "student_group_id")
     private String sdgid;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getSdgid() {
        return sdgid;
    }

    public void setSdgid(String sdgid) {
        this.sdgid = sdgid;
    }
    
}
