package com.example.simpleton.wechat;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MsgFragment extends Fragment {

    private SimpleAdapter simAdapt;
    private ListView listView;
    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    public MsgFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance(String param1, String param2) {
        MsgFragment fragment = new MsgFragment();

        return fragment;
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_msg, container, false);
        for (int i = 0; i < 20; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("touxiang", R.drawable.msg_state_fail_resend);
            item.put("name", "猪猪" + i);
            item.put("message", "今晚请我吃饭");
            data.add(item);
        }

        listView = v.findViewById(R.id.list);

        simAdapt = new SimpleAdapter(this.getActivity(), data, R.layout.item_conversation_group1,
                new String[] { "touxiang", "name", "message" },// 与下面数组元素要一一对应
                new int[] { R.id.msg_state, R.id.tv_name, R.id.tv_content });
        listView.setAdapter(simAdapt);
        return v;
    }

}
