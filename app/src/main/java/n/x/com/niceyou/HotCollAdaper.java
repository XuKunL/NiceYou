package n.x.com.niceyou;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

public class HotCollAdaper extends RecyclerView.Adapter<HotCollAdaper.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<String> mDatas;
    private static int SCREE_WIDTH = 0;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public HotCollAdaper(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        SCREE_WIDTH = mContext.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //当点击事件发生时,对应着去执行,我们自己写的cycleview的方法
            mOnItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    //定义一个recycleview的监听器
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item, viewGroup, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_num);
        //给imageview的高度设置动态高度,实现瀑布流,也可以用其它方法去动态的设置它的高度
       // imageView.getLayoutParams().height = (int) (1200 + Math.random() * 900) ;
        imageView.getLayoutParams().width = SCREE_WIDTH/2;




        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams lp = viewHolder.image.getLayoutParams();
        lp.height=(int) (1000 + Math.random() * 900);
        viewHolder.itemView.setLayoutParams(lp);
        //用Glide去加载图片
        Glide.with(mContext).load(mDatas.get(i)).apply(new RequestOptions().placeholder(R.drawable.a2335052).error(R.drawable.kong).centerCrop()).into(viewHolder.image);
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.id_num);
        }
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        super.onViewRecycled(holder);
    }
//给recyclerview 动态添加一个itemView

    protected void addItemView(int position) {
        mDatas.add(position, Images.imageThumbUrls[position]);
        //和notifyDatasetChange进行区别
        notifyItemInserted(position);

    }

    //给recyclerview 动态删除一个itemView
    protected void removeItemView(int position) {
        mDatas.remove(Images.imageThumbUrls[position]);
        notifyItemRemoved(position);

    }
}