package com.sb.orm.sb.controller;

import com.sb.orm.sb.request.CommentRequest;
import com.sb.orm.sb.response.APIResponse;
import com.sb.orm.sb.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse> addComment(@RequestBody CommentRequest request) {
        return commentService.addComment(request);
    }
}
