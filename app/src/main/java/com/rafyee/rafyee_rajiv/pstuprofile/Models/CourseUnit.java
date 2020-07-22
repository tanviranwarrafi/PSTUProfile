package com.rafyee.rafyee_rajiv.pstuprofile.Models;

public class CourseUnit {
    String course_title;
    String course_code;
    String credit;
    String faculty;
    String semester;

    public CourseUnit(String course_title, String course_code, String credit, String faculty, String semester) {
        this.course_title = course_title;
        this.course_code = course_code;
        this.credit = credit;
        this.faculty = faculty;
        this.semester = semester;
    }

    public CourseUnit() {
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}

