package com.kokushiseiya.tree;

/**
 * アイデアに関するクラス
 */
public class Idea {
    private User mUser;
    private String mTitle;
    private String mText;
    private int mLikeNum;
    private boolean mIsClosed;
    private String timeStampKey;

    /**
     * コンストラクタ
     * @param user
     * @param text
     * @param likeNum
     * @param isClosed
     */
    public Idea(User user, String title, String text, int likeNum, boolean isClosed) {
        mUser = user;
        mTitle = title;
        mText = text;
        mLikeNum = likeNum;
        mIsClosed = isClosed;
    }

    public Idea(User user, String title, String text) {
        mUser = user;
        mTitle = title;
        mText = text;

        mLikeNum = 0;
        mIsClosed = false;

    }

    public User getmUser() {
        return mUser;
    }

    public String getmText() {
        return mText;
    }

    public int getmLikeNum() {
        return mLikeNum;
    }

    public String getmTitle() {
        return mTitle;
    }
}
