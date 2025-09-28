// package com.todoapp.model;

// import jakarta.persistence.*;

// @Entity
// public class Task{

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long ID;

//     private String title;
//     private boolean completed;

//     //getter and setter

//     public Long getId(){
//         return ID;
//     }
//     public void setId(long Id){
//         this.ID = Id;
//     }

//     public String getTitle(){
//         return title;
//     }
//     public void setTitle(String title){
//         this.title = title;
//     }

//     public boolean isCompleted(){
//         return completed;
//     }
//     public void setCompleted(boolean completed){
//         this.completed = completed;
//     }

// }

package com.todoapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task")  // Specify table name
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Changed to Long (capital L)

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private Boolean completed = false;  // Changed to Boolean

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    
    // For backwards compatibility
    public boolean isCompleted() {
        return completed != null ? completed : false;
    }
}