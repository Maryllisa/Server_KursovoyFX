package data;

import java.util.Date;

public class Student {
    private int id_student;
    private String surname;
    private String name;
    private String patronymic;
    private int day;
    private int monthe;
    private int year;
    private int id_group;
    private String id_applications;
    private int id_report;

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }



    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getId_applications() {
        return id_applications;
    }

    public void setId_applications(String id_applications) {
        this.id_applications = id_applications;
    }

    public int getId_report() {
        return id_report;
    }

    public void setId_report(int id_report) {
        this.id_report = id_report;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonthe() {
        return monthe;
    }

    public void setMonthe(int monthe) {
        this.monthe = monthe;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
