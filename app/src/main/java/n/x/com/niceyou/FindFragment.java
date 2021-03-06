package n.x.com.niceyou;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


/**
 * 发现页面
 */
public class FindFragment extends Fragment {

    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private Find_hotRecommendFragment hotRecommendFragment;              //热门推荐fragment
    private Find_hotCollectionFragment hotCollectionFragment;            //热门收藏fragment
    private Find_hotMonthFragment hotMonthFragment;                      //本月热榜fragment
    private Find_hotToday hotToday;                                      //今日热榜fragment

    public FindFragment() {
    }

    public static FindFragment newInstance() {
        return new FindFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);

        initControls(view);

        return view;
    }

    /**
     * 初始化各控件
     * @param view
     */
    private void initControls(View view) {

        tab_FindFragment_title = (TabLayout)view.findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager)view.findViewById(R.id.vp_FindFragment_pager);

        //初始化各fragment
        hotRecommendFragment = new Find_hotRecommendFragment();
        hotCollectionFragment = new Find_hotCollectionFragment();
        hotMonthFragment = new Find_hotMonthFragment();
        hotToday = new Find_hotToday();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        list_fragment.add(hotMonthFragment);
        list_fragment.add(hotToday);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("微信");
        list_title.add("通讯录");
        list_title.add("发现");
        list_title.add("我");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)).setIcon(R.mipmap.chats));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)).setIcon(R.mipmap.contacts));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)).setIcon(R.mipmap.discover));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)).setIcon(R.mipmap.about_me));

        fAdapter = new MyAdapter(getActivity().getSupportFragmentManager(),list_fragment,list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
       // tab_FindFragment_title.setSelectedTabIndicatorHeight(0);
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        List<Fragment> fragments = getChildFragmentManager().getFragments();
//        if (fragments != null) {
//            for (Fragment fragment : fragments) {
//                if (fragment != null) {
//                    fragment.onRequestPermissionsResult(requestCode,permissions,grantResults);
//                }
//            }
//        }
//    }
}
