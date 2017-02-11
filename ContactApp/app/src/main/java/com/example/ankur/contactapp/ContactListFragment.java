package com.example.ankur.contactapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ankur on 9/2/17.
 */

public class ContactListFragment extends Fragment {

    ArrayList<Contact> arrayList = new ArrayList<Contact>();
    public static final String ARG_PAGE = "ARG_PAGE";

   public ContactListFragment() {
        // Required empty public constructor
    }

    public static ContactListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ContactListFragment fragment = new ContactListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String strJson = "{\"Contacts\":[{\"first_name\":\"Aman \"," +
                "\"last_name\":\"Srivastav\",\"phone_no\":\"+917053742698\"}, " +
                "{\"first_name\":\"Ankur \",\"last_name\":\"pandey\",\"phone_no\":\"+917417789967\"} ]}";

        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonRootObject.optJSONArray("Contacts");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String firstName = jsonObject.optString("first_name");
                String lastName = jsonObject.optString("last_name");
                String phoneNo = jsonObject.optString("phone_no");
                String combineData = firstName + lastName;
                arrayList.add(new Contact(firstName, lastName, combineData, phoneNo));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.contact_list_fragment, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(getActivity(), arrayList);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }
}
