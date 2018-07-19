package n.x.com.niceyou;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Find_hotRecommendFragment extends Fragment {
    public Find_hotRecommendFragment() {
        super();
    }
    public static Find_hotRecommendFragment newInstance(String text){
        Bundle bundle = new Bundle();
        bundle.putString("我的微信",text);
        Find_hotRecommendFragment hotCollectionFragment = new Find_hotRecommendFragment();
        hotCollectionFragment.setArguments(bundle);
        return  hotCollectionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recomment, container, false);
    }
}
