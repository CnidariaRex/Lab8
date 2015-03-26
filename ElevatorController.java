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
public class ElevatorController {

    /**
     * @param args the command line arguments
     */
    
    private static ElevatorView view;
    private static ElevatorModel model;
    
    public static void main(String[] args) {
        // TODO code application logic here
        view = new ElevatorView();
        model = new ElevatorModel(10, 7, 0, true);
        
        model.boardPassenger(3);
        model.boardPassenger(3);
        model.boardPassenger(5);
        
        for (int i=0; i<12; i++) 
        {
            view.ElevatorPrint(model.toString());
            model.move();
            view.ElevatorPrint(model.toString());
        }
        
        
    }
    
}
