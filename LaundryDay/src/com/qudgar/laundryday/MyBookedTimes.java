package com.qudgar.laundryday;


import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class MyBookedTimes extends Activity implements OnClickListener
{
	GridView grid;
	private bookedCard viewTimes;


	public MyBookedTimes()
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
		viewTimes = new bookedCard(this);
		
		setContentView(viewTimes);
		viewTimes.requestFocus();
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		
	}
}
