/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;

/**
 *
 * @author toti
 */
public class CounterService {
    
    public void IncrementId()
    {
        model.setId(model.getId()+1);
    }
    
    public void DecrementId()
    {
        model.setId(model.getId()-1);
    }
    
    public void IncrementCol()
    {
        model.setCol(model.getCol()+1);
    }
    
    public void DecrementCol()
    {
        model.setCol(model.getCol()-1);
    }
    
    public void ColToZero()
    {
        model.setCol(0);
    }
    
    public void DecrementRow()
    {
        model.setRow(model.getRow()-1);
    }
    
    public void NewGame()
    {
        model.setCol(0);
        model.setRow(9);
        model.setId(-1);
        model.setLose(false);
        model.setWin(false);
    }
}
