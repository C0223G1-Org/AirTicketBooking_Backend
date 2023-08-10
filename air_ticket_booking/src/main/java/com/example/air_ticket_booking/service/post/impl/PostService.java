package com.example.air_ticket_booking.service.post.impl;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.post.Post;
import com.example.air_ticket_booking.repository.post.IPostRepository;
import com.example.air_ticket_booking.service.post.IPostService;
import org.springframework.beans.BeanUtils;
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
    public Post findPostsById(Long id) {
        return iPostRepository.findPostsById(id);
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
        Post post = iPostRepository.findPostsById(postDto.getId());
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

        /**
         * Author: SonTT
         * Date create: 10/8/2023
         * Handling:Get data from the call link to the corresponding repository to check if it exists or not, if not, return null otherwise, return the data received from the repository
         * @param id
         * @return Post
         */

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
