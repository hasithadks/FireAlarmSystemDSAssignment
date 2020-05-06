/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarmserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import firealarmrmi.RMI;
import java.io.DataOutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import sun.net.URLCanonicalizer;

/**
 *
 * @author Dave
 */
public class RMIServer extends UnicastRemoteObject implements RMI {

    String inline;
    String finalText;
    String arr[];
    Service srv;

    public RMIServer() throws RemoteException {
        super();
    }

    @Override
    public String getData(String string) throws RemoteException {
        string = "Hi " + string;
        return string;
    }

    public static void main(String[] args) {
        
        Service s1 = new Service();
        try {
            Registry reg = LocateRegistry.createRegistry(1090);
            reg.rebind("server", new RMIServer());
            System.out.println("server started");

        } catch (Exception e) {
            System.out.println(e);
        }

//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            public void run() {
//                System.out.println("Every 40 second");
//               
//          //      s1.addSensorDetails();
//             
//            }
//        };
//        timer.schedule(task, 0L, 10000L);
//
//        System.out.println("After thread");
        
        
    }

    @Override
    public String getSensorData() throws MalformedURLException, IOException {
        String newfinaltext2 = null;
        URL link = new URL("http://localhost:5000/infos/");
        System.out.println("link fetch complete");
        URLConnection conn = link.openConnection();
        System.out.println("4");

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = buff.readLine()) != null) {
                //System.out.println(line);
                finalText = line;

            }
            System.out.println(finalText);
            String newfinaltext = finalText.replace("[", "");
            newfinaltext2 = newfinaltext.replace("]", "");
            System.out.println(newfinaltext2);
            System.out.println("completed");

//            JSONParser parser = new JSONParser(finalText, global, true);
//            JSONObject jobj = (JSONObject) parser.parse();
//            System.out.println(jobj);
        } catch (IOException ex) {
             ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        return newfinaltext2;
    }
//
    @Override
    public void addData(String rmNo, String flNo, String stat)
    {
        ArrayList<Sensor> sensorList = new ArrayList<>();
        
        if((!(rmNo.equals(null)))&&((!(flNo.equals(null))))&&((!(stat.equals(null)))))
        {
            Sensor s = new Sensor();
            s.setRoomNo(Integer.parseInt(rmNo));
            s.setFloorNO(Integer.parseInt(flNo));
            
            boolean finalstat = false;
            if(stat.equalsIgnoreCase("true"))
            {
                finalstat = true;
            }
            else if(stat.equalsIgnoreCase("false"))
            {
                finalstat = false;
            }
            
            s.setStatus(finalstat);
            s.setCo2Level(s.getReadingco2());
            s.setSmokeLevel(s.getReadingSmoke());
            
            
           
            String postData = "status=" +s.getStatus() + "&floorNo=" +s.getFloorNO()+ "&roomNo=" +s.getRoomNo();
            srv.postSensorDetails(postData);
            System.out.println("insideloop"+ postData);

        }
    }

}
