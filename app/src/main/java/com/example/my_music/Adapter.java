package com.example.my_music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class Adapter extends BaseAdapter implements Filterable {
    private Context context;
    private ArrayList<Title> titleList;
    private TitleFilter filter;
    private ArrayList<Title> filterList;

    public Adapter(Context context, ArrayList<Title> titleList) {
        this.context = context;
        this.titleList = titleList;
        this.filterList = titleList;
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public Object getItem(int position) {
        return titleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view = convertView;
       if (view == null)
       {
           LayoutInflater inflater = LayoutInflater.from(context);
           view = inflater.inflate(R.layout.row_list_title, null);
       }
       Title t = (Title) getItem(position);
       if ((t != null))
       {
           TextView txtTitle = (TextView)view.findViewById(R.id.textView);
           ImageView img = (ImageView)view.findViewById(R.id.imageView);
           txtTitle.setText(t.getTitle());
           img.setImageResource(t.getImg());
       }
       return view;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
        {
            filter = new TitleFilter();
        }
        return filter;
    }

    private class TitleFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<Title> filters = new ArrayList<Title>();
                for (int i =0; i< filterList.size(); i++)
                {
                    if (filterList.get(i).getTitle().toUpperCase().contains(constraint))
                    {
                        Title t = new Title(titleList.get(i).getTitle(), filterList.get(i).getImg());
                        filters.add(t);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            titleList = (ArrayList<Title>)results.values;
            notifyDataSetChanged();

        }
    }

}
