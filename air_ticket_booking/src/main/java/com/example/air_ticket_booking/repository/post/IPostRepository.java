package com.example.air_ticket_booking.repository.post;

import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface IPostRepository extends JpaRepository<Post, Long> {

    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : createPost()
     *
     * @Param:title,flagPost,datePost,image,content,employeeId
     * @Return: void
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO post(title, flag_post, date_post, image, content, employee_id) " +
            "VALUES (:title, :flag_post, :date_post, :image, :content, :employeeId)", nativeQuery = true)
    void createPost(@Param("title") String title,
                    @Param("flag_post") boolean flagPost,
                    @Param("date_post") String datePost,
                    @Param("image") String image,
                    @Param("content") String content,
                    @Param("employeeId") Long employeeId);


    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : findPostById()
     *
     * @Param: id
     * @Return: Post
     */

    @Transactional
    @Query(value = "select * from post where id= :id", nativeQuery = true)
    Post findPostById(@Param("id") Long id);




    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : updatePost()
     *
     * @Param: title,datePost,image,content,employeeId,id
     * @Return: void
     */
    @Modifying
    @Transactional
    @Query(value = "update post set title= :title,date_post= :date_post,image= :image,content= :content,employee_id= :employee_id where post.id= :id", nativeQuery = true)
    void updatePost(@Param("title") String title,
                    @Param("date_post") String datePost,
                    @Param("image") String image,
                    @Param("content") String content,
                    @Param("employee_id") Long employeeId,
                    @Param("id") Long id);
}
