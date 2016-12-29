package org.mindtree.assignment.models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by M1038226 on 12/29/2016.
 */
@Table
@Entity
public class TweetsBean{

    @Column
    @Id
    private long id;

    @Column
    private String idStr;

    @Column
    private String text;

    @Column
    private Date createdAt;

    @Column
    private String fromUser;

    @Column
    private String profileImageUrl;

    @Column
    private Long toUserId;

    @Column
    private Long inReplyToStatusId;

    @Column
    private Long inReplyToUserId;

    @Column
    private String inReplyToScreenName;

    @Column
    private String languageCode;

    @Column
    private String source;

    @Column
    private Integer retweetCount;

    @Column
    private boolean retweeted;

    @Column
    private boolean favorited;

    @Column
    private Integer favoriteCount;

    public long getId() {
        return id;
    }

    public String getIdStr() {
        return idStr;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public Long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public Long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getSource() {
        return source;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public TweetsBean(){

    }

    public TweetsBean(Builder builder) {
        this.id = builder.id;
        this.idStr = builder.idStr;
        this.text = builder.text;
        this.createdAt = builder.createdAt;
        this.fromUser = builder.fromUser;
        this.profileImageUrl = builder.profileImageUrl;
        this.toUserId = builder.toUserId;
        this.inReplyToStatusId = builder.inReplyToStatusId;
        this.inReplyToUserId = builder.inReplyToUserId;
        this.inReplyToScreenName = builder.inReplyToScreenName;
        this.languageCode = builder.languageCode;
        this.source = builder.source;
        this.retweetCount = builder.retweetCount;
        this.retweeted = builder.retweeted;
        this.favorited = builder.favorited;
        this.favoriteCount = builder.favoriteCount;
    }

    public class Builder{
        private long id;
        private String idStr;
        private String text;
        private Date createdAt;
        private String fromUser;
        private String profileImageUrl;
        private Long toUserId;
        private Long inReplyToStatusId;
        private Long inReplyToUserId;
        private String inReplyToScreenName;
        private String languageCode;
        private String source;
        private Integer retweetCount;
        private boolean retweeted;
        private boolean favorited;
        private Integer favoriteCount;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setIdStr(String idStr) {
            this.idStr = idStr;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setFromUser(String fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        public Builder setProfileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
            return this;
        }

        public Builder setToUserId(Long toUserId) {
            this.toUserId = toUserId;
            return this;
        }

        public Builder setInReplyToStatusId(Long inReplyToStatusId) {
            this.inReplyToStatusId = inReplyToStatusId;
            return this;
        }

        public Builder setInReplyToUserId(Long inReplyToUserId) {
            this.inReplyToUserId = inReplyToUserId;
            return this;
        }

        public Builder setInReplyToScreenName(String inReplyToScreenName) {
            this.inReplyToScreenName = inReplyToScreenName;
            return this;
        }

        public Builder setLanguageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public Builder setSource(String source) {
            this.source = source;
            return this;
        }

        public Builder setRetweetCount(Integer retweetCount) {
            this.retweetCount = retweetCount;
            return this;
        }

        public Builder setRetweeted(boolean retweeted) {
            this.retweeted = retweeted;
            return this;
        }

        public Builder setFavorited(boolean favorited) {
            this.favorited = favorited;
            return this;
        }

        public Builder setFavoriteCount(Integer favoriteCount) {
            this.favoriteCount = favoriteCount;
            return this;
        }

        public Builder() {
        }

        public TweetsBean build(){
            return new TweetsBean(this);
        }
    }

    @Override
    public String toString() {
        return "TweetsBean{" +
                "id=" + id +
                ", idStr='" + idStr + '\'' +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", fromUser='" + fromUser + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", toUserId=" + toUserId +
                ", inReplyToStatusId=" + inReplyToStatusId +
                ", inReplyToUserId=" + inReplyToUserId +
                ", inReplyToScreenName='" + inReplyToScreenName + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", source='" + source + '\'' +
                ", retweetCount=" + retweetCount +
                ", retweeted=" + retweeted +
                ", favorited=" + favorited +
                ", favoriteCount=" + favoriteCount +
                '}';
    }
}
