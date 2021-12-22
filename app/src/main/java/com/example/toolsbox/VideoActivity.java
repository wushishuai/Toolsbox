package com.example.toolsbox;

import androidx.appcompat.app.AppCompatActivity;

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
    private JzvdStd jzvdStd;
    private EditText vip_url;
    private Button vip_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vip_url = (EditText) findViewById(R.id.vip_text);
        vip_button = (Button) findViewById(R.id.video_button);
        vip_button.setOnClickListener(this);

        jzvdStd = (JzvdStd) findViewById(R.id.jz_video);
//        jzvdStd.setUp("https://qq-qy-yk-mg-bl-1905.jjyl12349.com/20210814/SnVWl0JC/index.m3u8"
//                , "饺子闭眼睛");
//        jzvdStd.posterImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
//        jzvdStd.posterImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"));
    }
    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.video_button:
                String url = vip_url.getText().toString();
                String parse_url = "https://660e.com/?url=https://v.qq.com/x/cover/mzc0020020cyvqh/x0041wg8yjd.html" ;
//                try {
//                    Document doc = Jsoup.connect(parse_url).get();
//                    String txt = doc.text();
//                    Log.e("-----------",txt);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Thread parse = new ParseHtml(parse_url);
//                ParseHtml pase = new ParseHtml(parse_url);
//                new Thread(pase).start();
//                String back_txt = pase.getUrl();
//                Log.e("------",back_txt);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            Document document = Jsoup.connect(parse_url).get();
//                            Document document = Jsoup.parse(new URL(parse_url), 100000);
//
//                            String txt = document.text();
                            OkHttpClient client = new OkHttpClient();
                            Request request = new Request.Builder()
                                    .url(parse_url)
                                    .build();
                            Response response = client.newCall(request).execute();
                            String txt = response.body().string();
                            Log.e("----------",txt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            default:
                break;

//                Log.i("-----------",parse_url);
//                try {
//                    ParseHtml.parse();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                jzvdStd.setUp("https://660e.com/?url=https://v.qq.com/x/cover/mzc00200lxzhhqz/d0040q5zhb7.html"
//                        , "饺子闭眼睛");

        }

    }
}
//class ParseHtml implements Runnable{
//    private String url;
//    private String txt;
//    public ParseHtml(String url){
//        this.url =url;
//    }
//    @Override
//    public void run() {
//        try {
//            Log.e("-----------------","11111111111");
//            Document doc = Jsoup.connect(url).get();
//            txt = doc.text();
//            Log.e("---------------","2222222222222222");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //                try {
////                    Document doc = Jsoup.connect(parse_url).get();
////                    String txt = doc.text();
////                    Log.e("-----------",txt);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//
//
//
//    }
//    public String getUrl(){
//        return txt;
//    }
////    public static void parse() throws IOException {
////        int id = 0;
////        String u = "https://www.htu.edu.cn/";
////        String url = "https://www.htu.edu.cn/9547/list.htm";
////        Document document = Jsoup.parse(new URL(url), 10000);
////        Elements content = document.getElementsByClass("news_box");
//////        System.out.println(content);
////
////
////        for (Element href : content) {
////            String hrefs =  u + href.attr("href");
//////            System.out.println(hrefs);
////            Document document1 = Jsoup.parse(new URL(hrefs), 10000);
////            Elements info_img = document1.getElementsByClass("info_img");
//////            System.out.println(info_img);
////            String src = info_img.select("img[src]").attr("src");
//////            System.out.println(links);
//////            System.out.println(u + src);
////            Log.e("---------",src);
//
//
////            URL target = new URL(u + src);
////            URLConnection urlConnection = target.openConnection();
////            InputStream inputStream = urlConnection.getInputStream();
////            id++;
////            OutputStream outputStream = new FileOutputStream("./Download/" + id + ".jpg");
////            int temp = 0;
////            while((temp = inputStream.read()) != -1) {
////                outputStream.write(temp);
////            }
////            System.out.println(id + ".jpg 下载完毕");
////            outputStream.close();
////            inputStream.close();
////        }
////
////
////
////    }
//
////    @Override
////    public void run() {
////
////    }
//}
//
