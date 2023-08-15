package com.example.air_ticket_booking.controller.post;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.post.Post;
import com.example.air_ticket_booking.model.post.Post;
import com.example.air_ticket_booking.service.post.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/post")
@RestController
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
     * Author: SonTT
     * handling:receive pagination data and find the service to perform the task, if empty,
     * return NOT_FOUND status otherwise return page and status ACCEPTED
     * @param page
     * @param limit
     * @return ResponseEntity<Page < Post>>
     */
    @GetMapping("/{page}/{limit}")
    public ResponseEntity<Page<Post>> getListPost(@PathVariable(value = "page", required = false) Integer page, @PathVariable(value = "limit", required = false) Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        if (this.iPostService.getListPost(pageable).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.iPostService.getListPost(pageable), HttpStatus.ACCEPTED);
    }

    /**
     * Author: SonTT
     * Date create: 14/08/2023
     * Handling: Get data by calling service
     * @return
     */
    @GetMapping("/hot-news")
    public ResponseEntity<List<Post>> HotNewList(){
        if (this.iPostService.getListPostHotNews().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(this.iPostService.getListPostHotNews(),HttpStatus.OK);
        }
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
    public ResponseEntity<PostDto> findPostById(@PathVariable Long id) {
        Post post = this.iPostService.findPostsById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post, postDto);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    /**
     * Author: SonTT
     * Handling:Get data from the link and check the execution process, if it is correct,
     * return the message "Not found the document you want to delete" and the status NOT_FOUND otherwise return the OK status and return the message "Post deleted"
     *
     * @param id
     * @return message and status
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id",required = false) Long id) {
        if (id==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (this.iPostService.deletePostById(id)) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( HttpStatus.OK);
        }

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
    public ResponseEntity<?> updatePost(@Validated @RequestBody PostDto postDto,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iPostService.savePost(postDto);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
//        try {
//            iPostService.savePost(postDto);
//            return ResponseEntity.ok(postDto);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(".....");
//        }
    }

    /**
     * Author: SonTT
     * Date create: 14/08/2023
     * Handling: Get param title get data by calling service
     * @param title
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<Post>> searchPost(@RequestParam(value = "title",required = false) String title){
        String titles = title.toString().trim();
        if (iPostService.searchPostByTitle(titles).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iPostService.searchPostByTitle(titles),HttpStatus.OK);
    }
 }