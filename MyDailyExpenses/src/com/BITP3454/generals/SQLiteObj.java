package com.BITP3454.generals;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteObj extends SQLiteOpenHelper {
	
	public static final String dbName = "dbMyExpense";
	public static final String tblName = "expenses";
	public static final String colExpName = "exp_name";
	public static final String colExpPrice = "exp_price";
	public static final String colExpDate = "exp_date";
	

	public SQLiteObj(Context context) {
		// TODO Auto-generated constructor stub
		super(context,dbName,null, 1);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS expenses(exp_name VARCHAR,exp_price VARCHAR, exp_date DATE );");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS expenses");
        onCreate(db);
	}
	
	public Cursor getDataById(int id )
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cur = db.rawQuery("Select * from "+tblName+" where "+colExpName +"= "+id, null);
		
		return cur;
	}

}
