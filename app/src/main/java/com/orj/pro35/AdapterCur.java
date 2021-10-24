package com.orj.pro35;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.actionmode.R;
import com.orj.pro35.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdapterCur extends BaseAdapter {

    List<Item> list;
    Context context;

    public AdapterCur(List<Item> list, Context context) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return list.size();
    }

    public Item getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.simple_item, null);
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView) convertView.findViewById(R.id.text_view);

            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }


        int green = Color.parseColor("#0000FF");
        int white = Color.parseColor("#FFFFFF");
        viewHolder.textView.setText(list.get(position).getName());
        if(list.get(position).isBo() == true){
            viewHolder.textView.setBackgroundColor(green);

        }
        else {
            viewHolder.textView.setBackgroundColor(white);
        }
        return convertView;

    }

    class ViewHolder{
        TextView textView;
    }


}