package org.mindtree.assignment.repositories;

import org.mindtree.assignment.models.Blog;
import org.mindtree.assignment.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by M1038226 on 12/24/2016.
 */
@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    public List<Comments> findCommentsByBlogId(long blogId);
}
