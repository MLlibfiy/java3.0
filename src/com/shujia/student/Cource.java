package com.shujia.student;

public class Cource {
    private String id;
    private String name;
    private Integer sumScore;

    public Cource(String id, String name, Integer sumScore) {
        this.id = id;
        this.name = name;
        this.sumScore = sumScore;
    }

    @Override
    public String toString() {
        return "Cource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sumScore=" + sumScore +
                '}';
    }

    public Cource() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSumScore() {
        return sumScore;
    }

    public void setSumScore(Integer sumScore) {
        this.sumScore = sumScore;
    }
}
