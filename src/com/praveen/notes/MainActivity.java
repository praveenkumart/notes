package com.praveen.notes;

import java.util.StringTokenizer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	public void save(View v) {

		
		EditText ed=(EditText) findViewById(R.id.title);
		EditText ed1=(EditText) findViewById(R.id.date);
		EditText ed2=(EditText) findViewById(R.id.subject);
		
		String title,date,subject,finalval,newval;
		title=ed.getText().toString();
		date=ed1.getText().toString();
		subject=ed2.getText().toString();
		SharedPreferences sp = getSharedPreferences("mysp", Context.MODE_PRIVATE);	
		Editor editor = sp.edit();
	    editor.putString("name", title);
	    editor.putString("date", date);
	    editor.putString("subject", subject);
	    finalval=title+","+date+","+subject;
	    
	    if(!sp.getString("prevval", "").equals(""))
	    
	    {
	    	finalval=sp.getString("prevval", "")+"|"+finalval;
	    	
	    }
	    editor.putString("prevval", finalval);
	    editor.commit();
	    newval=sp.getString("prevval", "");
	    
	//    Toast.makeText(getApplicationContext(), newval, Toast.LENGTH_SHORT).show();
		StringTokenizer stk=new StringTokenizer(finalval, ",");
		

	}
	public void views(View v) {
		
		startActivity(new Intent(this,NewActivity.class));
		
	}
}
