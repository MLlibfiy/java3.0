package com.shujia.student;

public class Score {
    private String student_id;
    private String cource_id;
    private Integer score;

    public Score(String student_id, String cource_id, Integer score) {
        this.student_id = student_id;
        this.cource_id = cource_id;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "student_id='" + student_id + '\'' +
                ", cource_id='" + cource_id + '\'' +
                ", score=" + score +
                '}';
    }

    public Score() {
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCource_id() {
        return cource_id;
    }

    public void setCource_id(String cource_id) {
        this.cource_id = cource_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
