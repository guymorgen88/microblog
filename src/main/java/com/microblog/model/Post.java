package com.microblog.model;
import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// tells spring that Post.java is an entry,
@Entity
public class Post {
    // tells Spring that “id” is a primary key
    @Id
    // tells Spring that the field is auto-generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String content;
    private int upvotes;
    private int downvotes;
    private String createdtime;

    public Post() {  }

    public Post(String title, String content) {
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(new Post());
    }
}