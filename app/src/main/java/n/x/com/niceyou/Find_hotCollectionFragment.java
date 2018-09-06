package n.x.com.niceyou;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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
                //Toast.makeText(getContext(), "点击了第" + (position + 1) + "个", Toast.LENGTH_SHORT).show();
              //  recyclerView.removeView(view);
                LayoutInflater inflater_fd = LayoutInflater.from(getContext());
                View imgEntryView = inflater_fd.inflate(R.layout.layout_fd, null);
                final AlertDialog dialog = new AlertDialog.Builder(getContext()).create();
                ImageView img = (ImageView) imgEntryView.findViewById(R.id.imageView_fd);
                Glide.with(getContext()).load(mDatas.get(position)).apply(new RequestOptions().placeholder(R.drawable.a2335052).error(R.drawable.kong).centerCrop()).into(img);

                dialog.setView(imgEntryView);
                // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.show();
//                Window window = dialog.getWindow();
//                window.getDecorView().setPadding(0, 0, 0, 0);
//                window.setGravity(Gravity.CENTER);
//
//                window.setContentView(imgEntryView);
//                WindowManager.LayoutParams lp = window.getAttributes();
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
//                window.setAttributes(lp);

//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setTitle("请做出选择").setIcon(R.drawable.a2335052)
//                        .setMessage("我美不美")
//                        .setPositiveButton("美", new DialogInterface.OnClickListener() {// 积极
//
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which) {
//                                // TODO Auto-generated method stub
//                                Toast.makeText(getContext(), "恭喜你答对了", Toast.LENGTH_SHORT)
//                                        .show();
//                            }
//                        }).setNegativeButton("不美", new DialogInterface.OnClickListener() {// 消极
//
//                    @Override
//                    public void onClick(DialogInterface dialog,
//                                        int which) {
//                        // TODO Auto-generated method stub
//                        Toast.makeText(getContext(), "一点也不老实",  Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                }).setNeutralButton("不知道", new DialogInterface.OnClickListener() {// 中间级
//
//                    @Override
//                    public void onClick(DialogInterface dialog,
//                                        int which) {
//                        // TODO Auto-generated method stub
//                        Toast.makeText(getContext(), "快睁开眼瞅瞅",  Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                });
//                builder.create().show();

            }
        });

        return view;
    }

}
