package com.kreuzfeuer.application.model;

public class Task {
    private String name;

    private boolean status;

    public Task(String name) {
        this.name = name;
        this.status = false;
    }

    public String getFullDescription(){
        if(status){
            return "[X] " + name;
        }
        return "[ ] " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
