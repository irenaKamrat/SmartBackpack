package com.irenakamrat.smartbackpack;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ikamrat on 07/03/2016.
 */
public class ItemsListAdapter extends Activity {

    private Map<String, Model[]> itemsPerSubjectMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_items);

        TextView currentDay = (TextView) findViewById(R.id.current_day);
        currentDay.setText("Sunday 06/03/2016");

        itemsPerSubjectMap = new HashMap<>();
        Model[] mathItemsList = new Model[3];
        mathItemsList[0] = new Model("Book1", 0);
        mathItemsList[1] = new Model("Calculator", 1);
        mathItemsList[2] = new Model("Notebook", 0);
        itemsPerSubjectMap.put("Math", mathItemsList);

        itemsPerSubjectMap = new HashMap<>();
        Model[] englishItemsList = new Model[3];
        englishItemsList[0] = new Model("Book1", 0);
        englishItemsList[1] = new Model("Book2", 1);
        englishItemsList[2] = new Model("Notebook", 0);
        itemsPerSubjectMap.put("English", englishItemsList);

        String subject = getIntent().getStringExtra("subject");
        CustomItemsAdapter adapter = new CustomItemsAdapter(
                this, itemsPerSubjectMap.get(subject));

        ListView lv = (ListView) findViewById(R.id.itemsListView);
        lv.setAdapter(adapter);
    }
}
