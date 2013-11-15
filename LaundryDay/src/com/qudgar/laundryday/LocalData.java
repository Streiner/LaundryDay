package com.qudgar.laundryday;

import java.util.ArrayList;
import java.util.List;

public class LocalData
{
	private static LocalData myInstance = null;
	
	
	private String myLogonName;
	private String myPassword;
	private Boolean myAutoLogon;
	
	private Boolean my10Alarm;
	private Boolean my30Alarm;
	private Boolean my60Alarm;
	private Boolean my90Alarm;
	private Boolean my120Alarm;

	private List<BookedTimes> myBookedTimeList = new ArrayList<BookedTimes>();
	
	public static void CreateInstance()
	{
		myInstance = new LocalData();
	}
	

	public static LocalData GetInstance()
	{
		return myInstance;
	}
	
	public void SetLogonName(String aLogonName)
	{
		myLogonName = aLogonName;
	}
	
	public void SetPassword(String aPassword)
	{
		myPassword = aPassword;
	}
	
	public void SetAutoLogon(Boolean aBool)
	{
		myAutoLogon = aBool;
	}
	
	public String GetLogonName()
	{
		return myLogonName;
	}
	
	public String GetPassword()
	{
		return myPassword;
	}
	
	public Boolean GetAutoLogon()
	{
		return myAutoLogon;
	}
	
	
	public int GetBookedTimeSize()
	{
		return myBookedTimeList.size();	
	}
	
	public String GetBookedDay(int aID)
	{
		return myBookedTimeList.get(aID).myDay;
	}
	
	public String GetBookedDate(int aID)
	{
		return myBookedTimeList.get(aID).myDate;
	}
	
	public String GetBookedPass(int aID)
	{
		return myBookedTimeList.get(aID).myPass;
	}
	
	public void SetBookedPass(String aDay, String aDate, String aPass)
	{
		BookedTimes tempBookedTimes = new BookedTimes();
		
		if (aDay == "Sö") {aDay = "Söndag";}
		if (aDay == "Må") {aDay = "Måndag";}
		if (aDay == "Ti") {aDay = "Tisdag";}
		if (aDay == "Os") {aDay = "Onsdag";}
		if (aDay == "To") {aDay = "Torsdag";}
		if (aDay == "Fr") {aDay = "Fredag";}
		if (aDay == "Lö") {aDay = "Lördag";}
		
		tempBookedTimes.myDay = aDay;
		tempBookedTimes.myDate = aDate;
		tempBookedTimes.myPass = aPass;
		
		myBookedTimeList.add(tempBookedTimes);
	}
	
	public void DeleteBookedTime(int aID)
	{
		if (aID < myBookedTimeList.size())
		{
			myBookedTimeList.remove(aID);
		}
	}
	

	public void SetAlarm(int aIDAlarm, Boolean aBool)//, Boolean a30, Boolean a60, Boolean a90, Boolean a120)
	{
		if (aIDAlarm == 10) {my10Alarm = aBool;}
		if (aIDAlarm == 30) {my30Alarm = aBool;}
		if (aIDAlarm == 60) {my60Alarm = aBool;}
		if (aIDAlarm == 90) {my90Alarm = aBool;}
		if (aIDAlarm == 120) {my120Alarm = aBool;}
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
	
	
	private class BookedTimes
	{
		private String myDay;
		private String myDate;
		private String myPass;
	}
	
}

