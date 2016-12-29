package org.mindtree.assignment.repositories;

import org.mindtree.assignment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by M1038226 on 12/28/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
