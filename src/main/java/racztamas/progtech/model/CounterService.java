package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;

/**
 * {@code CounterService} osztály, az értékek változatására.
 * 
 * @author toti
 */
public class CounterService {
    
    /**
     * Megnöveli eggyel az egyedi azonosító értékét.
     */
    public void IncrementId()
    {
        model.setId(model.getId()+1);
    }
    
    /**
     * Csökkenti eggyel az egyedi azonosító értékét.
     */
    public void DecrementId()
    {
        model.setId(model.getId()-1);
    }
    
    /**
     * Növeli eggyel az oszlop értékét.
     */
    public void IncrementCol()
    {
        model.setCol(model.getCol()+1);
    }
    
    /**
     * Csökkenti eggyel az oszlop értékét.
     */
    public void DecrementCol()
    {
        model.setCol(model.getCol()-1);
    }
    
    /**
     * Visszaállítja nullára az oszlop értékét.
     */
    public void ColToZero()
    {
        model.setCol(0);
    }
    
    /**
     * Csökkenti eggyel a sor értékét.
     */
    public void DecrementRow()
    {
        model.setRow(model.getRow()-1);
    }
    
    /**
     * Visszaállítja az értékeket a kezdőértékre.
     */
    public void NewGame()
    {
        model.setCol(0);
        model.setRow(9);
        model.setId(-1);
        model.setLose(false);
        model.setWin(false);
    }
}
