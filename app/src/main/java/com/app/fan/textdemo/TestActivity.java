package com.app.fan.textdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private CommentText tv_my;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv_my = (CommentText) findViewById(R.id.tv_my);
        CommentBean comment = new CommentBean("张三", "123", "李四", "456", "今天天气真好我们求是大厦大大大是倒萨大师的", "66");
        tv_my.setContent(comment, new CommentText.OnTextClickListener() {
            @Override
            public void onNameAClick(String id) {
                Toast.makeText(TestActivity.this, "onNameAClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNameBClick(String id) {
                Toast.makeText(TestActivity.this, "onNameBClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCommentTextClick(String idA, String commentId) {
                Toast.makeText(TestActivity.this, "onCommentTextClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOtherPlaceClick() {
                Toast.makeText(TestActivity.this, "onOtherPlaceClick", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
