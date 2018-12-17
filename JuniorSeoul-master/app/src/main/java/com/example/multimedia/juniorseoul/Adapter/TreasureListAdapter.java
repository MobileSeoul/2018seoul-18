package com.example.multimedia.juniorseoul.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multimedia.juniorseoul.Classess.TreasureListItem;
import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class TreasureListAdapter extends BaseAdapter{
    private ArrayList<TreasureListItem> listViewItemList = new ArrayList<>();

    public TreasureListAdapter(){

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
            convertView = inflater.inflate(R.layout.tn_list_item, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.tn_name);
        TextView numTextView = (TextView) convertView.findViewById(R.id.tn_num);
        TextView ageTextView = (TextView) convertView.findViewById(R.id.tn_age);
        ImageView mainImg = (ImageView) convertView.findViewById(R.id.tn_mainImg);


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        TreasureListItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        nameTextView.setText(listViewItem.getKr_name()+"\n"+listViewItem.getCh_name());
        numTextView.setText(listViewItem.getNum());
        ageTextView.setText(listViewItem.getAge());
        mainImg.setImageResource(listViewItem.getImg());

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

    public void addItem(int img, String kr_name, String ch_name, String age, String num) {
        TreasureListItem item = new TreasureListItem(img, kr_name, ch_name, age, num);

        listViewItemList.add(item);
    }
}
