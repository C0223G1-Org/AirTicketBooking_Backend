package com.example.air_ticket_booking.repository.post;

import com.example.air_ticket_booking.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public interface IPostRepository extends JpaRepository<Post,Long> {
    /**
     * Author: SonTT
     * Handling method: run method with query and connect database to get data
     * @param pageable
     * @return Page<T>
     */
    @Query(value = "SELECT * FROM Post WHERE Post.flag_post = false",nativeQuery = true)
    Page<Post> getListPostByFlag(Pageable pageable );

    @Query(value = "SELECT * FROM Post JOIN Employee ON Employee.id_employee = Post.employee_id WHERE Post.flag_post = false and Post.id = :id",nativeQuery = true)
    Optional<Post> findPostById(@Param("id") Long id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Post SET Post.flag_post = true WHERE Post.id = :id",nativeQuery = true)
    void deletePostById(@Param("id") Long id);


}



