package com.example.ankur.contactapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ankur on 10/2/17.
 */

public class SmsListFragment extends Fragment {
    ArrayList<Sms> arrayList = new ArrayList<Sms>();
    public static final String ARG_PAGE = "ARG_PAGE";

    public SmsListFragment() {
        // Required empty public constructor
    }

    public static SmsListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        SmsListFragment fragment = new SmsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(getActivity());
        arrayList = dbHelper.getSms();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.sms_list_fragment, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        MySmsAdapter adapter = new MySmsAdapter(getActivity(), arrayList);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }

}
