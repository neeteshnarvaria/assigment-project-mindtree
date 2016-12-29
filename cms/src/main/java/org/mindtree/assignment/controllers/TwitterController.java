package org.mindtree.assignment.controllers;

import org.mindtree.assignment.models.TweetsBean;
import org.mindtree.assignment.repositories.TweetsBeanRepository;
import org.mindtree.assignment.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @Autowired
    private TweetsBeanRepository tweetsBeanRepository;

    @RequestMapping(value = "/timeline/{twitterUser}")
    public String getUserTimeline(@PathVariable String twitterUser, Model model) {
        model.addAttribute("tweets", twitterService.getUserTimeline(twitterUser));
        model.addAttribute("user", twitterUser);

        return "timeline";
    }

    @RequestMapping(value = "/timeline/tweets/{twitterUser}",produces = "application/json")
    @ResponseBody
    public List<TweetsBean> getUserTimelineOnPage(@PathVariable String twitterUser, Model model) {
        List<Tweet> userTimeline = twitterService.getUserTimeline(twitterUser);
        model.addAttribute("user", twitterUser);
        List<TweetsBean> byTwitterUser = tweetsBeanRepository.findByFromUser(twitterUser);
        if(!byTwitterUser.isEmpty()) {
            tweetsBeanRepository.delete(byTwitterUser);
        }
        List<TweetsBean> tweetsBeanList = new ArrayList<>();
        for(Tweet tweet : userTimeline){
            TweetsBean tweetsBean = new TweetsBean().new Builder()
                    .setId(tweet.getId())
                    .setCreatedAt(tweet.getCreatedAt())
                    .setFavoriteCount(tweet.getFavoriteCount())
                    .setFavorited(tweet.isFavorited())
                    .setFromUser(tweet.getFromUser())
                    .setIdStr(tweet.getIdStr())
                    .setInReplyToScreenName(tweet.getInReplyToScreenName())
                    .setInReplyToUserId(tweet.getInReplyToUserId())
                    .setLanguageCode(tweet.getLanguageCode())
                    .setProfileImageUrl(tweet.getProfileImageUrl())
                    .setInReplyToStatusId(tweet.getInReplyToStatusId())
                    .setRetweetCount(tweet.getRetweetCount())
                    .setSource(tweet.getSource())
                    .setText(tweet.getText())
                    .setRetweeted(tweet.isRetweeted())
                    .setToUserId(tweet.getToUserId())
                    .build();
            tweetsBeanList.add(tweetsBean);
        }
        tweetsBeanRepository.save(tweetsBeanList);
        return tweetsBeanList;
    }


    @RequestMapping(value = "/profile/{twitterUser}")
    public String getUserProfile(@PathVariable String twitterUser, Model model) {
        model.addAttribute("userProfile", twitterService.getUserProfile(twitterUser));

        return "profile";
    }
}
