/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;
import java.util.ArrayList;


/**
 *
 * @author toti
 */
public class ResultServices {
    
    public void blackpins(String[] guess, String[] secret) {
       
        int blacks = 0;

        for (int f = 0; f < 4; f++) {

            if (guess[f].equals(secret[f])) {
                blacks++;
            }
        }
        model.setBlackpin(blacks);
       
    }
    
    public void whitepins(String[] guess, String[] secret) {

        int whites = 0;

        ArrayList<Integer> alreadyProcessed = new ArrayList<>();

        for (String color : secret) {
            int same = 0;
            for (int k = 0; k < 4; k++) {
                if (color.equals(guess[k]) && !alreadyProcessed.contains(k)) {
                    if (same < 1) {
                        alreadyProcessed.add(k);
                        whites++;
                        same++;
                    }
                }
            }
        }
        
        model.setWhitepin(whites);
        model.setWhitepin(model.getWhitepin()- model.getBlackpin());
    }
    
    public void win()
    {
         if (model.getBlackpin() == 4)
        {
            model.setWin(true);
        }
    }
    
    public void lose()
    {
        if (model.getRow()<0)
        {
            model.setLose(true);
        }
    }
    
}
