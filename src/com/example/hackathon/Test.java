package com.example.hackathon;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
	 public static String show() {
	        VibrationDataStructure a1=new VibrationDataStructure();
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        a1.setCollecting_time(sf.format(new Date()));
	        a1.setGeo_latitude(120.0122423423);
	        a1.setGeo_longitude(30.28237409);
	        double y[]=new double[21];
	        for (int i = 0; i < 21; i++) {
	            if (i % 3 == 0) {
	                y[i]=0.139932;
	            }
	            if (i % 3 == 1) {
	                y[i]=0.69219730;
	            }
	            if (i % 2 == 0) {
	                y[i]=9.72075107;
	            }
	        }

	        //double x[]={0.139932,0.69219730,9.72075107,0.129932,0.62212730,9.62075107};
	        a1.setGyro_data(y);
	        a1.setSensor_id("u123456");
	        a1.setSensor_type(1);
	        VibrationDataStructure a2=a1;
	        List list=new ArrayList();
	        list.add(a1);
	        list.add(a2);
	        JSONArray jsonArray=new JSONArray(list);
	        System.out.println(jsonArray.toString());
	        return jsonArray.toString();
	    }
}
