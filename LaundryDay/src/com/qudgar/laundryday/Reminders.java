package com.qudgar.laundryday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;
import android.widget.TextView;

public class Reminders extends Activity implements OnClickListener
{

	private Switch _10min;
	private Switch _30min;
	private Switch _60min;
	private Switch _90min;
	private Switch _120min;
	SavedSettings mySavedSettings = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminders_layout);
		InitializeComponents();
		
		mySavedSettings = new SavedSettings(this);
		
	}
	public void InitializeComponents()
	{
		_10min = (Switch)findViewById(R.id.switch10);
		_10min.setOnClickListener(this);
		_10min.setChecked(LocalData.GetInstance().GetAlarm(10));
		
		
		_30min = (Switch)findViewById(R.id.switch30);
		_30min.setOnClickListener(this);
		_30min.setChecked(LocalData.GetInstance().GetAlarm(30));
		
		_60min = (Switch)findViewById(R.id.switch60);
		_60min.setOnClickListener(this);
		_60min.setChecked(LocalData.GetInstance().GetAlarm(60));
		
		_90min = (Switch)findViewById(R.id.switch90);
		_90min.setOnClickListener(this);
		_90min.setChecked(LocalData.GetInstance().GetAlarm(90));
		
		_120min = (Switch)findViewById(R.id.switch120);
		_120min.setOnClickListener(this);
		_120min.setChecked(LocalData.GetInstance().GetAlarm(120));
		
		
		TextView currentUser;
		currentUser = (TextView)findViewById(R.id.textview_currentuser);
		currentUser.setText("Inloggad som " + LocalData.GetInstance().GetLogonName());
	}

	
	public void onClick(View switchbtn) 
	{
		int id = switchbtn.getId();
		if (id == R.id.switch10) 
		{
			LocalData.GetInstance().SetAlarm(10, _10min.isChecked());
			mySavedSettings.SaveOnlyAlarm(10, LocalData.GetInstance().GetAlarm(10));
		}
		else if (id == R.id.switch30) 
		{
			LocalData.GetInstance().SetAlarm(30, _30min.isChecked());
			mySavedSettings.SaveOnlyAlarm(30, LocalData.GetInstance().GetAlarm(30));
		}
		else if (id == R.id.switch60) 
		{
			LocalData.GetInstance().SetAlarm(60, _60min.isChecked());
			mySavedSettings.SaveOnlyAlarm(60, LocalData.GetInstance().GetAlarm(60));
		}
		else if (id == R.id.switch90) 
		{
			LocalData.GetInstance().SetAlarm(90, _90min.isChecked());
			mySavedSettings.SaveOnlyAlarm(90, LocalData.GetInstance().GetAlarm(90));
		}
		else if (id == R.id.switch120) 
		{
			LocalData.GetInstance().SetAlarm(120, _120min.isChecked());
			mySavedSettings.SaveOnlyAlarm(120, LocalData.GetInstance().GetAlarm(120));
		}		
	}
}
