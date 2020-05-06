/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarmrmi;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dave
 */
public interface RMI extends Remote
{
    public String getData(String string) throws RemoteException;
    
    public String getSensorData() throws IOException;
    
    public void addData(String rmNo, String flNo, String stat) throws IOException;;
}
