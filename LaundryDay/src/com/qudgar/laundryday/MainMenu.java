package com.qudgar.laundryday;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends Activity implements OnClickListener
{



	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		
		InitializeComponents();
	
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		LayoutInflater inflater = getLayoutInflater();
		//inflater.inflate(R.menu.activity_itemslist, menu);
		return true;
	}



	public void InitializeComponents()
	{
		Button buttonMyBookings = (Button)findViewById(R.id.button_myBookedTimes);
		buttonMyBookings.setOnClickListener(this);
		
		
		Button buttonBookTime = (Button)findViewById(R.id.button_bookNewTime);
		buttonBookTime.setOnClickListener(this);
		
		Button buttonReminders = (Button)findViewById(R.id.button_reminders);
		buttonReminders.setOnClickListener(this);		
		
		Button buttonQuckbook = (Button)findViewById(R.id.button_quickbook);
		buttonQuckbook.setOnClickListener(this);
		
		TextView currentUser;
		currentUser = (TextView)findViewById(R.id.textview_currentuser);
		currentUser.setText("Inloggad som " + LocalData.GetInstance().GetLogonName());
				
	}
	
	public void onClick(View btn) 
	{
		int id = btn.getId();
		if (id == R.id.button_myBookedTimes) 
		{
			Intent bookedTimesIntent = new Intent(this, MyBookedTimes.class);
			startActivity(bookedTimesIntent);
		} 
		else if (id == R.id.button_bookNewTime) 
		{
			Intent bookNewIntent = new Intent(this, RoomMenu.class);
			startActivity(bookNewIntent);
		} 
		else if (id == R.id.button_reminders) 
		{
			Intent reminderIntent = new Intent(this, Reminders.class);
			startActivity(reminderIntent);
		}
		else if (id == R.id.button_quickbook)
		{
			Intent quickbookIntent = new Intent(this, Quickbook.class);
			startActivity(quickbookIntent);
		}
	}

}


