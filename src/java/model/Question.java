/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thinh
 */
public class Question {
    private int QuestionID;
    private String detail;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String trueAnswer;
    private int CollectionID;

    public Question() {
    }

    public Question(int QuestionID, String detail, String answerA, String answerB, String answerC, String answerD, String trueAnswer, int CollectionID) {
        this.QuestionID = QuestionID;
        this.detail = detail;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.trueAnswer = trueAnswer;
        this.CollectionID = CollectionID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public int getCollectionID() {
        return CollectionID;
    }

    public void setCollectionID(int CollectionID) {
        this.CollectionID = CollectionID;
    }

    @Override
    public String toString() {
        return "Question{" + "QuestionID=" + QuestionID + ", detail=" + detail + ", answerA=" + answerA + ", answerB=" + answerB + ", answerC=" + answerC + ", answerD=" + answerD + ", trueAnswer=" + trueAnswer + ", CollectionID=" + CollectionID + '}';
    }
    
    
}
