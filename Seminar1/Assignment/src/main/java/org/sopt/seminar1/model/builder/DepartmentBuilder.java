package org.sopt.seminar1.model.builder;

import org.sopt.seminar1.model.Department;

public class DepartmentBuilder {
    private int depId;
    private String name;
    private String phoneNum;
    private String type;

    public DepartmentBuilder setDepId(int depId) {
        this.depId = depId;
        return this;
    }

    public DepartmentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DepartmentBuilder setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public DepartmentBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Department build(){
        return new Department(this.depId, this.name, this.phoneNum, this.type);
    }

}
