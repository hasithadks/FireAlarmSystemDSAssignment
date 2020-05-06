/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarmserver;

/**
 *
 * @author Dave
 */
public class Sensor {
    private String id;
    private int roomNo;
    private int floorNO;
    private boolean status;
    private int smokeLevel;
    private int co2Level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNO() {
        return floorNO;
    }

    public void setFloorNO(int floorNO) {
        this.floorNO = floorNO;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSmokeLevel() {
        return smokeLevel;
    }

    public void setSmokeLevel(int smokeLevel) {
        this.smokeLevel = smokeLevel;
    }

    public int getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(int co2Level) {
        this.co2Level = co2Level;
    }

  
    public int getReadingco2(){
        int min = 0;
        int max = 10;
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
    
    public int getReadingSmoke(){
        int min = 0;
        int max = 10;
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
