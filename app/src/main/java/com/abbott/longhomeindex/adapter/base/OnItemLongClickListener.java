package com.abbott.longhomeindex.adapter.base;

import android.view.View;
import android.view.ViewGroup;

public interface OnItemLongClickListener<T>
{
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);

}
