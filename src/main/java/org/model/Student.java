package org.model;

public class Student {
    private String name;
    private float averageMark;
    private boolean knowsBlockchain;

    public Student(){

    }

    public Student(String name, float averageMark, boolean knowsBlockchain){
        this.name = name;
        this.averageMark = averageMark;
        this.knowsBlockchain = knowsBlockchain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public boolean isKnowsBlockchain() {
        return knowsBlockchain;
    }

    public void setKnowsBlockchain(boolean knowsBlockchain) {
        this.knowsBlockchain = knowsBlockchain;
    }

    @Override
    public String toString() {
        return name + ", " + averageMark + ", " + knowsBlockchain;
    }
}
