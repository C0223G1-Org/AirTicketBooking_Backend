package com.example.air_ticket_booking.service.post.impl;

import com.example.air_ticket_booking.model.post.Post;
import com.example.air_ticket_booking.repository.post.IPostRepository;
import com.example.air_ticket_booking.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public Page<Post> getListPost(Pageable pageable) {
        return iPostRepository.getListPostByFlag(pageable);
    }

    @Override
    public Post findPostById(Long id) {
//        try {
//            return iPostRepository.findPostById(id).get();
//        }catch (NoSuchElementException e){
//            return null;
//        }
        if (!iPostRepository.findPostById(id).isPresent()){
            return null;
        }else {
            return iPostRepository.findPostById(id).get();
        }
    }

    @Override
    public boolean deletePostById(Long id) {
        if (findPostById(id)==null){
            return true;
        }else {
            iPostRepository.deletePostById(id);
            return false;
        }
    }
}
