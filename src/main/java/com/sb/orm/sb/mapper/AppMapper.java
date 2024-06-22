package com.sb.orm.sb.mapper;

import com.sb.orm.sb.model.CommentModel;
import com.sb.orm.sb.model.PostModel;
import com.sb.orm.sb.request.CommentRequest;
import com.sb.orm.sb.request.PostRequest;
import com.sb.orm.sb.response.CommentResponse;
import com.sb.orm.sb.response.PostResponse;

import java.util.Set;
import java.util.stream.Collectors;

public class AppMapper {

    public static PostModel requestToPostModel(PostRequest request) {
        return PostModel.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
    }

    public static CommentModel requestToCommentModel(CommentRequest request) {
        return CommentModel.builder()
                .postId(request.getPostId())
                .comment(request.getComment())
                .build();
    }

    public static PostResponse modelToPostResponseMapper(PostModel model) {
        return PostResponse.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .comment(commentsResponseMapper(model.getComment()))
                .createdDate(model.getCreatedDate())
                .updatedDate(model.getUpdatedDate())
                .build();
    }

    private static Set<CommentResponse> commentsResponseMapper(Set<CommentModel> models) {
        return models.stream()
                .map(model ->
                        CommentResponse.builder()
                                .id(model.getId())
                                .postId(model.getPostId())
                                .comment(model.getComment())
                                .createdDate(model.getCreatedDate())
                                .updatedDate(model.getUpdatedDate())
                                .build())
                .collect(Collectors.toSet());
    }
}
