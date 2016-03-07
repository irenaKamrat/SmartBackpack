package com.irenakamrat.smartbackpack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ikamrat on 07/03/2016.
 */
public class MainListAdapter extends Activity {

    private Model[] modelItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        TextView currentDay = (TextView) findViewById(R.id.current_day);
        currentDay.setText("Sunday 06/03/2016");

        ListView lv = (ListView) findViewById(R.id.listView);
        modelItems = new Model[4];
        modelItems[0] = new Model("Math", 0);
        modelItems[1] = new Model("English", 1);
        modelItems[2] = new Model("Bible", 1);
        modelItems[3] = new Model("Science", 0);
        CustomAdapter adapter = new CustomAdapter(this, modelItems);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainListAdapter.this, ItemsActivity.class);
                intent.putExtra("subject", modelItems[position].getName());
                startActivity(intent);
            }
        });
        lv.setAdapter(adapter);
    }

    //@Override
    //public void onListItemClick(ListView listView, View view, int position, long id) {
    //    Intent intent = new Intent(MainListAdapter.this, ItemsActivity.class);
    //    intent.putExtra("subject", modelItems[position].getName());
    //    startActivity(intent);
    //}
}
