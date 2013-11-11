package com.remifayolle.horizontallistviewsample;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

/**
 * Sample activity for HorizontalListView.
 *
 * Sources :
 * - http://developer.android.com/training/custom-views/create-view.html
 * - http://www.androiddevelopersolution.com/2012/11/horizontal-listview-in-android-example.html
 * - https://github.com/lucasr/twoway-view/blob/master/library/src/org/lucasr/twowayview/TwoWayView.java
 * - http://developer.android.com/reference/android/widget/AdapterView.html
 * - http://developer.android.com/reference/android/widget/LinearLayout.LayoutParams.html#gravity
 * - http://beingshivdatta.blogspot.fr/2013/02/android-automatic-horizontal-scroll-view.html
 * - https://github.com/dinocore1/DevsmartLib-Android/blob/master/devsmartlib/src/com/devsmart/android/ui/HorizontalListView.java
 * - http://stackoverflow.com/questions/14618632/how-to-add-dynamic-image-with-horizontal-scrollview-listview
 * - http://krishnalalstha.wordpress.com/2012/12/09/android-horizontalscrollview-with-center-lock/
 * - http://developer.android.com/guide/topics/ui/binding.html#FillingTheLayout
 * - http://developer.android.com/guide/topics/ui/custom-components.html
 * - http://developer.android.com/guide/topics/ui/declaring-layout.html#CommonLayouts
 * - http://developer.android.com/reference/android/widget/BaseAdapter.html
 */
public class MainActivity extends Activity implements HorizontalListView.OnListItemClickListener {

    private ColorListViewAdapter mAdapter = null;
    private HorizontalListView mListView = null;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get list view
        mListView = (HorizontalListView)findViewById(R.id.listview);

        // Create adapter
        mAdapter = new ColorListViewAdapter(this, 50);

        // Bind adapter to listview
        if (mListView != null) {
            mListView.setAdapter(mAdapter);
            mListView.registerListItemClickListener(this);
        }
        else {
            Log.e(TAG, "HorizontalListView not found");
        }

        /*Resources res = getResources();
        PieChart pie = (PieChart) this.findViewById(R.id.Pie);
        pie.addItem("Agamemnon", 2, res.getColor(R.color.seafoam));
        pie.addItem("Bocephus", 3.5f, res.getColor(R.color.chartreuse));
        pie.addItem("Calliope", 2.5f, res.getColor(R.color.emerald));
        pie.addItem("Daedalus", 3, res.getColor(R.color.bluegrass));
        pie.addItem("Euripides", 1, res.getColor(R.color.turquoise));
        pie.addItem("Ganymede", 3, res.getColor(R.color.slate));*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, "Click " + String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
