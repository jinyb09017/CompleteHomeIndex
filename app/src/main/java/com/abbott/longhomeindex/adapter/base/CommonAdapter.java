package com.abbott.longhomeindex.adapter.base;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas = new ArrayList<>();
    protected LayoutInflater mInflater;

    private OnItemClickListener<T> mOnItemClickListener;
    private OnItemLongClickListener<T> mOnItemLongClickListener;

    public CommonAdapter(Context context, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;

    }

    public CommonAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }


    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }


    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public List<T> getList() {
        return mDatas;
    }

    public void appendToList(List<T> list) {
        if (list == null) {
            return;
        }
        mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void clearTo(List<T> list) {
        if (list == null) {
            return;
        }
        mDatas.clear();
        notifyDataSetChanged();
        mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void appendToTopList(List<T> list) {
        if (list == null) {
            return;
        }
        mDatas.addAll(0, list);
        notifyDataSetChanged();
    }

    public void appendToTop(T item) {
        if (item == null) {
            return;
        }
        mDatas.add(0, item);
        notifyDataSetChanged();
    }

    public void delete(T item){
        if (item == null) {
            return;
        }
        mDatas.remove(item);
        notifyDataSetChanged();
    }
    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId, -1);
        setListener(parent, viewHolder, viewType);
        return viewHolder;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getLayoutPosition();
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }


    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position =  viewHolder.getmItemPosition();
                    mOnItemClickListener.onItemClick(parent, v, mDatas.get(position), position);
                }
            }
        });


        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.v("yhl", "onLongClick");
                if (mOnItemLongClickListener != null) {
                    int position = viewHolder.getmItemPosition();
                    return mOnItemLongClickListener.onItemLongClick(parent, v, mDatas.get(position), position);
                }
                return false;
            }
        });

        viewHolder.getConvertView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);
                switch(action) {
                    case MotionEvent.ACTION_DOWN:
                        v.setTag(event.getRawX());
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


}
