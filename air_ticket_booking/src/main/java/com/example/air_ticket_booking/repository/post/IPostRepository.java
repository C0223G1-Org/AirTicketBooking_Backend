package com.example.air_ticket_booking.repository.post;

import com.example.air_ticket_booking.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface IPostRepository extends JpaRepository<Post,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Post(title, employee_id, date_post, image, content) VALUES (:title, :employee_id, :date_post, :image, :content)",nativeQuery = true)
    void createPost(@Param("title")String title,@Param("employee_id")Long employee_id,@Param("datePost")LocalDateTime date_post,@Param("image") String image,@Param("content") String content);
}
