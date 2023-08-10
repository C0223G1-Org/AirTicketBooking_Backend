package com.example.air_ticket_booking.service.post;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.post.Post;

import com.example.air_ticket_booking.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    void createPost(PostDto postDTO);

    Post findPostsById(Long id);

    void savePost(PostDto postDto);
    Page<Post> getListPost(Pageable pageable);
    Post findPostById(Long id);
    boolean deletePostById(Long id);
}
