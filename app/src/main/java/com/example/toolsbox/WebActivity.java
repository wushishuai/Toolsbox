package com.example.toolsbox;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.toolsbox.function.HttpClientUtil;

public class WebActivity extends AppCompatActivity {
    private Button parseurl_button;
    private EditText url_text;
    private TextView web_text;
    
    private final String TAG = "Webactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        parseurl_button = (Button) findViewById(R.id.parseurl_button);
        url_text = (EditText) findViewById(R.id.url_text);
        web_text = (TextView) findViewById(R.id.web_text);
        parseurl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_text.getText().toString();
                new Thread() {
                    @Override
                    public void run() {
                        String html = HttpClientUtil.doGet(url);
                        Log.e(TAG, "run: " + html);
                        showResponse(html);

//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                web_text.setMovementMethod(ScrollingMovementMethod.getInstance());
//                                web_text.setText(html);
////                                textView.setText(html);
////                                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
//                            }
//                        });
                    }
                }.start();
            }
        });
//另一种解析方式

//        parseurl_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread() {
//                    @Override
//                    public void run() {
//                        try {
//                            final String html = HtmlService.getHtml(url);
////                            handler.post(new Runnable() {
////                                @Override
////                                public void run() {
////                                    textView.setText(html);
////                                    textView.setTextColor(getResources().getColor(R.color.colorBrown));
////                                }
////                            });
//                              showResponse(html);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }.start();
//            }
//        });

    }
    private void showResponse(final String html){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                web_text.setMovementMethod(ScrollingMovementMethod.getInstance());
                web_text.setText(html);
            }
        });

    }

}