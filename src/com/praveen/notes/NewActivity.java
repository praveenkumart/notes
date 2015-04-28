package com.praveen.notes;

import java.util.StringTokenizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class NewActivity extends ActionBarActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listmain);

		ListView myListView = (ListView) findViewById(R.id.listView1);


		UserAdapter myUserAdapter=new UserAdapter(getApplicationContext(), createDummyUserModels());
		//UserAdapter myUserAdapter=new UserAdapter(getApplicationContext(), userlist);

		myListView.setAdapter(myUserAdapter);

	}

	public UserModel[] createDummyUserModels(){

		SharedPreferences sp = getSharedPreferences("mysp", Context.MODE_PRIVATE);	

		String spval=sp.getString("prevval", "");
		if(spval.length()<1){
			return null;
		}
		StringTokenizer stk=new StringTokenizer(spval, "|");
		int noOfRecords= stk.countTokens();
		UserModel[] userlist=new UserModel[noOfRecords];
		for (int i = 0; i < noOfRecords ; i++) {

			String secondval=stk.nextToken();
			StringTokenizer stk2=new StringTokenizer(secondval, ",");
			for (int j = 0; j < stk2.countTokens(); j++) {
				userlist[i]=new UserModel(stk2.nextToken(),stk2.nextToken(),stk2.nextToken());

			}
		}
		


//		UserModel[] userlist=new UserModel[name.length];
//		for (int i = 0; i < name.length; i++) {
//			userlist[i]=new UserModel(name[i], date[i], subject[i]);
//		}
		return userlist;

	}

}
