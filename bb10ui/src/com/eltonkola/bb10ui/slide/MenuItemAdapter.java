package com.eltonkola.bb10ui.slide;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.eltonkola.bb10ui.R;

public class MenuItemAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private ArrayList<MenuItem> menuItems;
	
	private int selected=-1;
	
    public MenuItemAdapter(Context c, ArrayList<MenuItem> menuItems, int selected) {
        inflater = LayoutInflater.from(c);
        this.menuItems=menuItems;
        this.selected = selected;
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_sides, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.menu_name);
            holder.description = (TextView) convertView.findViewById(R.id.menu_description);
            holder.new_nr = (TextView) convertView.findViewById(R.id.new_nr);
            holder.icon = (ImageView) convertView.findViewById(R.id.menu_icon);
            holder.icon_new = (ImageView) convertView.findViewById(R.id.icon_new);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MenuItem item = menuItems.get(position);
        holder.name.setText(menuItems.get(position).getName());
        
        if(menuItems.get(position).getDescription()!=null && menuItems.get(position).getDescription().length()>0){
        	holder.description.setVisibility(View.VISIBLE);
        	holder.description.setText(menuItems.get(position).getDescription());
        }else{
        	holder.description.setVisibility(View.GONE);
        }
        
        
        if (item.getIcon() != MenuItem.NO_ICON) {
            holder.icon.setVisibility(View.VISIBLE);
            holder.icon.setImageResource(menuItems.get(position).getIcon());
        } else {
            holder.icon.setVisibility(View.INVISIBLE);
        }
        
        if(menuItems.get(position).getNew_nr()>0){
        	holder.new_nr.setVisibility(View.VISIBLE);
        	holder.new_nr.setText(menuItems.get(position).getNew_nr()+"");
        }else{
        	holder.new_nr.setVisibility(View.GONE);
        }
        
        if(menuItems.get(position).isNew_icon()){
        	holder.icon_new.setVisibility(View.VISIBLE);
        }else{
        	holder.icon_new.setVisibility(View.GONE);
        }
        
        if( position == selected){
        	convertView.setBackgroundColor(Color.parseColor("#15AFDE"));
        }else{
        	convertView.setBackgroundColor(Color.TRANSPARENT);
        }
        
        return convertView;
    }

    class ViewHolder {
        TextView name, description, new_nr;
        ImageView icon, icon_new;
    }

}
