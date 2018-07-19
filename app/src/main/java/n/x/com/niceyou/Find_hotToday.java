package n.x.com.niceyou;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Find_hotToday extends Fragment {
    public Find_hotToday() {
        super();
    }
    private WebView webView;
    public static Find_hotToday newInstance(String text){
        Bundle bundle = new Bundle();
        bundle.putString("视频",text);
        Find_hotToday hotToday = new Find_hotToday();
        hotToday.setArguments(bundle);
        return  hotToday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.today, container,false);
        webView = view.findViewById(R.id.web1);
        webView.loadUrl("http://www.isfoot.cc");
        //支持App内部JavaScript交互
        webView.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        //设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //设置是否出现缩放工具
        webView.getSettings().setBuiltInZoomControls(true);

        //设置编码
        webView.getSettings().setDefaultTextEncodingName("utf-8");


        return view;
    }
}
