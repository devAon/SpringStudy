package org.sopt.seminar1.model.builder;

import org.sopt.seminar1.model.Student;

public class StudentBuilder {
    private String name;
    private String major;
    private String eMail;
    private String address;
    private String state;
    private int id;
    private int grade;
    private int age;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setMajor(String major) {
        this.major = major;
        return this;
    }

    public StudentBuilder seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public Student build(){
        return new Student (this.name, this.major, this.eMail , this.address , this.state , this.id , this.grade , this.age);
    }
}
