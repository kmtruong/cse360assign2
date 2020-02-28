package cse360assign2;
/*
 * Author's Name: Minh Khang Truong
 * Assigment 1 - CSE360
 * Class ID: 188
 * This file contains the junit test SimpleListTest and the test methods
 * to determine if methods in SimpleList class function correctly.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {
	// Instantiate a new SimpleList called myList
	SimpleList mylist = new SimpleList();
	
	// This test method tests the add() method of the SimpleList
	// Adds 9 to the list then uses assertequals to compare between 9
	// and the first element of the list
	@Test
	void testAdd() 
	{
		mylist.add(9);
		int[] myListArray = mylist.getList();
		assertEquals(9, myListArray[0]);
	}
	
	// This test method tests the remove() method of the SimpleList
	// Adds 6 4 6 and 10 to the list, so the list is 10 6 4 6
	// Removes 6 so now the list is 10 4 6
	// Uses assertequals to compare the first element of the list to 10
	// second element to 4 and last element to 6
	@Test
	void testRemove()
	{
		mylist.add(6);
		mylist.add(4);
		mylist.add(6);
		mylist.add(10);
		// list is now 10 6 4 6
		
		mylist.remove(6);
		// list is now 10 4 6
		int[] myListArray = mylist.getList();
		
		assertEquals(10, myListArray[0]);
		assertEquals(4, myListArray[1]);
		assertEquals(6, myListArray[2]);
	}
	
	// This test method tests the count() method of the SimpleList
	// Adds 4 6 7 10 to the list, so now the list has 4 counts
	// Then removes 7 and 4, so now the list has 2 counts
	// Uses assertequals to compare 2 with the count variable. 
	
	@Test
	void testCount()
	{
		mylist.add(4);
		mylist.add(6);
		mylist.add(7);
		mylist.add(10); // 10 7 6 4
		mylist.remove(7);
		mylist.remove(4);
		// add 4 remove 2 so count is 2
		
		assertEquals(2, mylist.count());
	}
	
	// This test method tests the toString() method of the SimpleList
	// Adds 4 to the list, then uses assertequals to compare str = "4" to the string output
	// Then adds 6 to the list, uses assertequals to compare str = "6 4" to the string output
	// Then adds 7, adds 10 then removes 6
	// uses assertequals to compare str = "10 7 4" to string output
	@Test
	void testString()
	{
		String str;
		mylist.add(4);
		str = "4";
		assertEquals(str, mylist.toString());

		mylist.add(6);
		str = "6 4";
		assertEquals(str, mylist.toString());

		mylist.add(7);
		mylist.add(10);
		mylist.remove(6);
		// list is now 10 7 4
		str = "10 7 4";
		assertEquals(str, mylist.toString());
	}
	
	// This test method tests the Search() method of the SimpleList
	// Add 4, then 6, then 7, then 10 to the list
	// List is now 10 7 6 4, so search for 6 should return 2.  
	// Uses assertequals to compare the search() output with 2
	// Search for 5 returns -1 because 5 is not on the list
	// Uses assertequals to compare the search() output for 5 with -1.
	@Test
	void testSearch()
	{
		mylist.add(4);
		mylist.add(6);
		mylist.add(7);
		mylist.add(10);
		
		assertEquals(2, mylist.search(6));
		assertEquals(-1, mylist.search(5));
	}
	
	// This test method tests the Append() method of the SimpleList
	// Add 4, then 6, then 7, then 10 to the list
	// List is now 10 7 6 4, so append 5 would make the list 10 7 6 4 5  
	// Uses assertequals to compare the last element with 5
	@Test
	void testAppend()
	{
		mylist.add(4);
		mylist.add(6);
		mylist.add(7);
		mylist.add(10);
		mylist.append(5);
		// List is 10 7 6 4 5
		int[] myListArray = mylist.getList();
		assertEquals(5, myListArray[4]);
	}
	
	// This test method add 4 elements to a 10-element array
	// remove 1 so that the size is now 3
	// use assertequals to compare the list size with 3
	@Test
	void testSize()
	{
		mylist.add(4);
		mylist.add(6);
		mylist.add(7);
		mylist.add(10);
		mylist.remove(4);
		assertEquals(3, mylist.size());
	}
	
	// this test method add 4 elements 4 then 6 then 7 then 10 to a 10 element array
	// the first element is 10
	@Test
	void testGetFirstElement()
	{
		mylist.add(4);
		mylist.add(6);
		mylist.add(7);
		mylist.add(10);
		assertEquals(10, mylist.first());
	}
	
}
