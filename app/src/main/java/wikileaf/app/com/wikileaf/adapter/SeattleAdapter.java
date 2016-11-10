package wikileaf.app.com.wikileaf.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import wikileaf.app.com.wikileaf.R;

/**
 * Created by student on 5/21/2016.
 */
public class SeattleAdapter extends BaseAdapter {
    Activity activity;
    class ViewHolderItem {

        TextView textViewItem,txtMedicalDelivery;

    }
    public SeattleAdapter(Activity activity){
        this.activity=activity;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem;
        if(convertView==null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.seattle_list_row, parent, false);
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.txtMedicalDelivery=(TextView)convertView.findViewById(R.id.txtMedicalDelivery);
            convertView.setTag(viewHolderItem);
        }else{
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }
        if(position%2!=0){
            viewHolderItem.txtMedicalDelivery.setTextColor(activity.getResources().getColor(R.color.blue));
        }else{
            viewHolderItem.txtMedicalDelivery.setTextColor(activity.getResources().getColor(R.color.dark_green));
        }
        return convertView;
    }
}
