package com.example.multimedia.juniorseoul.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.multimedia.juniorseoul.Classess.ReplyModel;
import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class ReplyListAdapter extends BaseAdapter {

    private ArrayList<ReplyModel> listViewItemList = new ArrayList<ReplyModel>() ;

    // ListViewAdapter의 생성자
    public ReplyListAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.reply_listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView idTextView = (TextView) convertView.findViewById(R.id.reply_id);
        TextView contentTextView = (TextView) convertView.findViewById(R.id.reply_content);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.reply_date);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ReplyModel listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        idTextView.setText(listViewItem.getId());
        contentTextView.setText(listViewItem.getContent());
        dateTextView.setText(listViewItem.getDate());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String id, String content, String date) {
        ReplyModel item = new ReplyModel(id, content, date);

        listViewItemList.add(item);
    }
}