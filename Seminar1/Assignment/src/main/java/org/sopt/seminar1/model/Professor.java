package org.sopt.seminar1.model;

public class Professor extends Department {
    private int id;
    private String name;
    private String phoneNum;
    private String type;

    public Professor(){
        super();
    }

    public Professor(int id, String name, String phoneNum, String type) {
        super();
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                "id : " + getId() + '\'' +
                ", name : '" + getName() + '\'' +
                ", phoneNum : '" + getPhoneNum() + '\'' +
                ", type : '" + getType();
    }
}
