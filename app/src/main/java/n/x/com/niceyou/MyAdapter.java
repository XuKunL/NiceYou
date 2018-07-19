package n.x.com.niceyou;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {

   // private List<String> list;
    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    public MyAdapter(FragmentManager fm,List<Fragment> list_fragment, List<String> list_title) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list_title = list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return  list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position % list_title.size());
    }
}
