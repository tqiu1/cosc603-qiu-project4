package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {

	VendingMachineItem item1, item2, item3;
	VendingMachine vm =new VendingMachine();
	
	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		item1 = new VendingMachineItem("bread", 1.00);
		item2 = new VendingMachineItem("cake", 1.50);

	}
	
	/**
	 * Test for the Constructor of VendingMachine class.
	 */
	@Test(expected=VendingMachineException.class)
	public void TestConstructor() {
	
		item3 = new VendingMachineItem("abc",-1.20);
	
	}
	
	/**
	 * Test for the getName()method of VendingMachine class.
	 */
	@Test
	public void TestGetName() {
	
		assertEquals("bread", item1.getName());	
		assertEquals("cake", item2.getName());	
	}
	
	/**
	 * Test for the getPrice()method of VendingMachine class.
	 */
	@Test
	public void TestGetPrice() {
	
		assertEquals(1.00, item1.getPrice(), 0.001);	
		assertEquals(1.5, item2.getPrice(), 0.001);	
	
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown(){
		item1 = null;
		item2 = null;

	}	
}
