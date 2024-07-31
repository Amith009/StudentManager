package com.example.demo6;

public class APIResponse {
    public int userId;
    public int id;
    public String title;
    public String body;
    public String type;
    public String setup;
    public String punchline;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return setup;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return punchline;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
