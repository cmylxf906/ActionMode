package com.orj.pro35;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.view.ActionMode;

import androidx.appcompat.app.AppCompatActivity;


import com.example.actionmode.R;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Item> list;

    private BaseAdapter adapter;
    private String [] name = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        list = new ArrayList<Item>();
        for(int i = 0; i < 9; i++){
            list.add(new Item(name[i], false));
        }

        adapter = new AdapterCur(list, MainActivity.this);
        listView.setAdapter(adapter);


        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
            int num = 0;


            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {


                if (checked == true) {
                    list.get(position).setBo(true);

                    adapter.notifyDataSetChanged();
                    num++;
                } else {
                    list.get(position).setBo(false);

                    adapter.notifyDataSetChanged();
                    num--;
                }
                mode.setTitle("  " + num + " Selected");
            }



            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.action_mode, menu);
                num = 0;
                adapter.notifyDataSetChanged();
                return true;

            }


            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                adapter.notifyDataSetChanged();
                return false;
            }

            public void refresh(){
                for(int i = 0; i < 6; i++){
                    list.get(i).setBo(false);
                }
            }


            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_delete:
                        adapter.notifyDataSetChanged();
                        num = 0;
                        refresh();
                        mode.finish();
                        return true;
                    default:
                        refresh();
                        adapter.notifyDataSetChanged();
                        num = 0;
                        return false;
                }

            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                refresh();
                adapter.notifyDataSetChanged();

            }

        });

    }
}
