package org.mindtree.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by M1038226 on 12/29/2016.
 */
@Service
public class TwitterService {

    @Autowired
    private Twitter twitter;

    public List<Tweet> getUserTimeline(String twitterUser) {
        TimelineOperations timelineOps = twitter.timelineOperations();
        List tweets = timelineOps.getUserTimeline("@" + twitterUser);

        return tweets;
    }

    public TwitterProfile getUserProfile(String twitterUser) {
        UserOperations userOperations = twitter.userOperations();
        TwitterProfile userProfile = userOperations.getUserProfile(twitterUser);
        return userProfile;
    }
}