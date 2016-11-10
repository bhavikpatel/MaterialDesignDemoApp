package wikileaf.app.com.wikileaf.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import wikileaf.app.com.wikileaf.R;

/**
 * Created by student on 5/21/2016.
 */
public class SeattleListAdapter extends RecyclerView.Adapter<SeattleListAdapter.MyViewHolder> {
    ArrayList<HashMap<String,String>> dataList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            /*title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);*/
        }
    }

    public SeattleListAdapter(Activity activity, ArrayList<HashMap<String, String>> dataList){
        this.dataList=dataList;
    }

    @Override
    public SeattleListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seattle_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("data==>",position+"");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
