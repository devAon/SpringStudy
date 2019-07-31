package org.sopt.seminar1.model;

public class Student extends Department{
    private String name;
    private String major;
    private String eMail;
    private String address;
    private String state;
    private int id;
    private int grade;
    private int age;

    public Student(){
        super();
    }

    public Student(String name, String major, String eMail, String address, String state, int id, int grade, int age) {
        this.name = name;
        this.major = major;
        this.eMail = eMail;
        this.address = address;
        this.state = state;
        this.id = id;
        this.grade = grade;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) { this.grade = grade; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return
                "id : " + getId() + '\'' +
                ", grade : " + getGrade() + '\'' +
                ", age : " + getAge() + '\'' +
                ", name : '" + getName() + '\'' +
                ", major : '" + getMajor() + '\'' +
                ", eMail : '" + geteMail() + '\'' +
                ", address : '" + getAddress() + '\'' +
                ", state : " + getState();
    }
}