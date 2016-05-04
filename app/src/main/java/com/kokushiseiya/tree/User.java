package com.kokushiseiya.tree;

/**
 * ユーザーに関するクラス
 */
public class User {
    private String mUserName;

    /**
     * コンストラクタ
     * @param userName
     */
    public User(String userName) {
        mUserName = userName;
    }

    /**
     * userNameのgetter
     * @return
     */
    public String getmUserName() {
        return mUserName;
    }
}
