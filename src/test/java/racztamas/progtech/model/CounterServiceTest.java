package racztamas.progtech.model;

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
public class CounterServiceTest {
    
    public CounterServiceTest() {
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
     * Test of IncrementId method, of class CounterService.
     */
    @Test
    public void testIncrementId() {
        System.out.println("IncrementId");
        CounterService instance = new CounterService();
        instance.NewGame();
        instance.IncrementId();
        assertEquals(0, model.getId());
    }

    /**
     * Test of DecrementId method, of class CounterService.
     */
    @Test
    public void testDecrementId() {
        System.out.println("DecrementId");
        CounterService instance = new CounterService();
        instance.NewGame();
        instance.DecrementId();
        assertEquals(-2, model.getId());
    }

    /**
     * Test of IncrementCol method, of class CounterService.
     */
    @Test
    public void testIncrementCol() {
        System.out.println("IncrementCol");
        CounterService instance = new CounterService();
        instance.NewGame();
        instance.IncrementCol();
        assertEquals(1, model.getCol());
    }

    /**
     * Test of DecrementCol method, of class CounterService.
     */
    @Test
    public void testDecrementCol() {
        System.out.println("DecrementCol");
        CounterService instance = new CounterService();
        instance.NewGame();
        instance.DecrementCol();
        assertEquals(-1, model.getCol());
    }

    /**
     * Test of ColToZero method, of class CounterService.
     */
    @Test
    public void testColToZero() {
        System.out.println("ColToZero");
        CounterService instance = new CounterService();
        instance.NewGame();
        instance.ColToZero();
        assertEquals(0, model.getCol());
    }

    /**
     * Test of DecrementRow method, of class CounterService.
     */
    @Test
    public void testDecrementRow() {
        System.out.println("DecrementRow");
        CounterService instance = new CounterService();
        instance.NewGame();
        instance.DecrementRow();
        assertEquals(8, model.getRow());
    }

    /**
     * Test of NewGame method, of class CounterService.
     */
    @Test
    public void testNewGame() {
        System.out.println("NewGame");
        CounterService instance = new CounterService();
        instance.NewGame();
        assertEquals(-1, model.getId());
        assertEquals(0, model.getCol());
        assertEquals(9, model.getRow());
        assertFalse(model.isWin());
        assertFalse(model.isLose());
    }
    
}
