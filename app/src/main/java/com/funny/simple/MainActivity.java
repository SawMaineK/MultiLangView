package com.funny.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lst_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst_item = (ListView) findViewById(R.id.lst_item);

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("How are you?");
        list.add("I am fine");
        list.add("What are you doing?");
        list.add("I am coding");
        list.add("Where you go?");
        list.add("I go to Pagoda.");
        list.add("How is weather?");
        list.add("I think, it is fine");

        lst_item.setAdapter(new ItemsAdapter(this, list));

    }
}
