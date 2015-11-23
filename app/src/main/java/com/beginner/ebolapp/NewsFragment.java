package com.beginner.ebolapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private ListView mListView;
    private List<Concert> mConcertLists;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_news, container, false);
        mListView = (ListView) fragmentView.findViewById(R.id.MyListView);
        mConcertLists = new ArrayList<Concert>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Concerts");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> concertsParseList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + concertsParseList.size() + " scores");

                    for (ParseObject parseObject : concertsParseList) {
                        String title = (String) parseObject.get("title");
                        String link = (String) parseObject.get("link");
                        String imageLink = (String) parseObject.get("imageLink");
                        Concert concert = new Concert(title, link, imageLink);
                        mConcertLists.add(concert);
                    }
                    mListView.setAdapter(new myAdapter());

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }

            }

        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Concert concert = mConcertLists.get(position);
                String link= concert.getLink();
                openBrowser(link);

            }
        });

        return fragmentView;

    }

    public void openBrowser(String link){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }

    private class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mConcertLists.size();
        }

        @Override
        public Object getItem(int position) {
            return mConcertLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = getActivity().getLayoutInflater().inflate(R.layout.row, null);
            Concert rowConcert = mConcertLists.get(position);
            TextView textViewRow = (TextView) rowView.findViewById(R.id.textViewRow);
            textViewRow.setText(rowConcert.getTitle());
            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewPicasso);
            Picasso.with(getActivity()).load(rowConcert.getImageLink()).into(imageView);
            return rowView;
        }
    }


}
