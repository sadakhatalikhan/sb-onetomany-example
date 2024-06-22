package com.sb.orm.sb.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class CommentRequest {

    @JsonProperty("postId")
    private long postId;

    @JsonProperty("comment")
    private String comment;
}
