package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;
import java.util.ArrayList;


/**
 * {@code ResultServices} osztály az adott játékállás eredményének ellenőrzésére.
 * 
 * @author toti
 */
public class ResultServices {
    
    /**
     * Összehasonlítja a két tömböt, hogy hány szín egyezik meg, és hogy a színek
     * azonos pozícióban vannak.
     * 
     * @param guess a játékos tippjeinek tömbje
     * @param secret a titkos színek tömbje
     */
    public void blackpins(String[] guess, String[] secret) {
       
        int blacks = 0;

        for (int f = 0; f < 4; f++) {

            if (guess[f].equals(secret[f])) {
                blacks++;
            }
        }
        model.setBlackpin(blacks);
       
    }
    
    /**
     * Összehasonlítja a két tömböt, hogy hány szín egyezik meg,
     * és hogy ezeknek a színeknek a pozíciója eltérő.
     * 
     * @param guess a játékos tippjeinek tömbje
     * @param secret a titkos színek tömbje
     */
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
    
    /**
     * Ellenőrzi, hogy a játékos megnyerte a játékot.
     */
    public void win()
    {
         if (model.getBlackpin() == 4)
        {
            model.setWin(true);
        }
    }
    
    /**
     * Ellenőrzi, hogy a játékos elveszetette a játékot.
     */
    public void lose()
    {
        if (model.getRow()<0)
        {
            model.setLose(true);
        }
    }
    
}
