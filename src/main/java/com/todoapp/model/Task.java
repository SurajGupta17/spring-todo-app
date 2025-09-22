package com.todoapp.model;

import jakarta.persistence.*;

@Entity
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String title;
    private boolean completed;

    //getter and setter

    public Long getId(){
        return ID;
    }
    public void setId(long Id){
        this.ID = Id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public boolean isCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }

}