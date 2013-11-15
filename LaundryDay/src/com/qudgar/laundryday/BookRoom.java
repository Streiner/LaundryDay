package com.qudgar.laundryday;


import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;



public class BookRoom extends Activity implements OnClickListener
{
	GridView grid;
	DateList dateList;
	private ViewGrid viewTimes;


	public BookRoom()
	{
		//InitializeComponents();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		InitializeComponents();
	}
	public void InitializeComponents()
	{

		dateList = new DateList();
		dateList.CreateEmptyList();
		
		viewTimes = new ViewGrid(this);
		setContentView(viewTimes);
		viewTimes.AddList(dateList);
		viewTimes.requestFocus();
		
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		
	}
}
