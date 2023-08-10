package com.example.air_ticket_booking.controller.post;

import com.example.air_ticket_booking.model.post.Post;
import com.example.air_ticket_booking.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/post")
@RestController
@CrossOrigin("*")
public class PostController {
    @Autowired
    private IPostService iPostService;

    /**
     * Author: SonTT
     * handling:receive pagination data and find the service to perform the task, if empty,
     * return NOT_FOUND status otherwise return page and status ACCEPTED
     * @param page
     * @param limit
     * @return
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
     * Handling:Get data from the link and check the execution process, if it is correct,
     * return the message "Not found the document you want to delete" and the status NOT_FOUND otherwise return the OK status and return the message "Post deleted"
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id", required = false) Long id) {
        if (this.iPostService.deletePostById(id)) {
            String message = "Không tìm thấy tài Liệu muốn xoá ";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            String message = "Đã xoá bài viết ";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

}
