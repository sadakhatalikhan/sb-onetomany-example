package com.sb.orm.sb.repository;

import com.sb.orm.sb.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<CommentModel, Long> {
}
