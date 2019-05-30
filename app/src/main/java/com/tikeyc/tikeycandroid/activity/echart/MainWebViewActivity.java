package com.tikeyc.tikeycandroid.activity.echart;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tikeyc.tikeycandroid.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MainWebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_view);

        webView = (WebView)findViewById(R.id.mainWebView);
        initWebViewClient();
        initWebView();

    }

    /**
     * @param decript 要加密的字符串
     * @return 加密的字符串
     * SHA1加密
     */
    public final static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static final String Permission_callSystem = "smisAPP";
    private static final String Permission_userType = "GTMC";
    private static final String Permission_Key = "35JQcdEDXXXc9sMAAOkGPGdQZkERjIuL";

    private void initWebView() {
        //
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(false);
        webSettings.setDisplayZoomControls(false);
        String url = "http://yonyou8800.tpddns.cn:8095/frontEnd/guideway.html#/login?";
        // http://yonyou8800.tpddns.cn:8095/frontEnd/guideway.html#/login?
        // nonceStr=cacsf112fwfw&callSystem=smisAPP&timestamp=1000000000&uestType=111
        // &dlrCode=222
        // &cryptograph=cf62e898ed66d7b8980161ce4ca179afacc08cf2&userAcnt=ceshi5
        String nonceStr = String.valueOf(new Random().nextInt(1000000));
        String timestamp = String.valueOf(System.currentTimeMillis());
        String admin = "admin";
        if (admin.equals("admin")) admin = "3001212";
        String shaString1 = "callSystem=" + Permission_callSystem + "&nonceStr=" + nonceStr
                + "&timestamp=" + timestamp + "&userAcnt=" + admin + "&userType=" + Permission_userType;
        String shaString = shaString1 + "&key=" + Permission_Key;
        Log.d("shaString", shaString);
        String cryptograph = SHA1(shaString);
        Log.d("cryptograph", cryptograph);
        String loadUrl = url + shaString1 + "&cryptograph=" + cryptograph;
        webView.loadUrl(loadUrl);
    }

    private void initWebViewClient () {
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
    }
}
