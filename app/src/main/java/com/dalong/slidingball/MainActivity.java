package com.dalong.slidingball;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.dalong.francyconverflow.FlowGallery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private String TAG = "FlowGallery";

    private FlowGallery flowGallery;
    private MyFlowAdapter flowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<FlowItem> flowItems = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            FlowItem flowItem = new FlowItem();
            flowItem.setName("第" + (i + 1) + "天");
            flowItem.setSelected(false);
            flowItems.add(flowItem);
        }
        flowGallery = (FlowGallery) findViewById(R.id.fancy_cover_flow);
        flowAdapter = new MyFlowAdapter(this, flowItems);
        flowGallery.setAdapter(flowAdapter);
        flowAdapter.notifyDataSetChanged();

        flowGallery.setUnselectedAlpha(0.9f);
        flowGallery.setUnselectedSaturation(0.9f);
        flowGallery.setUnselectedScale(0.6f);
        flowGallery.setSpacing(0);
        flowGallery.setMaxRotation(0);
        flowGallery.setScaleDownGravity(0.5f);
        flowGallery.setActionDistance(FlowGallery.ACTION_DISTANCE_AUTO);

        int num = Integer.MAX_VALUE / 2 % flowItems.size();
        int selectPosition = Integer.MAX_VALUE / 2 - num;

        Log.d(TAG, "onCreate num:" + num + ", selectPosition:" + selectPosition);

        flowGallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FlowItem flowItem = (FlowItem) flowGallery.getSelectedItem();
                if (flowItem != null) {
                    Log.d(TAG, "flowGallery.onItemSelected "+position+":"+ flowItem.getName());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        flowGallery.setSelection(selectPosition);
    }


}
