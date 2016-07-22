package com.app.fan.textdemo;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * TextDemo
 * com.app.fan.textdemo
 *
 * @Author: fan
 * @Time: 2016/7/16 11:51
 * @Description:
 */
public class CommentText extends TextView {

    private OnTextClickListener mListener;
    private CommentBean comment;

    public CommentText(Context context) {
        super(context);
    }

    public CommentText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setContent(CommentBean comment, OnTextClickListener mListener) {
        setTextColor(comment.getDefaultColor());
        setHighlightColor(Color.TRANSPARENT);
        setMovementMethod(LinkMovementMethod.getInstance());
        this.mListener = mListener;
        this.comment = comment;
        if (!TextUtils.isEmpty(comment.getNameA()) && !TextUtils.isEmpty(comment.getNameB())) {
            SpannableString spanText = new SpannableString(comment.getNameA() + "回复" + comment.getNameB() + "：" + comment.getCommentText());
            spanText.setSpan(new ForegroundColorSpan(comment.getNameColor()), 0, comment.getNameA().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText.setSpan(new MyTextClickSpan(1), 0, comment.getNameA().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText.setSpan(new ForegroundColorSpan(comment.getNameColor()), 0, comment.getNameA().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText.setSpan(new MyTextClickSpan(2), (comment.getNameA() + "回复").length(), (comment.getNameA() + "回复" + comment.getNameB()).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText.setSpan(new MyTextClickSpan(3), (comment.getNameA() + "回复" + comment.getNameB() + "：").length(), spanText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            setText(spanText);
        } else if (!TextUtils.isEmpty(comment.getNameA()) && TextUtils.isEmpty(comment.getNameB())) {
            SpannableString spanText = new SpannableString(comment.getNameA() + "：" + comment.getCommentText());
            spanText.setSpan(new ForegroundColorSpan(comment.getNameColor()), 0, comment.getNameA().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText.setSpan(new MyTextClickSpan(1), 0, comment.getNameA().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText.setSpan(new MyTextClickSpan(3), (comment.getNameA() + "：").length(), spanText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            setText(spanText);
        }

    }


    public interface OnTextClickListener {

        void onNameAClick(String id);

        void onNameBClick(String id);

        void onCommentTextClick(String idA, String commentId);

        void onOtherPlaceClick();
    }

    public class MyTextClickSpan extends ClickableSpan {

        private int position;


        public MyTextClickSpan(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View widget) {

            if (position == 1) {
                mListener.onNameAClick(comment.getIdA());
            } else if (position == 2) {
                mListener.onNameBClick(comment.getIdB());
            } else if (position == 3) {
                mListener.onCommentTextClick(comment.getIdA(), comment.getCommentId());
            }

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            if (position == 1 || position == 2) {
                ds.setColor(comment.getNameColor());
            } else {
                ds.setColor(comment.getDefaultColor());
            }
        }
    }
}
