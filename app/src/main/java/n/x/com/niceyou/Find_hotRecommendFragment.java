package n.x.com.niceyou;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Find_hotRecommendFragment extends Fragment {
    public Find_hotRecommendFragment() {
        super();
    }
    private ListView fileList = null ;//显示文件的列表
    private String strPath;
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
        View view= inflater.inflate(R.layout.book_list, container,false);
        fileList = view.findViewById(R.id.file_list);
        List<String> ndata = new ArrayList<String>();
        strPath = Environment.getExternalStorageDirectory().getPath()+"/xs/";
        File pathFile = new File(strPath);
        File[] files = pathFile.listFiles();
        for(File file : files) {//全部遍历
            ndata.add(file.getName());
        }
        System.out.println("ndata============"+ndata.toString());
        ArrayAdapter  adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, ndata);
        fileList.setAdapter(adapter);
        fileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String filename=strPath+parent.getAdapter().getItem(position).toString();
                LayoutInflater inflater_read = LayoutInflater.from(getContext());
                View readview= inflater_read.inflate(R.layout.readbook,null);
                TextView tv = (TextView) readview.findViewById(R.id.readbook);

                tv.setMovementMethod(ScrollingMovementMethod.getInstance());
                if ( ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                        ||
                        ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                        ){
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE },1234);
                };
                String str= TextRead.readTxtFile(filename);

                tv.setText(str);
                final AlertDialog dialog = new AlertDialog.Builder(getContext()).create();
              //  dialog.setView(readview);
             //   dialog.show();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.show();
                Window window = dialog.getWindow();
                window.setGravity(Gravity.CENTER);

                //沉浸式状态栏
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_FULLSCREEN| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);

                //设置window背景，默认的背景会有Padding值，不能全屏。当然不一定要是透明，你可以设置其他背景，替换默认的背景即可。
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                window.setContentView(readview);
                WindowManager.LayoutParams lp = window.getAttributes();

                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                window.getDecorView().setPadding(0, 0, 0, 0);
                window.setAttributes(lp);
               // Toast.makeText(getContext(), "点击了第" + (position + 1) + "个", Toast.LENGTH_LONG).show();
            }
        });

        return view;

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
