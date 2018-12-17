package com.example.multimedia.juniorseoul.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.multimedia.juniorseoul.Adapter.ReplyListAdapter;
import com.example.multimedia.juniorseoul.Classess.ReplyResultModel;
import com.example.multimedia.juniorseoul.Interface.ReplyPoint;
import com.example.multimedia.juniorseoul.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TabFragmentReply  extends Fragment {
    private ListView listView;
    private ReplyListAdapter adapter;
    private int kids_id;
    private String user_id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_reply, container, false);

        ArrayList<String> replyIdList = getArguments().getStringArrayList("replyIdList");
        ArrayList<String> replyContentList = getArguments().getStringArrayList("replyContentList");
        ArrayList<String> replyDateList = getArguments().getStringArrayList("replyDateList");
        kids_id = getArguments().getInt("kids_id");
        user_id = getArguments().getString("user_id");

        listView = (ListView)view.findViewById(R.id.reply_listview);
        adapter = new ReplyListAdapter();

        listView.setAdapter(adapter);

        for(int i=0; i<replyIdList.size(); i++){
            adapter.addItem(replyIdList.get(i), replyContentList.get(i), replyDateList.get(i));
            Log.d("datedata", replyDateList.get(i));
            Log.d("user_id", String.valueOf(replyIdList.get(i)));
        }

        final EditText edit = (EditText) view.findViewById(R.id.reply_edittext);
        Button btn = (Button) view.findViewById(R.id.reply_registbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ReplyPoint.BASE_URL)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ReplyPoint replyPoint = retrofit.create(ReplyPoint.class);
                try {
                    JSONObject paramObject = new JSONObject();
                    paramObject.put("kid_id", kids_id);
                    paramObject.put("user_id", user_id);
                    paramObject.put("comments", edit.getText().toString());

                    Call<ReplyResultModel> userCall = replyPoint.do_send_reply(paramObject.toString());
                    userCall.enqueue(new Callback<ReplyResultModel>() {
                        @Override
                        public void onResponse(Call<ReplyResultModel> call, Response<ReplyResultModel> response) {
                            Log.d("responsebody", response.body().getMessage());
                        }

                        @Override
                        public void onFailure(Call<ReplyResultModel> call, Throwable t) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
                edit.setText("");
                edit.clearFocus();

            }
        });



        return view;
    }
}
