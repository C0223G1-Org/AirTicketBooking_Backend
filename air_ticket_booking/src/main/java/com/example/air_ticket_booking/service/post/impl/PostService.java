package com.example.air_ticket_booking.service.post.impl;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.post.Post;
import com.example.air_ticket_booking.repository.post.IPostRepository;
import com.example.air_ticket_booking.service.post.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;

    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : createPost()
     *
     * @Param:postDto
     * @Return: void
     */
    @Override
    public void createPost(PostDto postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        iPostRepository.createPost(
                post.getTitle(),
                post.isFlagPost(),
                post.getDatePost(),
                post.getImage(),
                post.getContent(),
                post.getEmployee().getIdEmployee()
        );
    }




    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : findPostById()
     *
     * @Param: id
     * @Return: Post
     */
    @Override
    public Post findPostById(Long id) {
        return iPostRepository.findPostById(id);
    }





    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : updatePost()
     *
     * @Param: postDto
     * @Return: void
     */
    @Override
    public void savePost(PostDto postDto) {
        Post post = iPostRepository.findPostById(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDatePost(postDto.getDatePost());
        post.setImage(postDto.getImage());
        post.setContent(postDto.getContent());
        post.setEmployee(postDto.getEmployee());
        iPostRepository.updatePost(
                post.getTitle(),
                post.getDatePost(),
                post.getImage(),
                post.getContent(),
                post.getEmployee().getIdEmployee(),
                post.getId()
        );
    }
}
