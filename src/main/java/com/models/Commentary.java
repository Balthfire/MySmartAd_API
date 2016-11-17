package com.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="Commentary")
public class Commentary {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_commentary")
    private int idcommentary;
    @NotNull
    @Column(name = "note")
    private double note;
    @NotNull
    @Column(name = "comment_text")
    private String commenttext;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_ad")
    private Advertisement ad;
    @ManyToOne
    @JoinColumn(name = "id_place")
    private Place place;

    public Commentary(double note, String commenttext, User user, Advertisement ad, Place place) {
        this.note = note;
        this.commenttext = commenttext;
        this.user = user;
        this.ad = ad;
        this.place = place;
    }

    public Commentary() {
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Advertisement getAd() {
        return ad;
    }

    public void setAd(Advertisement ad) {
        this.ad = ad;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
