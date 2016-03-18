package com.BITP3454.mydailyexpenses;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExpensesMainActivity extends ActionBarActivity {

	EditText tvExpname, tvPrice,edtDate;
	Button btnSave;
	SQLiteDatabase dbMyExpenses;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expenses_main);
		
		dbMyExpenses = openOrCreateDatabase("dbMyExpense", MODE_PRIVATE, null);
		tvExpname = (EditText) findViewById(R.id.edtExpName);
		tvPrice = (EditText) findViewById(R.id.edtPrice);
		edtDate = (EditText)findViewById(R.id.edtDate);
		edtDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expenses_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_listExpense) {
			fnTry(this.getCurrentFocus());
			return true;
		}
		else if (id == R.id.action_try_list)
		{
			fnTryList(this.getCurrentFocus());
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void fnSave(View vw)
	{
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				String strExpname = tvExpname.getText().toString();
				String strPrice = tvPrice.getText().toString();
				String strDate = edtDate.getText().toString();
				dbMyExpenses.execSQL("CREATE TABLE IF NOT EXISTS expenses(exp_name VARCHAR,exp_price VARCHAR, exp_date DATE );");
				dbMyExpenses.execSQL("Insert into expenses values('"+strExpname+"','"+ strPrice +"','"+ strDate  +"');");
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast showSuccess = Toast.makeText(getApplicationContext(), "Information Successfully Saved! ", Toast.LENGTH_SHORT);
						showSuccess.show();
					}
				});
				
			}
		};
		
		Thread thrSave = new Thread(run);
		thrSave.start();
		
	}
	public void fnTry(View vw)
	{
		 Intent intent = new Intent(this, ListExpenseActivity.class);
		 startActivityForResult(intent, 0);
		
	}
	
	public void fnTryList(View vw)
	{
		 Intent intent = new Intent(this, ListOutActivity.class);
		 startActivityForResult(intent, 0);
		
	}
}
