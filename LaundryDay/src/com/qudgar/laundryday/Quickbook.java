package com.qudgar.laundryday;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Quickbook extends Activity implements OnClickListener
{

    private Calendar rightNow = Calendar.getInstance();
	DateList dateList;

	TextView textDay; 
	TextView textDate; 
	TextView textTime;
	Button quickbookOK;
	
	int myDay;
	int myPass;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quickbook_layout);
		InitializeComponents();
	}

	@Override
	public void onClick(View clicked) 
	{
		
		int btn = clicked.getId();
		switch (btn)
		{
			case R.id.button_quickbook_OK:
				
				 String day = GetCurrentDay(myDay);
				 String date = GetCurrentDateDay(myDay) + "/" + GetCurrentMonth();
				 String pass = GetTime(myPass);
				 LocalData.GetInstance().SetBookedPass(day, date, pass);
				 textDay.setText(GetCurrentDay(myDay) + "  " + GetCurrentDateDay(myDay) + "/" + GetCurrentMonth() + "  " + GetTime(myPass));
				 textDate.setText("är");
				 textTime.setText("BOKAD");
				
				 quickbookOK.setEnabled(false);
				 
				break;
		}
	}
	
	private void InitializeComponents()
	{
		
		quickbookOK = (Button)findViewById(R.id.button_quickbook_OK);
		quickbookOK.setOnClickListener(this);
		
		textDay = (TextView)findViewById(R.id.textView_quickbook_day);
		textDate = (TextView)findViewById(R.id.textView_quickbook_date);
		textTime = (TextView)findViewById(R.id.textView_quickbook_time);

		dateList = new DateList();
		dateList.CreateEmptyList();

		myDay = FindFirstFreeDay();
		myPass = FindFirstFreePass();
		
		textDay.setText(GetCurrentDay(myDay));
		textDate.setText(GetCurrentDateDay(myDay) + "/" + GetCurrentMonth());
		textTime.setText(GetTime(myPass));
	}
	
	
	private int FindFirstFreeDay()
	{
		for (int index = 0; index < dateList.GetTotalDays(); index++)
		{
			for (int Jindex = 0; Jindex < dateList.GetTotalPass(); Jindex++)
			{
				if (dateList.GetDayandDate(index, Jindex))
				{
					return index;
				}
			}
		}
		return -1;
	}
	
	
	private int FindFirstFreePass()
	{
		for (int index = 0; index < dateList.GetTotalDays(); index++)
		{
			for (int Jindex = 0; Jindex < dateList.GetTotalPass(); Jindex++)
			{
				if (dateList.GetDayandDate(index, Jindex) == false)
				{
					return Jindex;
				}
			}
		}
		return -1;
		
	}

	
	private String GetCurrentDay(int aNewDay)
	 {
		  int temp = aNewDay + rightNow.get(Calendar.DAY_OF_WEEK);
	      
	      if (temp == 1) return "Söndag";
	      if (temp == 2) return "Måndag";
	      if (temp == 3) return "Tisdag";
	      if (temp == 4) return "Onsdag";
	      if (temp == 5) return "Torsdag";
	      if (temp == 6) return "Fredag";
	      if (temp == 7) return "Lördag";
	      if (temp == 8) return "Söndag";
	      if (temp == 9) return "Måndag";
	      if (temp == 10) return "Tisdag";
	      if (temp == 11) return "Onsdag";
	      if (temp == 12) return "Torsdag";
	      if (temp == 13) return "Fredag";
	      if (temp == 14) return "Lördag";
	      
	      return "XX";
	 }
	
	 private String GetCurrentDateDay(int aNewDay)
	 {
		 int temp = aNewDay + rightNow.get(Calendar.DAY_OF_MONTH);
		 
		 return Integer.toString(temp);
	 }
	 
	 private String GetCurrentMonth()
	 {
		 int temp = 1 + rightNow.get(Calendar.MONTH);
		 return Integer.toString(temp);
	 }
	 
	 private String GetTime(int aID)
	 {
		 if (aID == 0) return "8-10";
		 if (aID == 1) return "10-12";
		 if (aID == 2) return "12-14";
		 if (aID == 3) return "14-16";
		 if (aID == 4) return "16-18";
		 if (aID == 5) return "18-20";
		 
		 return "20-22";
	 }
}
