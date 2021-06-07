package com.example.parsing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends BaseAdapter {

    List<Model> list;
    Context context;
    Activity activity;

    public Adapter(List<Model> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView text, h3, ol, h4,cite,kaynak,h2;
        text = convertView.findViewById(R.id.text123);
        h3 = convertView.findViewById(R.id.h3);
        ol = convertView.findViewById(R.id.ol);
        h4= convertView.findViewById(R.id.h4);
        cite = convertView.findViewById(R.id.cite);
        kaynak = convertView.findViewById(R.id.kaynak);
        h2 = convertView.findViewById(R.id.h2);

        if(list.get(position).getH2().equals("")){
            h2.setVisibility(View.GONE);
            h2.setHeight(0);
            h2.setTextSize(0,0);
            h2.setWidth(0);
        }else
            h2.setText(list.get(position).getH2());

        if(list.get(position).getTxt().equals("")){
            text.setVisibility(View.GONE);
            text.setHeight(0);
            text.setWidth(0);
            text.setTextSize(0,0);
        }else text.setText(list.get(position).getTxt());

        if(list.get(position).getH3().equals("")){
            h3.setHeight(0);
            h3.setWidth(0);
            h3.setVisibility(View.GONE);
            h3.setTextSize(0,0);
        }else
            h3.setText(list.get(position).getH3());

        if(list.get(position).getH4().equals("")){
            h4.setHeight(0);
            h4.setWidth(0);
            h4.setTextSize(0,0);
            h4.setVisibility(View.GONE);

        }else
            h4.setText(list.get(position).getH4());

        if(list.get(position).getCite().equals("")){
            cite.setHeight(0);
            cite.setWidth(0);
            cite.setTextSize(0,0);
            cite.setVisibility(View.GONE);

        }else cite.setText(list.get(position).getCite());

        if(list.get(position).getOl().equals("")){
            ol.setHeight(0);
            ol.setWidth(0);
            ol.setVisibility(View.GONE);
            ol.setTextSize(0,0);

        }else ol.setText(list.get(position).getOl());

        if(list.get(position).getKaynak().equals("")){
            kaynak.setHeight(0);
            kaynak.setWidth(0);
            kaynak.setTextSize(0,0);
            kaynak.setVisibility(View.GONE);

        }else kaynak.setText(list.get(position).getKaynak());

        /*if(list.get(position).getImageUrl().equals("")){
            textImage.setVisibility(View.GONE);

        }else Picasso.get().load(list.get(position).getImageUrl()).into(textImage);

        if(list.get(position).getImageTxt().equals("")){
            imageText.setVisibility(View.GONE);

        }else imageText.setText(list.get(position).getImageTxt());
         */
        return convertView;
    }
}
