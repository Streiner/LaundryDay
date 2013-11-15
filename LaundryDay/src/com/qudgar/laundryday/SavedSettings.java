package com.qudgar.laundryday;

import android.content.SharedPreferences;
import android.content.Context;

public class SavedSettings
{

	private final Context context;
	
	private final static String LaundryDaySavedSettings = "savedPreferences";
    private final static String USERNAME_KEYNAME = "USERNAME_KEY";
    private final static String PASSWORD_KEYNAME = "PASSWORD_KEY";
    private final static String REMEMBERME_KEYNAME = "REMEMBERME_KEY";
    private final static String ALARM_10 = "ALARM_10";
    private final static String ALARM_30 = "ALARM_30";
    private final static String ALARM_60 = "ALARM_60";
    private final static String ALARM_90 = "ALARM_90";
    private final static String ALARM_120= "ALARM_120";
	
	private String myUserName;
	private String myPassword;
	private Boolean myRememberMe;

	private Boolean my10Alarm;
	private Boolean my30Alarm;
	private Boolean my60Alarm;
	private Boolean my90Alarm;
	private Boolean my120Alarm;
	
	public SavedSettings(Context ctx)
	{
		this.context = ctx;
	}
	
	
	public void LoadData()
	{
		SharedPreferences prefs = context.getSharedPreferences(LaundryDaySavedSettings, Context.MODE_PRIVATE);
		
		myUserName = prefs.getString(USERNAME_KEYNAME, "unknown");
		myPassword = prefs.getString(PASSWORD_KEYNAME, "unknown");
		myRememberMe = prefs.getBoolean(REMEMBERME_KEYNAME, false);
		my10Alarm = prefs.getBoolean(ALARM_10, false);
		my30Alarm = prefs.getBoolean(ALARM_30, false);
		my60Alarm = prefs.getBoolean(ALARM_60, false);
		my90Alarm = prefs.getBoolean(ALARM_90, false);
		my120Alarm = prefs.getBoolean(ALARM_120, false);
	}
	
	public void Save(String aUserName, String aPassword)
	{
		SharedPreferences prefs = context.getSharedPreferences(LaundryDaySavedSettings, Context.MODE_PRIVATE);
		SharedPreferences.Editor edit = prefs.edit();
		
		edit.putString(USERNAME_KEYNAME, aUserName);
		edit.putString(PASSWORD_KEYNAME, aPassword);
		edit.putBoolean(REMEMBERME_KEYNAME, true);
		edit.putBoolean(ALARM_10,  false);
		edit.putBoolean(ALARM_30,  false);
		edit.putBoolean(ALARM_60,  false);
		edit.putBoolean(ALARM_90,  false);
		edit.putBoolean(ALARM_120, false);
		
		edit.commit();
	}
	
	public void SaveOnlyAlarm(int aID, Boolean aBool)
	{
		SharedPreferences prefs = context.getSharedPreferences(LaundryDaySavedSettings, Context.MODE_PRIVATE);
		SharedPreferences.Editor edit = prefs.edit();
		
		if (aID == 10) {edit.putBoolean(ALARM_10, aBool);}
		if (aID == 30) {edit.putBoolean(ALARM_30, aBool);}
		if (aID == 60) {edit.putBoolean(ALARM_60, aBool);}
		if (aID == 90) {edit.putBoolean(ALARM_90, aBool);}
		if (aID == 120) {edit.putBoolean(ALARM_120, aBool);}
		
		edit.commit();
		
		
	}
	
	public Boolean GetRememberMe()
	{
		return myRememberMe;	
	}
	
	public String GetUserName()
	{
		return myUserName;
	}
	
	public String GetPassword()
	{
		return myPassword;
	}

	public Boolean GetAlarm(int aIDAlarm)
	{
		if (aIDAlarm == 10)  {return my10Alarm;}
		if (aIDAlarm == 30)  {return my30Alarm;}
		if (aIDAlarm == 60)  {return my60Alarm;}
		if (aIDAlarm == 90)  {return my90Alarm;}
		if (aIDAlarm == 120) {return my120Alarm;}
		
		return false;
	}
	

}
