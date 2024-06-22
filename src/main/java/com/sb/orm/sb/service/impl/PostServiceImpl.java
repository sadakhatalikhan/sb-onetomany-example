package com.sb.orm.sb.service.impl;

import com.sb.orm.sb.model.CommentModel;
import com.sb.orm.sb.model.PostModel;
import com.sb.orm.sb.repository.PostRepository;
import com.sb.orm.sb.request.CommentRequest;
import com.sb.orm.sb.request.PostRequest;
import com.sb.orm.sb.response.APIResponse;
import com.sb.orm.sb.response.PostResponse;
import com.sb.orm.sb.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.sb.orm.sb.constants.AppConstants.*;
import static com.sb.orm.sb.mapper.AppMapper.*;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public ResponseEntity<APIResponse> createPost(PostRequest request) {

        PostModel model = postRepository.save(requestToPostModel(request));

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_STORED)
                        .data(PostResponse.builder()
                                .id(model.getId())
                                .title(model.getTitle())
                                .description(model.getDescription())
                                .createdDate(model.getCreatedDate())
                                .updatedDate(model.getUpdatedDate())
                                .build())
                        .build()
        );
    }

    @Override
    public ResponseEntity<APIResponse> getAllPosts() {
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_RETRIEVED)
                        .data(postRepository.findAll().stream()
                                .map(model -> modelToPostResponseMapper(model))
                                .collect(Collectors.toSet()))
                        .build()
        );
    }
}
