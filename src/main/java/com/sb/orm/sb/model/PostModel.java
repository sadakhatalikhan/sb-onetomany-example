package com.sb.orm.sb.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Set<CommentModel> comment = new HashSet<>();

    @Column(name = "created_by")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
