package org.sopt.seminar2.model;

public class Toy {
    private int id;
    private String name;

    public Toy() {
    }

    public Toy(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return
                "ToyId : " + getId() +
                        ", ToyName : " + getName();
    }
}
