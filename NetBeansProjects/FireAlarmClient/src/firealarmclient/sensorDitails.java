/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarmclient;

/**
 *
 * @author Dave
 */
public class sensorDitails {
    
    public String roomNu;
    public String FloorNu;
    public int co2;
    public int smoke;
    public String status;

    public String getRoomNu() {
        return roomNu;
    }

    public void setRoomNu(String roomNu) {
        this.roomNu = roomNu;
    }

    public String getFloorNu() {
        return FloorNu;
    }

    public void setFloorNu(String FloorNu) {
        this.FloorNu = FloorNu;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getSmoke() {
        return smoke;
    }

    public void setSmoke(int smoke) {
        this.smoke = smoke;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    
}
