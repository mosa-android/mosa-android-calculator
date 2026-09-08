package org.mosa.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<ListItem> itemsList;

    public CustomAdapter(Context context, ArrayList<ListItem> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.history_list_view, parent, false);
        }

        ListItem currentItem = itemsList.get(position);

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView subtitleTextView = convertView.findViewById(R.id.subtitleTextView);

        titleTextView.setText(currentItem.getTitle());
        subtitleTextView.setText(currentItem.getSubtitle());

        return convertView;
    }
}

