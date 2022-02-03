package library;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
public class Sendsms 
{
	public static Boolean sendsms(String mssg,String number)
	{
		try
		{
			String apikey="F9DsnAiXNLBQm3chv0MS8dYwe7kEu6Wq5KUPZo4IgTRlCzx1HpKgM6LFArsHGk2m3hW47BVwD1InzZu8";
			String sendId="FSTSMS";
			
			
			// encoding the message
			mssg=URLEncoder.encode(mssg,"UTF-8");
			String language="english";
			String route="p";
			
			//creating my url
			
			String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apikey+"&sender_id="+sendId+"&message="+mssg+"&language="+language+"&route="+route+"&numbers="+number;
			System.out.println("wait............");
			
			//sending get request from java....
			
			URL url=new URL(myUrl);
			HttpsURLConnection con=(HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			
			int code=con.getResponseCode();
			
			System.out.println("Response ="+code);
			
			StringBuffer response=new StringBuffer();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			while(true)
			{
				String line=br.readLine();
				if(line==null)
				{
					break;
				}
				response.append(line);
			}
			System.out.println(response);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Program started.........");
		
	}


}
