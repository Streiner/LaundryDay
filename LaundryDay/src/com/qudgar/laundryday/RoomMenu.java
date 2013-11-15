package com.qudgar.laundryday;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class RoomMenu extends Activity implements OnClickListener
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roomtype_layout);
		InitializeComponents();
	}
	
	public void InitializeComponents()
	{
		TextView currentUser;
		currentUser = (TextView)findViewById(R.id.textview_currentuser);
		currentUser.setText("Inloggad som " + LocalData.GetInstance().GetLogonName());
		
		Button buttonBook1 = (Button)findViewById(R.id.button_room1);
		buttonBook1.setOnClickListener(this);
		
		Button buttonBook2 = (Button)findViewById(R.id.button_room2);
		buttonBook2.setOnClickListener(this);
		
		Button buttonBook3 = (Button)findViewById(R.id.button_room3);
		buttonBook3.setOnClickListener(this);
		
		Button buttonBook4 = (Button)findViewById(R.id.button_room4);
		buttonBook4.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View clicked) 
	{
		int btn = clicked.getId();
		switch (btn)
		{
			case R.id.button_room1:
				ShowBookRoom();
					break;
			case R.id.button_room2:
				ShowBookRoom();
					break;
			case R.id.button_room3:
				ShowBookRoom();
					break;
			case R.id.button_room4:
				ShowBookRoom();
					break;
		}
	}
	private void ShowBookRoom()
	{
		Intent BookIntent = new Intent(this, BookRoom.class);
		startActivity(BookIntent);
	}

	
	
	

}
