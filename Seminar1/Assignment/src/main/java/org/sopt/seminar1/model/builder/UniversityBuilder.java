package org.sopt.seminar1.model.builder;

import org.sopt.seminar1.model.University;

public class UniversityBuilder {
    private int id;
    private String name;
    private String phoneNum;
    private String address;

    public UniversityBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UniversityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UniversityBuilder setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public UniversityBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public University build(){
        return new University(this.id, this.name, this.phoneNum, this.address);
    }
}
