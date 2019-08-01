/*package org.sopt.seminar2.model;*/
package org.sopt.seminar2.model;

public class User {
    private int userIdx;
    private String name;
    private String part;
    private String type;

    public User() {
    }

    public User(int userIdx, String name, String part, String type) {
        this.userIdx = userIdx;
        this.name = name;
        this.part = part;
        this.type = type;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "userIdx : " + getUserIdx() +
                ", username : " + getName() +
                ", userpart : " + getPart() +
                ", usertype : " + getType() + "\n";
    }
}
