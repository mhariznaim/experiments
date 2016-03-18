package com.BITP3454.mydailyexpenses;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListExpenseActivity extends ListActivity {

	SQLiteDatabase dbMyExpenses;
	ArrayList<HashMap<String, String>> expList;
	ListView listExp;
	String strExpName,strPrice,strDate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_expense);
		
		/*expList = new ArrayList<HashMap<String,String>>();
		
		listExp = getListView();//(ListView) findViewById(R.id.list);
		
		String[] values = new String[] { "Android List View", 
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android", 
                "Android Example", 
                "List View Source Code", 
                "List View Array Adapter", 
                "Android Example List View" 
               };
		
		final ArrayList<String> list = new ArrayList<String>();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_list_expense,android.R.id.text1,values);
		
		listExp.setAdapter(adapter);
		HashMap<String , String> map = new HashMap<String, String>();
		map.put("Expense Name",strExpName);
		map.put("Price(RM)", strPrice);
					
					expList.add(map);
		*/
		
		 Runnable run = new Runnable() {
			
			@Override
			public void run() {
				
				dbMyExpenses = openOrCreateDatabase("dbMyExpense", MODE_PRIVATE, null);
				Cursor resultSet = dbMyExpenses.rawQuery("Select * from expenses", null);
				
				
				while(resultSet.moveToNext())
				{
					 strExpName = resultSet.getString(resultSet.getColumnIndex("exp_name"));
					 strPrice = resultSet.getString(resultSet.getColumnIndex("exp_price"));
					 strDate = resultSet.getString(resultSet.getColumnIndex("exp_date"));
					//list.add(strExpName+":RM"+strPrice);
				    
					
					
				}
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						// ListAdapter adapter = new SimpleAdapter(this, expList, R.layout.activity_list_expense, new String [] {"Expense Name",  "Price(RM)"}, )
						//listExp.setAdapter(adapter);
						Toast showToast = Toast.makeText(getApplicationContext(), strExpName+":"+strPrice+":"+strDate, Toast.LENGTH_LONG );
						showToast.show();
					}
				});
			}
		};
		Thread thr = new Thread(run);
		thr.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_expense, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
