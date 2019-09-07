package com.example.hackathon;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class PostUtils {
	public static String LOGIN_URL = "http://192.168.43.155:44305/api/urbanhive/about";
    public static String postData(String key)
    {
        String msg = "";
        try{
            HttpURLConnection conn = (HttpURLConnection) new URL(LOGIN_URL).openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Content-Type", "application/json");
            String data = "key="+ URLEncoder.encode(key, "UTF-8");
            OutputStream out = conn.getOutputStream();
            out.write(data.getBytes());
            out.flush();
             if (conn.getResponseCode() == 200) {  
                    InputStream is = conn.getInputStream();  
                    ByteArrayOutputStream message = new ByteArrayOutputStream();  
                    int len = 0;  
                    byte buffer[] = new byte[1024];  
                    while ((len = is.read(buffer)) != -1) {  
                        message.write(buffer, 0, len);  
                    }  
                    is.close();  
                    message.close();  
                    msg = new String(message.toByteArray(),"utf-8");  
                    return msg;
             }
        }catch(Exception e){e.printStackTrace();}
        return msg;
    }
}
