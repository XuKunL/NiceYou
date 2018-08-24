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
    private static List<String> mDatas= new ArrayList<String>();
    private RecyclerView recyclerView;
    private HotCollAdaper adapter;

    public void initdata() {
        JdbcReader jb = new JdbcReader(mDatas);
        jb.dw();
    }

    public void initdata1() {
        for (int i = 0; i < Images.imageThumbUrls.length; i++) {
            mDatas.add(Images.imageThumbUrls[i]);
        }
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

        System.out.println("----------------1--------------:"+mDatas.size());
        initdata();
        System.out.println("----------------2--------------:"+mDatas.size());

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

        return view;
    }

}
