package org.sopt.seminar1.model;

public class Department extends University{
    private int depId;
    private String name;
    private String phoneNum;
    private String type;

    public Department() {
        super();
    }

    public Department(int depId, String name, String phoneNum, String type) {
        super();
        this.depId = depId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.type = type;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
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
                "depId : " + getDepId() +
                ", name : '" + getName() + '\'' +
                ", phoneNum : '" + getPhoneNum() + '\'' +
                ", type : '" + getType() + '\'' ;
    }
}
