package com.sb.orm.sb.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "comments")
@Builder(toBuilder = true)
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_by")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
