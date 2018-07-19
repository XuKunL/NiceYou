package n.x.com.niceyou;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FindFragment findFragment;
    //private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            findFragment  = (FindFragment) getSupportFragmentManager().getFragment(savedInstanceState, "find");
        }
        else{
            findFragment=FindFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, findFragment).commit();

    }

    /**
     * 当活动被回收时，存储当前的状态。
     *
     * @param outState 状态数据。
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // 存储 Fragment 的状态。
        getSupportFragmentManager().putFragment(outState, "findFragment", findFragment);
    }

}
