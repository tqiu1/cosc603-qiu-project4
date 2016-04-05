package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class VendingMachineTest {
	
	/** Declaring necessary test objects for {@link VendingMachine} */
	VendingMachineItem item1, item2, item3, item4;
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
		item3 = new VendingMachineItem("Icecream", 2.50);
		item4 = new VendingMachineItem("Hamburger", 4);
	}
	
	
	/**
	 * Test for the getSlotIndex(String code) method of VendingMachine class.
	 */
	@Test(expected=VendingMachineException.class)
	public void testGetSlotIndex() {

		assertEquals(0, vm.getSlotIndex("A"));
		assertEquals(1, vm.getSlotIndex("B"));
		assertEquals(2, vm.getSlotIndex("C"));
		assertEquals(3, vm.getSlotIndex("D"));
		vm.getSlotIndex("G");	
		//assertEquals(null, vm.getSlotIndex("G"));
	}
	
	
	/**
	 * Test for the addItem(VendingMachineItem item, String code) method of VendingMachine class.
	 */
	@Test(expected=VendingMachineException.class)
	public void testAddItem() {
		vm.addItem(item1, "A");
		vm.addItem(item2, "B");
			
		assertEquals(item1, vm.itemArray[0]);
		assertEquals(item2, vm.itemArray[1]);

		
		vm.addItem(item1, "B");
	}
	
	/**
	 * Test for the removeItem(String code) method of VendingMachine class.
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem() {
		vm.addItem(item1, "A");
		assertEquals(item1, vm.removeItem("A"));
		vm.addItem(item2, "B");
		assertEquals(item2, vm.removeItem("C"));
		
		//assertEquals(item2, vm.removeItem("2"));
	}
	
	/**
	 * Test for the insertMoney(double amount) method of VendingMachine class.
	 */
	@Test(expected=VendingMachineException.class)
	public void testInsertMoney() {
		vm.insertMoney(1.50);
		assertEquals(1.50, vm.balance, 0.001);
		vm.insertMoney(2.00);
		assertEquals(3.50, vm.balance, 0.001);
		vm.insertMoney(-0.5);
		assertEquals(3.50, vm.balance, 0.001);
	}
	
	/**
	 * Test for the getBalance()method of VendingMachine class.
	 */
	@Test
	public void testGetBalance() {
		vm.insertMoney(1.50);	
		assertEquals(1.5, vm.getBalance(), 0.001);
	}

	/**
	 * Test for the makePurchase()method of VendingMachine class.
	 */
	@Test
	public void TestMakePurchase() {
		vm.addItem(item3, "B");
		vm.addItem(item4, "C");
		vm.balance=3.5;
		assertFalse(vm.makePurchase("C"));
		assertFalse(vm.makePurchase("A"));
		assertTrue(vm.makePurchase("B"));
		
		
	}
	
	/**
	 * Test for the returnChange()method of VendingMachine class.
	 */
	@Test
	public void TestReturnChange() {
		
		vm.insertMoney(3.00);
		vm.addItem(item3, "B");
		vm.makePurchase("B");
		assertEquals(0.5, vm.returnChange(), 0.001);	
	
	}
	
	/**
	 * Test for the getItem()method of VendingMachine class.
	 */
	@Test	
	public void TestgetItem() throws VendingMachineException {
		vm.addItem(item1, "A");
		vm.addItem(item2, "B");
		assertEquals(item1, vm.getItem("A"));
		assertEquals(item2, vm.getItem("B"));
	}
	
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown(){
		item1 = null;
		item2 = null;
		item3 = null;
		item4 = null;
	}
}
