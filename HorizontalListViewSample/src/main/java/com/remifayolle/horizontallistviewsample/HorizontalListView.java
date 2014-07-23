/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Rémi Fayolle
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/*
 * <fayoller@gmail.com> wrote this file. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return. -Rémi Fayolle
 */

package com.remifayolle.horizontallistviewsample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

/**
 * A view that shows items in a horizontal scrolling list. The items
 * come from the {@link ListAdapter} associated with this view.
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/layout/listview.html">List View</a>
 * guide.</p>
 *
 * @attr ref android.R.styleable#ListView_entries
 * @attr ref android.R.styleable#ListView_divider
 * @attr ref android.R.styleable#ListView_dividerHeight
 * @attr ref android.R.styleable#ListView_headerDividersEnabled
 * @attr ref android.R.styleable#ListView_footerDividersEnabled
 */
public class HorizontalListView extends HorizontalScrollView {

    private String TAG = "HorizontalListView";
    private ViewGroup mContainer = null;
    private Context mContext = null;
    private ListAdapter mAdapter = null;
    private OnListItemClickListener mListItemClickListener = null;

    /**
     * OnListItemClickListener interface
     * Interface definition for a callback to be invoked when a list item is clicked.
     */
    public interface OnListItemClickListener {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         * @param position The position if the item that was clicked
         */
        void onClick(View v, int position);
    }

    /**
     * Register a listener for list item click.
     * @param listItemClickListener
     */
    public void registerListItemClickListener(OnListItemClickListener listItemClickListener) {
        mListItemClickListener = listItemClickListener;
    }

    /**
     * Custom OnClickListener for list item
     */
    public class CustomOnClickListener implements OnClickListener {
        private int mPosition;
        public CustomOnClickListener(int position) {
            mPosition = position;
        }
        @Override
        public void onClick(View v) {
            if (mListItemClickListener != null) {
                mListItemClickListener.onClick(v, mPosition);
            }
        }
    }

    /**
     * HorizontalListView constructor.
     * @param context
     * @param attributeSet
     */
    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;

        // Init child view
        LinearLayout container = new LinearLayout(context);
        container.setOrientation(LinearLayout.HORIZONTAL);
        container.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mContainer = container;
        addView(mContainer);

        // Remove horizontal scrollbar
        setHorizontalScrollBarEnabled(false);
    }

    /**
     * Set the adapter which will be used to build the list item views.
     * @param adapter
     */
    public void setAdapter(ListAdapter adapter) {
        mAdapter = adapter;

        if (getChildCount() == 0 || adapter == null)
            return;

        mContainer.removeAllViews();

        for (int i = 0; i < adapter.getCount(); i++) {
            View v = adapter.getView(i, null, mContainer);
            if (v != null) {
                v.setOnClickListener(new CustomOnClickListener(i));
                mContainer.addView(v);
            }
        }
    }
}
