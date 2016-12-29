package org.mindtree.assignment.repositories;

import org.mindtree.assignment.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Neetesh Narvaria - M1038226 on 12/24/2016.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
