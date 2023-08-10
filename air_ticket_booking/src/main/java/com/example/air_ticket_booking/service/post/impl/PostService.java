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

    /**
     * Author: SonTT
     * Date create: 10/8/2023
     * Handling: Get data from link, call repository corresponding to return data
     * @param pageable
     * @return Page<Post>
     */
    @Override
    public Page<Post> getListPost(Pageable pageable) {
        return iPostRepository.getListPostByFlag(pageable);
    }

    /**
     * Author: SonTT
     * Date create: 10/8/2023
     * Handling:Get data from the call link to the corresponding repository to check if it exists or not, if not, return null otherwise, return the data received from the repository
     * @param id
     * @return Post
     */
    @Override
    public Post findPostById(Long id) {
        if (!iPostRepository.findPostById(id).isPresent()){
            return null;
        }else {
            return iPostRepository.findPostById(id).get();
        }
    }

    /**
     * Author: SonTT
     * Date create: 10/8/2023
     * Handling: get data from link call findPostById() method to check if null or not, return true otherwise, update flag returns false
     * @param id
     * @return boolean
     */
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
