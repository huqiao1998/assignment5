package com.example.a93584.exercise;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachList extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter myAdapter = new MyAdapter(this);
        mRecyclerView.setAdapter(myAdapter);
        ItemTouchHelper.Callback callback = new myItemTouchHelperCallBack(myAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements ItemTouchHelperAdapter{

        LayoutInflater mInflater;
        List<MData> mList = addData();

        public MyAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.cardview,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.mName.setText(mList.get(position).getUserName());
            holder.mDescribe.setText(mList.get(position).getDescription());
            holder.mPhoto.setImageResource(mList.get(position).getPhotoId());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
        @Override
        public void onItemMove(int fromPosition, int toPosition) {
            Collections.swap(mList,fromPosition,toPosition);
            notifyItemMoved(fromPosition,toPosition);
        }

        @Override
        public void onItemDelete(int position) {
            mList.remove(position);
            notifyItemRemoved(position);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView mName;
            private TextView mDescribe;
            private ImageView mPhoto;
            public ViewHolder(View itemView) {
                super(itemView);
                mName = itemView.findViewById(R.id.txt_name);
                mDescribe = itemView.findViewById(R.id.txt_describe);
                mPhoto= itemView.findViewById(R.id.txt_image);
            }
        }
    }

    public interface ItemTouchHelperAdapter {

        public void onItemMove(int fromPosition,int toPosition);

        public void onItemDelete(int position);
    }

    public class myItemTouchHelperCallBack extends ItemTouchHelper.Callback{
        private ItemTouchHelperAdapter itemTouchHelperAdapter;

        public myItemTouchHelperCallBack(ItemTouchHelperAdapter itemTouchHelperAdapter) {
            this.itemTouchHelperAdapter = itemTouchHelperAdapter;
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

            int swipeFlags = ItemTouchHelper.LEFT;
            return makeMovementFlags(dragFlags,swipeFlags);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

            itemTouchHelperAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            itemTouchHelperAdapter.onItemDelete(viewHolder.getAdapterPosition());
        }

        @Override
        public boolean isLongPressDragEnabled() {

            return true;
        }

        @Override
        public boolean isItemViewSwipeEnabled() {

            return true;
        }
    }

    private class MData{
        String userName;
        String description;
        int photoId;


        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPhotoId() {
            return photoId;
        }

        public void setPhotoId(int photoId) {
            this.photoId = photoId;
        }
    }
    private List<MData> addData(){
        List<MData> list = new ArrayList();

        MData mData = new MData();
        mData.setUserName("王叠");
        mData.setDescription("Tel：18801269565");
        mData.setPhotoId(R.drawable.asdf);
        list.add(mData);

        mData = new MData();
        mData.setUserName("罗素");
        mData.setDescription("Tel：18801269566");
        mData.setPhotoId(R.drawable.ath);
        list.add(mData);

        mData = new MData();
        mData.setUserName("John");
        mData.setDescription("Tel：18801269568");
        mData.setPhotoId(R.drawable.ath2);
        list.add(mData);

        mData = new MData();
        mData.setUserName("Smith");
        mData.setDescription("Tel：18801269523");
        mData.setPhotoId(R.drawable.ath3);
        list.add(mData);

        mData = new MData();
        mData.setUserName("Mr qian");
        mData.setDescription("Tel：18801269232");
        mData.setPhotoId(R.drawable.ath6);
        list.add(mData);

        mData = new MData();
        mData.setUserName("Mr hu");
        mData.setDescription("Tel：18801269998");
        mData.setPhotoId(R.drawable.ath7);
        list.add(mData);

        mData = new MData();
        mData.setUserName("Mr chu");
        mData.setDescription("Tel：18801269132");
        mData.setPhotoId(R.drawable.ath10);
        list.add(mData);

        mData = new MData();
        mData.setUserName("Mr zhang");
        mData.setDescription("Tel：18801260000");
        mData.setPhotoId(R.drawable.ath11);
        list.add(mData);

        mData = new MData();
        mData.setUserName("Mr huang");
        mData.setDescription("Tel：18801269578");
        mData.setPhotoId(R.drawable.ath12);
        list.add(mData);

        mData = new MData();
        mData.setUserName("Mr duan");
        mData.setDescription("Tel：18801269534");
        mData.setPhotoId(R.drawable.ath13);
        list.add(mData);

        return list;
    }
}
