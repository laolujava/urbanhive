package com.example.hackathon;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
	
	private SensorManager mSensorManager;
	//private TextView mTxtValue=null;
	private TextView gpsTxtValue=null;
	private TextView imeiTxtValue=null;
	private TextView netTxtValue=null;
	private TextView xyzValue=null ;
	private Sensor mSensor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//imei
		TelephonyManager TelephonyMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE); 
		String imei = TelephonyMgr.getDeviceId(); 
		
		//陀螺仪
		//mTxtValue = (TextView) findViewById(R.id.text);
		xyzValue = (TextView) findViewById(R.id.xyzValue);
		//gps
		gpsTxtValue = (TextView) findViewById(R.id.gps);
		//imei
		imeiTxtValue = (TextView) findViewById(R.id.imei);
		imeiTxtValue.setText("imei:"+UUID.randomUUID());
		//net
		netTxtValue = (TextView) findViewById(R.id.net);
		
		
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		//gps
		final LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        showLocation(location);
        
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, new LocationListener(){
        	 
			public void onLocationChanged(Location location) {
				showLocation(location);
			}
 
			public void onProviderDisabled(String provider) {
				showLocation(null);
			}
 
			public void onProviderEnabled(String provider) {
				showLocation(locationManager.getLastKnownLocation(provider));
			}
 
			public void onStatusChanged(String provider, int status, Bundle extras) {
			}
        	
        });
        
        
        //josn
        
        //Test t=new Test();
        //netTxtValue.setText(t.show());
        /////////定时器5s//////////
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
            	//showData((int)(1+Math.random()*(10-1+1))+"");
            	
            	VibrationDataStructure a1=new VibrationDataStructure();
    	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	        a1.setCollecting_time(sf.format(new Date()));
    	        //获取gps数据
    	        String gps=(String) gpsTxtValue.getText();
    	        String gpsArr[]=gps.split(",");
    	        a1.setGeo_latitude(Double.parseDouble(gpsArr[0]));
    	        a1.setGeo_longitude(Double.parseDouble(gpsArr[1]));
    	        
    	        List<String> xyzList=new ArrayList<String>();
    	        
    	        for(int i=0;i<10;i++) {
    	        	try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    	        	String xyz=(String) xyzValue.getText();
        	        String [] xyzArr=xyz.split(",");
        	        xyzList.add(xyzArr[0]);
        	        xyzList.add(xyzArr[1]);
        	        xyzList.add(xyzArr[2]);
    	        }
    	        
    	        //double [] y= {Double.parseDouble(xyzArr[0]),Double.parseDouble(xyzArr[1]),Double.parseDouble(xyzArr[2])};
    	        //double x[]={0.139932,0.69219730,9.72075107,0.129932,0.62212730,9.62075107};
    	        double x[]=new double[30];
    	        for(int i=0;i<30;i++) {
    	        	String v=xyzList.get(i);
    	        	x[i]=Double.parseDouble(v);
    	        }
    	        a1.setGyro_data(x);
    	        a1.setSensor_id(UUID.randomUUID()+"");
    	        a1.setSensor_type(1);
    	        //VibrationDataStructure a2=a1;
    	        List list=new ArrayList();
    	        list.add(a1);
    	        //list.add(a2);
    	        JSONObject j=new JSONObject();
    	        
    	        JSONArray jsonArray=new JSONArray(list);
    	        String s=jsonArray.toString();
    	        s=s.substring(1,s.length()-1);
    	        PostUtils post=new PostUtils();
    			String r=post.postData(s);
            }

        }, 5000,5000);
        
	}
	
	private void showData(final String s) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
            	
            	netTxtValue.setText(s);
                if (s == null){

                    System.out.println("this");
                }else {
                    System.out.println("不是");
                }
            }
        });
    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override

	protected void onResume() {
	    super.onResume();
	    mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME);

	}
	@Override

	protected void onStop() {
	    super.onStop();
	    mSensorManager.unregisterListener(this);
	}

	public void doStart(View view) {
		Toast.makeText(MainActivity.this, "start!已开始!", Toast.LENGTH_SHORT).show();
		// do
		PostUtils post=new PostUtils();
		
		String s=post.postData("a");
		showData(s);
	}

	public void doStop(View view) {
		Toast.makeText(MainActivity.this, "stop!已停止!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			xyzValue.setText( x + "," + y + "," + z);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}
	public void showLocation(Location currentLocation){
    	if(currentLocation != null){
	    	String s = "";
	    	s += currentLocation.getLongitude();
	    	s += ",";
	    	s += currentLocation.getLatitude();
	    	gpsTxtValue.setText(s);
    	}
    	else{
    		gpsTxtValue.setText("");
    	}
    }
}
