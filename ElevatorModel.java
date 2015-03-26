/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorcontroller;

/**
 *
 * @author Rex
 */
public class ElevatorModel {
    private int MAX_CAPACITY;
    private  int NUM_FLOORS;
    private int current_floor;
    private boolean moving_up;
    private int passenger_targets[];
    //Floor floors[];
    
    ElevatorModel(int MAX_CAPACITY, int NUM_FLOORS, int current_floor, boolean moving_up)
    {
        this.MAX_CAPACITY = MAX_CAPACITY;
        this.NUM_FLOORS = NUM_FLOORS;
        this.current_floor = current_floor;
        this.moving_up = moving_up;
        passenger_targets = new int[NUM_FLOORS];
    }
    
    public String toString() {
        int passengers = 0;
        for (int i=0; i<passenger_targets.length; i++) {
            if (passenger_targets[i] > 0) {
                passengers += passenger_targets[i];
            }
        }
        return "Current Passengers: "+passengers+"\tCurrent Floor: "+(current_floor+1)+"\tDirection: "+(moving_up?"Up":"Down");
    }
        
    
    public void move() {
        if (moving_up) {
            current_floor++;
        }
        else {
            current_floor--;
        }
        if (current_floor == 0) {
            moving_up = true;
        }
        else if (current_floor == NUM_FLOORS-1) {
            moving_up = false;
        }
         
        if (passenger_targets[current_floor] != 0) {
           passenger_targets[current_floor] = 0;
           System.out.println("Passengers unloaded on floor " + (current_floor+1));
        }
    } 
    
    public void boardPassenger(int floor) {
        floor--;
        passenger_targets[floor]++;
    }
}
