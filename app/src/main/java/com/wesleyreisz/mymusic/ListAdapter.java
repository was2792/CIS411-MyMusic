package com.wesleyreisz.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Song>{

    private Context aCon;
    private List<Song> asongList;
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyy");

    public ListAdapter(Context context, int textViewResourceId, List<Song> songs) {
        super(context, R.layout.my_fragment_layout, songs);

        aCon = context;
        asongList = songs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //got this if statement from Mike not sure what it does tbh

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)aCon.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_song,parent,false);
        }


        final Song song = asongList.get(position);

        TextView textViewtitle = (TextView) convertView.findViewById(R.id.textViewSongTitle);
        textViewtitle.setText(song.getSongTitle() + " by " + song.getArtistName() );

        TextView textViewAlbum = (TextView) convertView.findViewById(R.id.textViewSongArtist);
        textViewAlbum.setText(song.getAlbumTitle());


        TextView textViewPublishedDate = (TextView)convertView.findViewById(R.id.textViewSongDate);
        textViewPublishedDate.setText(df.format(song.getSongPublishedDate()));

        return convertView;


    }
}
