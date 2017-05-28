/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racztamas.progtech.model;

import racztamas.progtech.model.ResultServices;
import static racztamas.progtech.controller.FXMLController.model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author toti
 */
public class ResultServicesTest {

    public ResultServicesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of blackpins method, of class ResultServices.
     */
    @Test
    public void testBlackpins() {
        System.out.println("blackpins");
        String[] guess = {"redbutton", "yellowbutton", "redbutton", "yellowbutton"};
        String[] secret = {"redbutton", "yellowbutton", "redbutton", "yellowbutton"};
        ResultServices instance = new ResultServices();
        instance.blackpins(secret, guess);
        assertEquals(4, model.getBlackpin());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of whitepins method, of class ResultServices.
     */
    @Test
    public void testWhitepins() {
        System.out.println("whitepins");
        String[] guess = {"redbutton", "yellowbutton", "redbutton", "yellowbutton"};
        String[] secret = {"yellowbutton", "redbutton", "yellowbutton", "redbutton"};
        model.setBlackpin(0);
        ResultServices instance = new ResultServices();
        instance.whitepins(guess, secret);
        assertEquals(4, model.getWhitepin());
    }

    /**
     * Test of win method, of class ResultServices.
     */
    @Test
    public void testWin() {
        System.out.println("win");
        ResultServices instance = new ResultServices();
        model.setBlackpin(4);
        instance.win();
        assertTrue(model.isWin());
    }

    /**
     * Test of lose method, of class ResultServices.
     */
    @Test
    public void testLose() {
        System.out.println("lose");
        ResultServices instance = new ResultServices();
        model.setRow(-1);
        instance.lose();
        assertTrue(model.isLose());
    }

}
