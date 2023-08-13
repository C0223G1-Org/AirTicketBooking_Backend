package com.example.air_ticket_booking.dto.post;

import com.example.air_ticket_booking.model.employee.Employee;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PostDto {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private boolean flagPost;
    @NotBlank
    private String image;
    @NotBlank
    private String datePost;
   @NotNull
    private Employee employee;
    public PostDto() {
    }

    public PostDto(Long id, String title, String content, boolean flagPost, String image, String datePost, Employee employee) {
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

