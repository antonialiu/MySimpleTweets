package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.codepath.apps.restclienttemplate.TimelineActivity.TWEET_TEXT;

public class ComposeActivity extends AppCompatActivity {

    EditText etTweet;
    TextView tvCharCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        etTweet = (EditText) findViewById(R.id.etTweet);
        tvCharCount = (TextView) findViewById(R.id.tvCharCount);
        etTweet.setText(getIntent().getStringExtra(TWEET_TEXT));
        getSupportActionBar().setTitle("Compose Tweet");

        etTweet.addTextChangedListener(mTextEditorWatcher);

    }

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //This sets a textview to the current length
            tvCharCount.setText(String.valueOf(s.length()) + "/280");
            if (s.length() > 280) {
                tvCharCount.setTextColor(Color.RED);
            }
        }

        public void afterTextChanged(Editable s) {
        }
    };

    public void onTweet(View v) {
        Intent data = new Intent();
        data.putExtra(TWEET_TEXT, etTweet.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
