package com.app.fan.textdemo;

/**
 * TextDemo
 * com.app.fan.textdemo
 *
 * @Author: fan
 * @Time: 2016/7/21 16:11
 * @Description:
 */
public class CommentBean {
    private int nameColor = 0xff576b95;
    private int defaultColor = 0xff000333;
    private String nameA;
    private String idA;
    private String nameB;
    private String idB;
    private String commentText;
    private String commentId;

    public CommentBean(String nameA, String idA, String nameB, String idB, String commentText, String commentId) {
        this.nameA = nameA;
        this.idA = idA;
        this.nameB = nameB;
        this.idB = idB;
        this.commentText = commentText;
        this.commentId = commentId;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getIdA() {
        return idA;
    }

    public void setIdA(String idA) {
        this.idA = idA;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getIdB() {
        return idB;
    }

    public void setIdB(String idB) {
        this.idB = idB;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public int getNameColor() {
        return nameColor;
    }

    public int getDefaultColor() {
        return defaultColor;
    }
}
