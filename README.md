HorizontalListView
==================

My simple HorizontalListView implementation for my Android applications. Warning : it is really simple but not optimized. But it still can be really useful, depending on your needs.

Import sample project in Android Studio
---------------------------------------
1. Import project
2. Select repository folder
3. Use auto import + use default gradle wrapper

How to use the simple horizontal listview
-----------------------------------------
1. Add the file [HorizontalListView.java](https://github.com/buzeeg/horizontallistview/blob/master/HorizontalListViewSample/src/main/java/com/remifayolle/horizontallistviewsample/HorizontalListView.java) file in your project.
2. Include the `HorizontalListView` in your layout file :
```xml
    <com.remifayolle.horizontallistviewsample.HorizontalListView
        android:id="@+id/listview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

3. In your activity or fragment, implement the `HorizontalListView.OnClickListener` and initialize the listView with an adapter and the `OnClickListener` :
```java
public class MainActivity extends Activity implements HorizontalListView.OnListItemClickListener {

    private BaseAdapter mAdapter = null;
    private HorizontalListView mListView = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get list view
        mListView = (HorizontalListView)findViewById(R.id.listview);

        // Create adapter
        mAdapter = new BaseAdapter();

        // Bind adapter to listview
        if (mListView != null) {
            mListView.setAdapter(mAdapter);
            mListView.registerListItemClickListener(this);
        }
        else {
            Log.e(TAG, "HorizontalListView not found");
        }
    }

    /* ... */

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, "Click " + String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
```

License
-------
See [LICENSE](http://github.com/buzeeg/horizontallistview/blob/master/LICENSE)
