package com.sb.orm.sb.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class CommentResponse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("postId")
    private Long postId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("createdDate")
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm:ss")
    private LocalDateTime createdDate;

    @JsonProperty("updatedDate")
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm:ss")
    private LocalDateTime updatedDate;
}