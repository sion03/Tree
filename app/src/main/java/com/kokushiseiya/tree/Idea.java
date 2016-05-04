package com.kokushiseiya.tree;

/**
 * アイデアに関するクラス
 */
public class Idea {
    private User mUser;
    private String mText;
    private int mLikeNum;
    private boolean mIsClosed;
    private Idea mParentIdea;

    /**
     * コンストラクタ
     * @param user
     * @param text
     * @param likeNum
     * @param isClosed
     * @param parentIdea
     */
    public Idea(User user, String text, int likeNum, boolean isClosed, Idea parentIdea) {
        mUser = user;
        mText = text;
        mLikeNum = likeNum;
        mIsClosed = isClosed;
        mParentIdea = parentIdea;
    }
}
