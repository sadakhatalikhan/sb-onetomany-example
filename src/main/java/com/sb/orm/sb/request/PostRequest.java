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
public class PostRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

}
