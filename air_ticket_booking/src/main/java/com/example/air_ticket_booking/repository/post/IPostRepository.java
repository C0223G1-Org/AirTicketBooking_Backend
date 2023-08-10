package com.example.air_ticket_booking.repository.post;

import com.example.air_ticket_booking.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post,Long> {


    Page<Post> getListPostByFlag_
}
