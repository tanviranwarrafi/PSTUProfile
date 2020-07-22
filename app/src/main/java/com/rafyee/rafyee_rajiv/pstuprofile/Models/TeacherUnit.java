package com.rafyee.rafyee_rajiv.pstuprofile.Models;

public class TeacherUnit {
    String t_name;
    String t_post;
    String t_faculty;
    String t_dept;
    String t_pass;
    String t_contact;
    String t_email;

    public TeacherUnit(String t_name, String t_post, String t_faculty, String t_dept, String t_pass, String t_contact, String t_email) {
        this.t_name = t_name;
        this.t_post = t_post;
        this.t_faculty = t_faculty;
        this.t_dept = t_dept;
        this.t_pass = t_pass;
        this.t_contact = t_contact;
        this.t_email = t_email;
    }

    public TeacherUnit( ) {
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_post() {
        return t_post;
    }

    public void setT_post(String t_post) {
        this.t_post = t_post;
    }

    public String getT_faculty() {
        return t_faculty;
    }

    public void setT_faculty(String t_faculty) {
        this.t_faculty = t_faculty;
    }

    public String getT_dept() {
        return t_dept;
    }

    public void setT_dept(String t_dept) {
        this.t_dept = t_dept;
    }

    public String getT_pass() {
        return t_pass;
    }

    public void setT_pass(String t_pass) {
        this.t_pass = t_pass;
    }

    public String getT_contact() {
        return t_contact;
    }

    public void setT_contact(String t_contact) {
        this.t_contact = t_contact;
    }

    public String getT_email() {
        return t_email;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }
}

