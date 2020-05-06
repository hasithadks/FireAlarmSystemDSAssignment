/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarmclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import firealarmrmi.RMI;

/**
 *
 * @author Dave
 */
public class RMIClient {
    
    public static void main(String[] args) {
        RMIClient client = new RMIClient();
        client.connectServer();
    }

    private void connectServer() {
        try{
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",8080);
            RMI rmi = (RMI) reg.lookup("server");
            System.out.println("Connected to Server");
            String text = rmi.getData("Thamize");
            System.out.println(text);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
