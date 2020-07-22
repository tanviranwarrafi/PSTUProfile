package com.rafyee.rafyee_rajiv.pstuprofile.Models;

public class StudentUnit {
    String name;
    String Id_no;
    String reg_no;
    String pass;
    String faculty;
    String batch;
    String contact;
    String email;

    public StudentUnit(String name, String id_no, String reg_no, String pass, String faculty, String batch, String contact, String email) {
        this.name = name;
        Id_no = id_no;
        this.reg_no = reg_no;
        this.pass = pass;
        this.faculty = faculty;
        this.batch = batch;
        this.contact = contact;
        this.email = email;
    }

    public StudentUnit() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_no() {
        return Id_no;
    }

    public void setId_no(String id_no) {
        Id_no = id_no;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

