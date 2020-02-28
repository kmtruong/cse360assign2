package cse360assign2;
/*
 * Author's Name: Minh Khang Truong
 * Assigment 1 - CSE360
 * Class ID: 188
 * This file contains the class SimpleList and the methods to manipulate an integer array
 * The only purpose of the file is to be tested by the junit test
 */

/**
 * Contains the methods to manipulate an array of ten elements
 * such as add, remove, search, display to string and count
 * 
 * This class methods are to be tested by a junit test therefore
 * it is public.  This class has no other purpose.
 * 
 */
public class SimpleList
{
	private int[] list;
	private int count;
	private int size;
	
	/**
	 * Does not return or accept any variable
	 * 
	 * This method is a constructor that will create an integer array with
	 * ten elements and an integer that counts the number of elements.
	 * Initially, array is empty and count is 0. 
	 *
	 * @param  none
	 * @return none
	 */
	public SimpleList()
	{
		this.size = 10;
		this.list = new int[size];
		this.count = 0;
	}
	
	/**
	 * Accepts an integer and add the integer to the initialized int array
	 * as the last element.  
	 * If the list is full when add, increase the size of the list by 50%.
	 * 
	 * This method creates a new list placeholder and copies all elements except the last one
	 * of the list onto the placeholder using a for loop, but each element has its index 
	 * increased by 1 when copied over.  First element is empty.  Integer accepted is added 
	 * to first index of placeholder.  Then list is assigned as placeholder and count of elements
	 * is incremented 
	 *
	 * @param  integer to add to list
	 * @return none
	 */
	public void add (int numbToAdd)
	{
		int newsize = 0;
		
		if (this.count == size)
			newsize = this.size + this.size/2;
		else
			newsize = this.size;
		
		int[] newList = new int[newsize];
		
		for (int index = 0; index < this.count; index++)
			newList[index + 1] = this.list[index];
		newList[0] = numbToAdd;
		
		this.list = newList;		
		this.count++;
		this.size = newsize;
	}
	
	/**
	 * Accepts an integer and tries to remove the integer from the array
	 * Increments all elements after the removed element by one.
	 * 
	 * This method compares the integer parameter with each element in the array using a while loop
	 * If there is an element equal then remembers its index, if not output so. Only the first matched 
	 * result is stored.
	 * 
	 * Then creates a new list placeholder and copies all elements from start to the remembered index
	 * (not including the index element). Then copies all elements after the index from the array to 
	 * the placeholder with every index decrement by 1.  
	 * Then, assigns the placeholder to the int array.
	 * Decrements the count.
	 *
	 * @param  integer to remove list
	 * @return none
	 * @see		No number in list if number to be removed can't be found
	 */
	public void remove(int numToRemove)
	{
		int indexToRemove = search(numToRemove);
		
		if (indexToRemove == -1)
			System.out.println("No such number in list");
		else
		{
			this.count--;
			int emptySpaceNum = this.size - this.count;
			if (emptySpaceNum*100/this.size > 25)
				this.size = this.count;
			
			int[] newList = new int[this.count];
			if (indexToRemove == this.count)
			{
				for (int indexLoop2 = 0; indexLoop2 < this.count; indexLoop2++)
					newList[indexLoop2] = this.list[indexLoop2];
			}
			else
			{
				for (int indexLoop2 = 0; indexLoop2 < indexToRemove; indexLoop2++)
					newList[indexLoop2] = this.list[indexLoop2];
				for (int indexLoop2 = indexToRemove + 1; indexLoop2 < this.count + 1; indexLoop2++)
					newList[indexLoop2 - 1] = this.list[indexLoop2];
			}
			
			this.list = newList;
		}
		
	}
	
	/**
	 * Does not accept parameters and returns an integer that is the count of elements in array
	 * 
	 * @param  none
	 * @return integer count
	 */
	public int count()
	{
		return this.count;
	}
	
	/**
	 * Does not accept parameter and returns all the elements in the array as a string
	 * with space in between.
	 * 
	 * This method checks if there is any element in the array, if not display list is empty and
	 * returns void
	 * If there is only 1 element, cast the integer to String and assign to str
	 * If there is more than 1 element, cast the first element to String and assign to str
	 * then loop through the array concatenating a space and the next element and assign to str
	 * Returns str
	 *
	 * @param  none
	 * @return String str
	 * @see		List is empty if array is empty
	 */
	public String toString()
	{
		String str;
		if (this.count == 0)
		{
			System.out.println("List is empty");
			str = "";
		}
		else if (this.count == 1)
			str = String.valueOf(this.list[0]);
		else
		{
			str = String.valueOf(this.list[0]);
			for (int indexLoop = 1; indexLoop < count; indexLoop++)
				str = str + " " + String.valueOf(this.list[indexLoop]);
		}
		return str;
	}
	
	/**
	 * Accepts an integer to search for in the array and returns the index of matched elements.
	 * If there is no matched element, returns a -1
	 * 
	 * This method loops through the integer array and perform equal condition check between the 
	 * taken in parameter and each element in the array.  If matched, returns the index of such element
	 *
	 * @param  integer number to search for
	 * @return integer index of number found or -1 if not found
	 * @see		none
	 */
	public int search(int numToSearch)
	{
		int indexToSearch = -1;
		for (int indexLoop = 0; indexLoop < this.count; indexLoop++)
		{
			if (list[indexLoop] == numToSearch)
			{
				indexToSearch = indexLoop;
				indexLoop = this.count;
			}
		}
		return indexToSearch;
	}
	
	/**
	 * Does not accept parameters.  Returns an integer array.
	 * 
	 * This getter method retrieves the list integer array since the array is private.
	 * This extra method is provided to help the junit test.
	 *
	 * @param  none
	 * @return integer array of list of number
	 * @see		none
	 */
	public int[] getList()
	{
		return this.list;
	}
	
	/**
	 * Accepts an integer and add the integer to the initialized int array
	 * as the last element.
	 * If array is full when append, increase the size of the list by 50%, then append.
	 * 
	 * This method creates a new list placeholder and copies all elements 
	 * of the list onto the placeholder using a for loop.  Integer accepted is appended
	 * to last index of placeholder.  Then list is assigned as placeholder and count of elements
	 * is incremented. The list size is also adjusted to new size 
	 *
	 * @param  integer to add to list
	 * @return none
	 */
	public void append(int numToAppend)
	{
		int newsize = 0;
		
		if (this.count == size)
			newsize = this.size + this.size/2;
		else
			newsize = this.size;
		
		int[] newList = new int[newsize];
		
		for (int index = 0; index < this.count; index++)
			newList[index] = this.list[index];
		newList[this.count] = numToAppend;
		
		this.list = newList;		
		this.count++;
		this.size = newsize;
	}

	/**
	 * Does not accept parameters and returns an integer that is the first element of integer array
	 * 
	 * @param  none
	 * @return integer first element of array
	 */
	public int first()
	{
		return this.list[0];
	}
	
	/**
	 * Does not accept parameters and returns an integer that is the size of array
	 * 
	 * @param  none
	 * @return integer size
	 */
	public int size()
	{
		return this.size;
	}
	
	
}