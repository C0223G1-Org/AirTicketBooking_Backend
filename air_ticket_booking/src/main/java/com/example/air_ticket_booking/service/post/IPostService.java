package com.example.air_ticket_booking.service.post;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.post.Post;

public interface IPostService {
    void createPost(PostDto postDTO);

    Post findPostById(Long id);

    void savePost(PostDto postDto);
}
