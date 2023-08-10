package com.example.air_ticket_booking.service.post;


import com.example.air_ticket_booking.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<Post> getListPost(Pageable pageable);
    Post findPostById(Long id);
    boolean deletePostById(Long id);
}
