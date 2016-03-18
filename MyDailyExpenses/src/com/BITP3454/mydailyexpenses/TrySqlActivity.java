package com.BITP3454.mydailyexpenses;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TrySqlActivity extends AppCompatActivity {

	SQLiteDatabase dbMyExpenses;
	String strExpName = null ;
	String strPrice ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_try_sql);
		
			Runnable run = new Runnable() {
				
			@Override
			public void run() {
				
				dbMyExpenses = openOrCreateDatabase("dbMyExpense", MODE_PRIVATE, null);
				Cursor resultSet = dbMyExpenses.rawQuery("Select * from expenses", null);
				
				
				while(resultSet.moveToNext())
				{
					strExpName = resultSet.getString(1);
					strPrice = resultSet.getString(2);
					 
				}
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						// ListAdapter adapter = new SimpleAdapter(this, expList, R.layout.activity_list_expense, new String [] {"Expense Name",  "Price(RM)"}, )
						 TextView ggr = (TextView)findViewById(R.id.txtVwGrr);
						 ggr.setText(strExpName);
						
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
		getMenuInflater().inflate(R.menu.try_sql, menu);
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
