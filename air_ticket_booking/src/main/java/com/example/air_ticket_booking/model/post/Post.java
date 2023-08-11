package com.example.air_ticket_booking.model.post;

import com.example.air_ticket_booking.model.employee.Employee;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private boolean flagPost;
    private String image;
    private String datePost;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    public Post() {
    }

    public Post(Long id, String title, String content, boolean flagPost, String image, String datePost, Employee employee) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.flagPost = flagPost;
        this.image = image;
        this.datePost = datePost;
        this.employee = employee;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isFlagPost() {
        return flagPost;
    }

    public void setFlagPost(boolean flagPost) {
        this.flagPost = flagPost;
    }
}
