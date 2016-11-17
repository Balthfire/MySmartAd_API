package com.models;

/**
 * Created by Menerith on 17/11/2016.
 */
public class CommentaryRequest {

    private int idcommentary;
    private double note;
    private String commenttext;
    private int iduser;
    private int idad;
    private int idplace;

    public CommentaryRequest(double note, String commenttext, int iduser, int idad, int idplace) {
        this.note = note;
        this.commenttext = commenttext;
        this.iduser = iduser;
        this.idad = idad;
        this.idplace = idplace;
    }

    public CommentaryRequest() {
    }

    public double getNote() {
        return note;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public int getIduser() {
        return iduser;
    }

    public int getIdad() {
        return idad;
    }

    public int getIdplace() {
        return idplace;
    }
}
