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
    @Override
    public void createPost(PostDto postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        iPostRepository.createPost(
                post.getTitle(),
                post.getEmployee().getId(),
                post.getDatePost(),
                post.getImage(),
                post.getContent()
        );
    }
}
