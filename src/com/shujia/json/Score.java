package com.shujia.json;

public class Score {
    private String id;
    private String name;
    private String cource;
    private Integer s;

    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cource='" + cource + '\'' +
                ", s=" + s +
                '}';
    }

    public Score() {
    }

    public Score(String id, String name, String cource, Integer s) {
        this.id = id;
        this.name = name;
        this.cource = cource;
        this.s = s;
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

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }
}
