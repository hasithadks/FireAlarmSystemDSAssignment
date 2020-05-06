/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarmserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Dave
 */
public class Service {
    public void postDetails(String postData) {
                
         try {

                    URL urls = new URL("http://localhost:5000/infos/add");
                    //String postData = "foo1=bar1&foo2=bar2";
                    
                    
                    
                    HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
                    conn.setUseCaches(false);

                    try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                        dos.writeBytes(postData);
                    }

                    try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                     System.out.println(e.getMessage());
                }

    }
    
    
    
        public void postSensorDetails(String postSensorData) {
                
         try {

                    URL urls = new URL("http://localhost:5000/sensor/add");
                    //String postData = "foo1=bar1&foo2=bar2";
                    
                    
                    
                    HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setRequestProperty("Content-Length", Integer.toString(postSensorData.length()));
                    conn.setUseCaches(false);

                    try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                        dos.writeBytes(postSensorData);
                    }

                    try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                     System.out.println(e.getMessage());
                }

    }
        
    public void addSensorDetails(){
    
//        ArrayList<Sensor>sensorList = new ArrayList<>();
//        
//        Sensor s1 = new Sensor();
//        Sensor s2 = new Sensor();
//        Sensor s3 = new Sensor();
//        Sensor s4 = new Sensor();
//        
//        s1.setRoomNo(401);
//        s1.setFloorNO(4);
//        s1.setStatus(true);
//        s1.setCo2Level(s1.getReadingco2());
//        s1.setSmokeLevel(s1.getReadingSmoke());
//         
//        s2.setRoomNo(501);
//        s2.setFloorNO(5);
//        s2.setStatus(false);
//        s2.setCo2Level(s2.getReadingco2());
//        s2.setSmokeLevel(s2.getReadingSmoke());
//         
//        s3.setRoomNo(601);
//        s3.setFloorNO(6);
//        s3.setStatus(true);
//        s3.setCo2Level(s3.getReadingco2());
//        s3.setSmokeLevel(s3.getReadingSmoke());
//        
//        s4.setRoomNo(701);
//        s4.setFloorNO(7);
//        s4.setStatus(false);
//        s4.setCo2Level(s4.getReadingco2());
//        s4.setSmokeLevel(s4.getReadingSmoke());
//        
//        sensorList.add(s1);
//        sensorList.add(s2);
//        sensorList.add(s3);
//        sensorList.add(s4);
//        
//        
//        for (Sensor sensor: sensorList){
//            String postData = "activity=" +sensor.getStatus() + "&co2Level=" +sensor.getCo2Level()+ "&smokeLevel=" +sensor.getSmokeLevel()+ "&floorNo=" + sensor.getFloorNO()+"&roomNo="+sensor.getRoomNo();
//            postDetails(postData);
//            System.out.println("insideloop");
//        }
    }
}
