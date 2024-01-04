package com.example.mobprog_final;
public class Tweet {
    private String username;
    private String tweetText;
    private int userProfileImage; //
    private Integer tweetImage;
    private int likeCount;
    private int commentCount;
    private int dislikeCount;

    public Tweet(String username, String tweetText, int userProfileImage, Integer tweetImage, int likeCount, int commentCount, int dislikeCount) {
        this.username = username;
        this.userProfileImage= userProfileImage;
        this.tweetText = tweetText;
        this.tweetImage = tweetImage;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.dislikeCount = dislikeCount;
    }
    public Integer getTweetImage() {
        return tweetImage;
    }
    public String getUsername() {
        return username;
    }

    public String getTweetText() {
        return tweetText;
    }
    public int getUserProfileImage() {
        return userProfileImage;
    }
    public int getDislikeCount() {
        return dislikeCount;
    }
    public int getCommentCount() {
        return commentCount;
    }
    public int getLikeCount() {
        return likeCount;
    }


}

