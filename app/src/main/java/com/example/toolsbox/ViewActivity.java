package com.example.toolsbox;

import static android.view.KeyEvent.KEYCODE_BACK;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.toolsbox.function.GoodsCategoryBean;
import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelview.annotation.CurtainCorner;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener, OnOptionPickedListener {
    private String url;
    private WebView webView;
    private Intent intent;
    private String baseurl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        intent = getIntent();
        url = intent.getStringExtra("url");
        webView = findViewById(R.id.webView);
        initWebView();
        webView.loadUrl(url);

        ImageView imageView_play = (ImageView) findViewById(R.id.imageview_play);
        imageView_play.setOnClickListener(this);

    }
    public void onOptionBean(View view) {
        List<GoodsCategoryBean> data = new ArrayList<>();
        data.add(new GoodsCategoryBean(1, "线路一"));
        data.add(new GoodsCategoryBean(2, "线路二"));
        data.add(new GoodsCategoryBean(3, "线路三"));
        data.add(new GoodsCategoryBean(4, "线路四"));
        data.add(new GoodsCategoryBean(5, "线路五"));
        data.add(new GoodsCategoryBean(6, "线路六"));
        OptionPicker picker = new OptionPicker(this);
        picker.setTitle("解析线路");
        picker.setBodyWidth(140);
        picker.setData(data);
        picker.setDefaultPosition(2);
        picker.setOnOptionPickedListener(this);
        OptionWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setIndicatorEnabled(false);
        wheelLayout.setTextColor(0xFFFF00FF);
        wheelLayout.setSelectedTextColor(0xFFFF0000);
        wheelLayout.setTextSize(15 * view.getResources().getDisplayMetrics().scaledDensity);
        //注：建议通过`setStyle`定制样式设置文字加大，若通过`setSelectedTextSize`设置，该解决方案会导致选择器展示时跳动一下
        //wheelLayout.setStyle(R.style.WheelStyleDemo);
        wheelLayout.setSelectedTextSize(17 * view.getResources().getDisplayMetrics().scaledDensity);
        wheelLayout.setSelectedTextBold(true);
        wheelLayout.setCurtainEnabled(true);
        wheelLayout.setCurtainColor(0xEEFF0000);
        wheelLayout.setCurtainCorner(CurtainCorner.ALL);
        wheelLayout.setCurtainRadius(5 * view.getResources().getDisplayMetrics().density);
        wheelLayout.setOnOptionSelectedListener(new OnOptionSelectedListener() {
            @Override
            public void onOptionSelected(int position, Object item) {
                picker.getTitleView().setText(picker.getWheelView().formatItem(position));
                Log.e("------------",picker.getWheelView().formatItem(position));
            }
        });
        picker.show();
    }
    private void initWebView(){


        //获取webview的配置
        WebSettings settings = webView.getSettings();
        //配置支持domstorage
        settings.setDomStorageEnabled(true);//启用或禁用DOM缓存
        settings.setAppCacheEnabled(false);//关闭/启用应用缓存
        settings.setSupportZoom(true);//是否可以缩放，默认true
        //settings.setBuiltInZoomControls(false);//是否显示缩放按钮，默认false
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        settings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.canGoBack();
        //同时加载Https和Http混合模式
        if (Build.VERSION.SDK_INT >= 21) { settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW ); }


        webView.setWebViewClient(new WebViewClient(){
            //@Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if( url.startsWith("http:") || url.startsWith("https:") ) {
                    view.loadUrl(url);
                    return true;

                }else {
                    return true;
                }
            }
        });

        //webView.setWebChromeClient(new WebChromeClient());

        //webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageview_play:
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                intent.putExtra("url", baseurl + webView.getUrl());
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    @Override
    public void onOptionPicked(int position, Object item) {
//        Toast.makeText(this, position + "-" + item, Toast.LENGTH_SHORT).show();
//        Log.e("----------",item.toString());
//        Log.e("-----------------",String.valueOf(position));
        switch (position){
            case 0:
                baseurl = "https://660e.com/?url=";
                break;
            case 1:
                baseurl = "https://jx.parwix.com:4433/player/?url=";
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }

    }
    //按返回键回退网页
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {
//            webView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

}