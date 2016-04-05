package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineExceptionTest {
	
	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {

	}
	
	/**
	 * Test for the VendingMachineException(String reason) method of VendingMachine class.
	 */
	@Test
	public void testVendingMachineException() {
		new VendingMachineException("test");
		new VendingMachineException();
		
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown(){

	}	
}
