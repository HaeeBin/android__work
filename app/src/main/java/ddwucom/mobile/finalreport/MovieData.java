package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class MovieData implements Serializable {

    long _id;
    String time;
    String score;
    int img;
    String title;
    String actor;
    String director;
    String day;
    String story;


    public MovieData(long _id, int img, String title, String actor, String day, String score, String time, String director, String story) {
        this._id = _id;
        this.img = img;
        this.title = title;
        this.actor = actor;
        this.day = day;
        this.score = score;
        this.time = time;
        this.director = director;
        this.story = story;

    }

    public MovieData(String title, String actor, String day, String score) {
        this.title = title;
        this.actor = actor;
        this.day = day;
        this.score = score;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
