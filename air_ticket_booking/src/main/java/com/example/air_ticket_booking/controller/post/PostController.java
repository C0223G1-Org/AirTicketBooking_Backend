package com.example.air_ticket_booking.controller.post;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.post.Post;
import com.example.air_ticket_booking.service.post.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/employee/post")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private IPostService iPostService;



    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : createPost()
     *
     * @Param:postDto
     * @Return: void
     */
    @PostMapping("")
    public ResponseEntity<?> createPosts(@Validated @RequestBody PostDto postDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        iPostService.createPost(postDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



        /**
         * Create by : TriPD
         * Date created : 10/08/2023
         * Function : findPostById()
         *
         * @Param: id
         * @Return: Post
         */
    @GetMapping("/findPost/{id}")
    public ResponseEntity<PostDto> findPostById(@PathVariable Long id){
        Post post = this.iPostService.findPostById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post, postDto);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }



    /**
     * Create by : TriPD
     * Date created : 10/08/2023
     * Function : savePost()
     *
     * @Param: postDto
     * @Return: void
     */
    @PatchMapping("/updatePost")
    public ResponseEntity<?> updatePost(@RequestBody PostDto postDto){
        try {
            iPostService.savePost(postDto);
            return ResponseEntity.ok(postDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(".....");
        }
    }
}