package com.qudgar.laundryday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log; 


public class LogInManager 
{
	String WebUrl = "http://aptus01/localhost/service/Login?Customer=058%200001&Timestamp=2013-05-08T14:51:44Z&Hash=XDoQeA-F5BH-5Eaql5lgmi0joYE*";
	
	
	
	public void test()
	{
		JSONObject json = connect("http://aptus01/localhost/service/Login?Customer=058%200001&Timestamp=2013-05-08T14:51:44Z&Hash=XDoQeA-F5BH-5Eaql5lgmi0joYE*");
	}
	
	
	
	public JSONObject connect(String url)
	{
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response;
		JSONObject json = new JSONObject();
		
		try
		{
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			if (entity != null) 
			{
				
				InputStream instream = entity.getContent();
				String result= convertStreamToString(instream);
				json=new JSONObject(result);
				
				instream.close();
			}

		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} catch (JSONException e)
		{
			e.printStackTrace();
		}
		return json;	
	}
	
	
	public String convertStreamToString(InputStream is)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		
		String line = null;
		try
		{
			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	
	
	

}
