package com.example.my_music;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtFilter;
    GridView gridView;
    ListView listView;
    ArrayList<Title> list_Title;
    Adapter adapter;
    String[] titles = {"1","2","3","4"};
    Integer[] images = {R.drawable.nhacaumy,R.drawable.nhacaumy,R.drawable.nhacaumy,R.drawable.nhacaumy};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_title);
        adapter = new Adapter(MainActivity.this,add());
        listView.setAdapter(adapter);

        txtFilter = (EditText)findViewById(R.id.fifter);
        txtFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private ArrayList<Title> add()
    {
        ArrayList<Title> ts = new ArrayList<>();
        Title t;
        for (int i = 0; i< titles.length; i++)
        {
            t = new Title(titles[i], images[i]);
            ts.add(t);
        }
        return ts;
    }
}
