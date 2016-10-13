package com.funny.simple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends BaseAdapter {
	
	private Context ctx;
	private List<String> list;
	private LayoutInflater mInflater;

	public ItemsAdapter(Context ctx, List<String> list){
		this.ctx = ctx;
		this.list = list;
		mInflater = LayoutInflater.from(ctx);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public String getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("deprecation")
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
        	convertView = mInflater.inflate(R.layout.list_item_view, null);
        	holder.txt_name = (TextView) convertView.findViewById(R.id.txt_name);
        	convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txt_name.setText(getItem(arg0));
		return convertView;
	}
	
	static class ViewHolder{
		TextView txt_name;
	}

}
