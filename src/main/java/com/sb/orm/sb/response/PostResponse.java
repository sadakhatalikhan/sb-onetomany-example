package com.sb.orm.sb.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class PostResponse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("comment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<CommentResponse> comment = new HashSet<>();

    @JsonProperty("createdDate")
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm:ss")
    private LocalDateTime createdDate;

    @JsonProperty("updatedDate")
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm:ss")
    private LocalDateTime updatedDate;
}
