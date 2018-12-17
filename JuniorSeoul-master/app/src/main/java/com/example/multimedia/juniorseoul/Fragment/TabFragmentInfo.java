package com.example.multimedia.juniorseoul.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class TabFragmentInfo extends Fragment {
    TextView name_tv, address_tv, phonenum_tv, tel_indicator;
    Typeface jua;
    ArrayList<String> info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_info, container, false);

        info = getArguments().getStringArrayList("info");

        for(int i=0; i<info.size(); i++){
            Log.d("data_test", info.get(i));
        }
        jua = Typeface.createFromAsset(getActivity().getAssets(), "jua_ttf.ttf");
        name_tv = (TextView) view.findViewById(R.id.name_tv);
        name_tv.setTypeface(jua);

        address_tv = (TextView) view.findViewById(R.id.address_tv);
        address_tv.setTypeface(jua);

        phonenum_tv = (TextView) view.findViewById(R.id.phone_tv);

        name_tv.setText(info.get(0));
        address_tv.setText(info.get(1));

        tel_indicator = (TextView)view.findViewById(R.id.tel_indicator);

        if(info.get(2).equals("null")){
            phonenum_tv.setText("");
            tel_indicator.setText("");
        }else{
            phonenum_tv.setText(info.get(2));
            tel_indicator.setText("TEL");
            phonenum_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:"+info.get(2))));
                }
            });


        }

        return view;
    }
}
