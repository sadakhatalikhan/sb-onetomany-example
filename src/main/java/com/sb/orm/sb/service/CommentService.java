package com.sb.orm.sb.service;

import com.sb.orm.sb.request.CommentRequest;
import com.sb.orm.sb.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<APIResponse> addComment(CommentRequest request);
}
