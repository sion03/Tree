package com.kokushiseiya.tree;

/**
 * アイデアに関するクラス
 */
public class Idea {
    private User mUser;
    private String mText;
    private int mLikeNum;
    private boolean mIsClosed;

    /**
     * コンストラクタ
     * @param user
     * @param text
     * @param likeNum
     * @param isClosed
     */
    public Idea(User user, String text, int likeNum, boolean isClosed) {
        mUser = user;
        mText = text;
        mLikeNum = likeNum;
        mIsClosed = isClosed;
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
}
