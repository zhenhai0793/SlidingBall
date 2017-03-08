package com.dalong.slidingball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.dalong.francyconverflow.FancyCoverFlow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "FancyCoverFlow";

    private FancyCoverFlow mfancyCoverFlow;
    private MyFancyCoverFlowAdapter mMyFancyCoverFlowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        List<Item> items=new ArrayList<>();
        for(int i=0;i<365;i++){
            Item item=new Item();
            item.setName((i+1)+"天");
            item.setSelected(false);
            items.add(item);
        }
        mfancyCoverFlow = (FancyCoverFlow) findViewById(R.id.fancyCoverFlow);
        mMyFancyCoverFlowAdapter = new MyFancyCoverFlowAdapter(this, items);
        mfancyCoverFlow.setAdapter(mMyFancyCoverFlowAdapter);
        mMyFancyCoverFlowAdapter.notifyDataSetChanged();

        mfancyCoverFlow.setUnselectedAlpha(0.9f);
        mfancyCoverFlow.setUnselectedSaturation(0.9f);
        mfancyCoverFlow.setUnselectedScale(0.6f);
        mfancyCoverFlow.setSpacing(0);
        mfancyCoverFlow.setMaxRotation(0);
        mfancyCoverFlow.setScaleDownGravity(0.5f);
        mfancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);

        int num = Integer.MAX_VALUE / 2 % items.size();
        int selectPosition = Integer.MAX_VALUE / 2 - num;

        mfancyCoverFlow.setSelection(selectPosition);

        Log.d(TAG, "onCreate num:"+num+", selectPosition:"+selectPosition);

        mfancyCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) mfancyCoverFlow.getSelectedItem();
                if (item != null) {
                    Toast.makeText(MainActivity.this,item.getName(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
