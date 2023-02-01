package com.example.learningtracker;

public class LearningModel {
    private String studentName;

    private String studentDept;

    private int sabak;
    private boolean sabakStatus;

    private int sabki;
    private boolean sabkiStatus;

    private int manzil;
    private boolean manzilStatus;

    private String incorrectSabak;
    private String incorrectSabki;
    private String incorrectMazil;


    public LearningModel(String studentName,String studentDept, int sabak, boolean sabakStatus, int sabki, boolean sabkiStatus, int manzil, boolean manzilStatus, String incorrectSabak, String incorrectSabki, String incorrectMazil) {
        this.studentName = studentName;
        this.studentDept=studentDept;
        this.sabak = sabak;
        this.sabakStatus = sabakStatus;
        this.sabki = sabki;
        this.sabkiStatus = sabkiStatus;
        this.manzil = manzil;
        this.manzilStatus = manzilStatus;
        this.incorrectSabak = incorrectSabak;
        this.incorrectSabki = incorrectSabki;
        this.incorrectMazil = incorrectMazil;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public int getSabak() {
        return sabak;
    }

    public void setSabak(int sabak) {
        this.sabak = sabak;
    }

    public boolean isSabakStatus() {
        return sabakStatus;
    }

    public void setSabakStatus(boolean sabakStatus) {
        this.sabakStatus = sabakStatus;
    }

    public int getSabki() {
        return sabki;
    }

    public void setSabki(int sabki) {
        this.sabki = sabki;
    }

    public boolean isSabkiStatus() {
        return sabkiStatus;
    }

    public void setSabkiStatus(boolean sabkiStatus) {
        this.sabkiStatus = sabkiStatus;
    }

    public int getManzil() {
        return manzil;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }

    public boolean isManzilStatus() {
        return manzilStatus;
    }

    public void setManzilStatus(boolean manzilStatus) {
        this.manzilStatus = manzilStatus;
    }

    public String getIncorrectSabak() {
        return incorrectSabak;
    }

    public void setIncorrectSabak(String incorrectSabak) {
        this.incorrectSabak = incorrectSabak;
    }

    public String getIncorrectSabki() {
        return incorrectSabki;
    }

    public void setIncorrectSabki(String incorrectSabki) {
        this.incorrectSabki = incorrectSabki;
    }

    public String getIncorrectMazil() {
        return incorrectMazil;
    }

    public void setIncorrectMazil(String incorrectMazil) {
        this.incorrectMazil = incorrectMazil;
    }


    @Override
    public String toString() {
        return "LearningModel{" +
                "studentName='" + studentName + '\'' +
                ", studentDept='" + studentDept + '\'' +
                ", sabak=" + sabak +
                ", sabakStatus=" + sabakStatus +
                ", sabki=" + sabki +
                ", sabkiStatus=" + sabkiStatus +
                ", manzil=" + manzil +
                ", manzilStatus=" + manzilStatus +
                ", incorrectSabak='" + incorrectSabak + '\'' +
                ", incorrectSabki='" + incorrectSabki + '\'' +
                ", incorrectMazil='" + incorrectMazil + '\'' +
                '}';
    }
}
