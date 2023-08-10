package com.example.air_ticket_booking.controller.post;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/employee/post")
@RestController
@CrossOrigin("*")
public class PostController {
    @Autowired
    private IPostService iPostService;

    @PostMapping("")
    public ResponseEntity<PostDto> createPosts(@Valid @RequestBody PostDto postDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iPostService.createPost(postDTO);
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }
}
