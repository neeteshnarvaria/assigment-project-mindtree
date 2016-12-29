package org.mindtree.assignment.service;

import org.mindtree.assignment.models.User;

/**
 * Created by M1038226 on 12/29/2016.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
