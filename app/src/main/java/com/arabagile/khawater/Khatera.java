package com.arabagile.khawater;

/**
 * Created by trainer on 12/11/16.
 */

public class Khatera {

    String authorPicture;
    String authorName;
    String date;
    String khateraText;
    int likes;

    public Khatera(String authorPicture, String authorName, String date, String khateraText, int likes) {
        this.authorPicture = authorPicture;
        this.authorName = authorName;
        this.date = date;
        this.khateraText = khateraText;
        this.likes = likes;
    }

    public String getAuthorPicture() {
        return authorPicture;
    }

    public void setAuthorPicture(String authorPicture) {
        this.authorPicture = authorPicture;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKhateraText() {
        return khateraText;
    }

    public void setKhateraText(String khateraText) {
        this.khateraText = khateraText;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
