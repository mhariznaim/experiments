package com.BITP3454.mydailyexpenses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListOutActivity extends ListActivity {

	static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
		"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
		"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_out);
		 
		ArrayList<HashMap<String, String>> fruitList = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Buah", "Apple");
		fruitList.add(map);
		map = new HashMap<String, String>();
		map.put("Buah", "Avocakado");
		fruitList.add(map);
		map = new HashMap<String, String>();
		map.put("Buah", "Banana");
		fruitList.add(map);
		map = new HashMap<String, String>();
		map.put("Buah", "Blueberry");
		fruitList.add(map);
		map = new HashMap<String, String>();
		map.put("Buah", "Coconut");
		fruitList.add(map);
		
		
		List listFruit = new ArrayList();
		listFruit.add("Mangge");
		listFruit.add("Betik");
		listFruit.add("Mulberi");
		listFruit.add("Pishang");
		
		ListView lv = getListView();
		//ListAdapter lstAdapter = new SimpleAdapter(this, fruitList, R.layout.list_fruit,  new String [] {"Buah"}, new int [] {R.id.textViewTest} ) 
		//lv.setAdapter(lstAdapter);
		lv.setTextFilterEnabled(true);
		setListAdapter(new ArrayAdapter<String>(this,R.layout.list_fruit,R.id.textViewTest,listFruit));
		 
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_out, menu);
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
