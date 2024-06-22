package com.sb.orm.sb.service.impl;

import com.sb.orm.sb.model.CommentModel;
import com.sb.orm.sb.repository.CommentsRepository;
import com.sb.orm.sb.request.CommentRequest;
import com.sb.orm.sb.response.APIResponse;
import com.sb.orm.sb.response.CommentResponse;
import com.sb.orm.sb.response.PostResponse;
import com.sb.orm.sb.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.sb.orm.sb.constants.AppConstants.SUCCESSFULLY_STORED;
import static com.sb.orm.sb.constants.AppConstants.SUCCESS_CODE;
import static com.sb.orm.sb.mapper.AppMapper.requestToCommentModel;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentsRepository commentsRepository;

    @Override
    public ResponseEntity<APIResponse> addComment(CommentRequest request) {
        CommentModel model = commentsRepository.save(requestToCommentModel(request));

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_STORED)
                        .data(CommentResponse.builder()
                                .id(model.getId())
                                .postId(model.getPostId())
                                .comment(model.getComment())
                                .createdDate(model.getCreatedDate())
                                .updatedDate(model.getUpdatedDate())
                                .build())
                        .build()
        );
    }
}
