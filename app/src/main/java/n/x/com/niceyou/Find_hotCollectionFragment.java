package n.x.com.niceyou;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Find_hotCollectionFragment extends Fragment {
    public Find_hotCollectionFragment() {
        super();
    }
    public List<String> mDatas= new ArrayList<String>();
    private RecyclerView recyclerView;
    private HotCollAdaper adapter;
    private void initDatas() {
        JdbcReader jb = new JdbcReader();
        jb.init();
        jb.select(mDatas);
    }

    public static Find_hotCollectionFragment newInstance(String text){
        Bundle bundle = new Bundle();
        bundle.putString("通讯录",text);
        Find_hotCollectionFragment hotCollectionFragment = new Find_hotCollectionFragment();
        hotCollectionFragment.setArguments(bundle);
        return  hotCollectionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.hotcollection, container, false);
        View view = inflater.inflate(R.layout.hotcollection, container,false);

        initDatas();
        recyclerView = (RecyclerView) view.findViewById (R.id.recyclerview);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
               StaggeredGridLayoutManager.VERTICAL));
      //  recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new HotCollAdaper(getContext(), mDatas);
        recyclerView.setAdapter(adapter);
        //给Adapter设置监听
        adapter.setOnItemClickListener(new HotCollAdaper.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "点击了第" + (position + 1) + "个", Toast.LENGTH_SHORT).show();
            }
        });

      //  final ImageView image = new ImageView(getActivity());
        //image.setAdjustViewBounds(true);
        //image.setScaleType(ImageView.ScaleType.CENTER);
//        main.addView(image);
//        image.setImageResource(images[0]);
//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                image.setImageResource(images[++currentImg%images.length]);
//            }
//        });
        return view;
    }
}
