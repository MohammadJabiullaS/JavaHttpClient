package com.code.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			URL url = new URL("https://cricbuzz-cricket.p.rapidapi.com/schedule/v1/international");
			HttpURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestMethod("GET");
			connection.setRequestProperty("x-rapidapi-key", "fb802404c7msh710a2f6584f529ap134daajsn77e932b2a006");
			
			int responseCode= connection.getResponseCode();
			System.out.println("HttpClient Response Code is:"+responseCode);
			String inputLine;
			StringBuilder content = new StringBuilder();
			
			if( responseCode == 200)
				{
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while((inputLine= in.readLine()) != null)
				{
					content.append(inputLine);
				}
				in.close();
				}
			connection.disconnect();
			System.out.println("Response Content:"+ content.toString());
			
		} catch(IOException e) {
			System.out.println("An I/O exception occured:"+e.getMessage());
		}
		
		
		

	}
	
	

}
