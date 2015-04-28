package com.praveen.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<UserModel>{

	UserModel[] usersList;
	Context myContext;
	
	public UserAdapter(Context context, UserModel[] usersList) {
		super(context, R.layout.list_item,usersList);
		// TODO Auto-generated constructor stub
		this.usersList=usersList;
		this.myContext=context;
	}
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return getCustomView(position, convertView, parent);	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return getCustomView(position, convertView, parent);	}
	
	public View getCustomView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater mLayoutInflater = LayoutInflater.from(myContext);
			convertView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
		}
		TextView title = (TextView) convertView.findViewById(R.id.textView1);
		TextView date = (TextView) convertView.findViewById(R.id.textView2);
		TextView subject = (TextView) convertView.findViewById(R.id.textView3);
		title.setText(usersList[position].getName());
		date.setText(usersList[position].getDate());
		subject.setText(usersList[position].getSubject());
		return convertView;
		// TODO Auto-generated method stub
		
	}

}
