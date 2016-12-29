package org.mindtree.assignment.repositories;

import org.mindtree.assignment.models.TweetsBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by M1038226 on 12/29/2016.
 */
@Repository
public interface TweetsBeanRepository extends JpaRepository<TweetsBean,Long> {
    public List<TweetsBean> findByFromUser(String findByFromUser);
}
