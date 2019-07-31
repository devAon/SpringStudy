package org.sopt.seminar1.model.builder;

import org.sopt.seminar1.model.Professor;

public class ProfessorBuilder {
    private int id;
    private String name;
    private String phoneNum;
    private String type;

    public ProfessorBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ProfessorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProfessorBuilder setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public ProfessorBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Professor build(){
        return new Professor(this.id, this.phoneNum, this.name, this.type);
    }
}
