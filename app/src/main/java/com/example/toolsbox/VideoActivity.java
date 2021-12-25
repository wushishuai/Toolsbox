package com.example.toolsbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button vip_button;
    private Button vip_button2;
    private Button vip_button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vip_button = (Button) findViewById(R.id.video_button);
        vip_button2 = (Button) findViewById(R.id.video_button2);
        vip_button3 = (Button) findViewById(R.id.video_button3);
        vip_button.setOnClickListener(this);
        vip_button2.setOnClickListener(this);
        vip_button3.setOnClickListener(this);

    }
//    @Override
//    public void onBackPressed() {
//
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewActivity.class);

        switch (view.getId()){
            case R.id.video_button:
                Log.e("---------","hhhhhhhhhhhhh");
                intent.putExtra("url", "https://v.qq.com/");
                startActivity(intent);
                break;
            case R.id.video_button2:
                intent.putExtra("url", "https://vip.iqiyi.com/");
                startActivity(intent);
                break;
            case R.id.video_button3:
                intent.putExtra("url", "https://www.youku.com/");
                startActivity(intent);
                break;
            default:
                break;






        }

    }
}
