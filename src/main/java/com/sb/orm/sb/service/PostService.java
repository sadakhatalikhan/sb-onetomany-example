package com.sb.orm.sb.service;

import com.sb.orm.sb.request.CommentRequest;
import com.sb.orm.sb.request.PostRequest;
import com.sb.orm.sb.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<APIResponse> createPost(PostRequest request);
    ResponseEntity<APIResponse> getAllPosts();
}
