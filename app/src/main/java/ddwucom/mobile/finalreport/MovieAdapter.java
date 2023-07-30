package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MovieData> movieList;
    private LayoutInflater layoutInflater;

    public MovieAdapter(Context context, int layout, ArrayList<MovieData> movieList) {
        this.context = context;
        this.layout = layout;
        this.movieList = movieList;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movieList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder holder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            holder = new ViewHolder();
            holder.img = (ImageView)convertView.findViewById(R.id.img);
            holder.title = (TextView)convertView.findViewById(R.id.tvTitle);
            holder.actors = (TextView)convertView.findViewById(R.id.tvActors);
            holder.day = (TextView)convertView.findViewById(R.id.tvDay);
            holder.score = (TextView)convertView.findViewById(R.id.tvScore);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img.setImageResource(movieList.get(pos).getImg());
        holder.title.setText(movieList.get(pos).getTitle());
        holder.actors.setText(movieList.get(pos).getActor());
        holder.day.setText(movieList.get(pos).getDay());
        holder.score.setText(movieList.get(pos).getScore());

        return convertView;
    }

    static class ViewHolder {
        ImageView img;
        TextView title;
        TextView actors;
        TextView day;
        TextView score;
    }
}
