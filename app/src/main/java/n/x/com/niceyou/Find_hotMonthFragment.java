package n.x.com.niceyou;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Find_hotMonthFragment  extends Fragment {
    public Find_hotMonthFragment() {
        super();
    }
    public static Find_hotMonthFragment newInstance(String text){
        Bundle bundle = new Bundle();
        bundle.putString("发现图片",text);
        Find_hotMonthFragment hotRecommendFragment = new Find_hotMonthFragment();
        hotRecommendFragment.setArguments(bundle);
        return  hotRecommendFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.month, container, false);
    }
}
