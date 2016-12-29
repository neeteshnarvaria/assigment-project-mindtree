package org.mindtree.assignment.service;

/**
 * Created by M1038226 on 12/29/2016.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}