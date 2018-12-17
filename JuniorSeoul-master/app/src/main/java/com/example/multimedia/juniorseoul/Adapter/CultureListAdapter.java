package com.example.multimedia.juniorseoul.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.multimedia.juniorseoul.Classess.CultureModel;
import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class CultureListAdapter extends BaseAdapter {
    private ArrayList<CultureModel> listViewItemList = new ArrayList<>();
    private Typeface jua;
    public CultureListAdapter(){

    }

    @Override
    public int getCount(){
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.culture_listview_item, parent, false);
        }

        jua = Typeface.createFromAsset(context.getAssets(), "jua_ttf.ttf");

        TextView titleTextView = (TextView) convertView.findViewById(R.id.culture_title);
        titleTextView.setTypeface(jua);
        TextView placeTextView = (TextView) convertView.findViewById(R.id.culture_place);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.culture_time);


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        CultureModel listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewItem.getTitle());
        placeTextView.setText(listViewItem.getPlace());
        timeTextView.setText(listViewItem.getTime());

        return convertView;
    }
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(String title, String place, String time) {
        CultureModel item = new CultureModel(title, place, time);

        listViewItemList.add(item);
    }
}
