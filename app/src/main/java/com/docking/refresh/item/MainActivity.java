package com.docking.refresh.item;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<TestEntity> mList = new ArrayList<>();

    private ListView mListView = null;
    private TestAdapter mTestAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        initData();
    }

    private void init() {
        mListView = (ListView) this.findViewById(R.id.listview);
        mTestAdapter = new TestAdapter(this, mList);
        mListView.setAdapter(mTestAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mTestAdapter.setSelectPostion(i);
                mTestAdapter.refreshView(view);
            }
        });

        mTestAdapter.notifyDataSetChanged();
    }

    /**
     * 添加测试数据
     */
    private void initData() {
        for (int i = 0; i < 10; i ++) {
            TestEntity entity = new TestEntity();
            entity.setTitle("title " + i);
            entity.setDesc("desc: " + i);
            mList.add(entity);
        }
    }
}
