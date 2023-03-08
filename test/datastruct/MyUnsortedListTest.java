package datastruct;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class MyUnsortedListTest {

	/*	List is empty and size equal 0 */
	@Test
	public void empty() {
		UnsortedList<Integer> list_empty = MyUnsortedList.of();
		assertEquals("new empty list size", 0, list_empty.size());
		assertTrue("new empty list is not empty", list_empty.isEmpty());
	}
	
	/*	List is no empty and size not equal 0 */
	@Test
	public void notEmpty() {
		UnsortedList<Integer> list_no_empty = MyUnsortedList.of(1,2,3);
		assertEquals("new list size", 3, list_no_empty.size());
		assertFalse("new list is empty", list_no_empty.isEmpty());
	}
	
	/*					*
	 *					*
	 * 		POP 		*
	 * 					*
	 *					*/
	
	@Test
	public void popFirst() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list2 = MyUnsortedList.of(2,3,4,5);
		
		int val = list1.pop();
		assertEquals("removing first element", list2, list1);
		assertEquals("first element", 1, val);
	}
	
	@Test
	public void popFirstOneElement() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1);
		UnsortedList<Integer> list2 = MyUnsortedList.of();
		
		int val = list1.pop();

		assertEquals("removing first element", list2, list1);
		assertEquals("first element", 1, val);
	}
	
	@Test
	public void popLast() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4);
		
		int val = list1.popLast();
		assertEquals("removing last element", list2, list1);
		assertEquals("last element", 5, val);
	}
	
	@Test
	public void popLastOneElement() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1);
		UnsortedList<Integer> list2 = MyUnsortedList.of();
		int val = list1.popLast();

		assertEquals("removing last element", list2, list1);
		assertEquals("last element", 1, val);
	}
	
	@Test(expected = EmptyListException.class)
	public void popFirstEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.pop();
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.popLast();
	}
	
	/*					*
	 * 	   PREPEND 		*
	 * 	   APPEND 		*
	 * 	   EMPTY		*
	 *					*/
	
	@Test
	public void prependFromEmpty() {
		UnsortedList<Integer> list1 = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of(1);
		
		list1.prepend(1);
		
		assertEquals("adding 1", list2, list1);
	}
	
	@Test
	public void appendFromEmpty() {
		UnsortedList<Integer> list1 = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of(1);
		
		list1.append(1);
		
		assertEquals("adding 1", list2, list1);
	}
	
	/*					*
	 * 	   PREPEND 		*
	 * 	   APPEND 		*
	 * 	   NO EMPTY		*
	 *					*/
	
	@Test
	public void prepend() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3);
		UnsortedList<Integer> list2 = MyUnsortedList.of(0,1,2,3);
		
		list1.prepend(0);
		
		assertEquals("adding 0", list2, list1);
	}
	
	@Test
	public void append() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4);
		
		list1.append(4);
		assertEquals("adding 4", list2, list1);
	}
	
	/*					*
	 * 	   		 		*
	 * 	   INSERT 		*
	 * 	 				*
	 *					*/
	
	@Test
	public void insertEmpty() {
		UnsortedList<Integer> list1 = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of(1);
		
		list1.insert(1,0);
		
		assertEquals("adding 1", list2, list1);
	}
	
	@Test
	public void insertLast() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4);
		
		list1.insert(4,list1.size());
		
		assertEquals("adding 4", list2, list1);
	}
	
	@Test
	public void insertFirst() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3);
		UnsortedList<Integer> list2 = MyUnsortedList.of(0,1,2,3);
		
		list1.insert(0,0);
		
		assertEquals("adding 0", list2, list1);
	}
	
	@Test
	public void insertMiddle() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,4,5);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4,5);
		
		list1.insert(3,2);
		
		assertEquals("adding 3", list2, list1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertOutOfBound() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,4,5);
		list1.insert(3,list1.size()+1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertOutOfBoundNegatif() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,4,5);
		list1.insert(3,-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertOutOfBoundEmpty() {
		UnsortedList<Integer> list1 = MyUnsortedList.of();
		list1.insert(3,1);
	}
	
	/*					*
	 * 	   		 		*
	 * 	   REMOVE 		*
	 * 	 				*
	 *					*/
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeOutOfBound() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,4,5);
		list1.remove(list1.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeOutOfBoundNegatif() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,4,5);
		list1.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeOutOfBoundEmpty() {
		UnsortedList<Integer> list1 = MyUnsortedList.of();
		list1.remove(1);
	}
	
	@Test
	public void removeLast() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3);
		
		int val = list1.remove(list1.size()-1);
		
		assertEquals("removing 4", list2, list1);
		assertEquals("last element", 4, val);
	}
	
	@Test
	public void removeFirst() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(0,1,2,3);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3);
		
		int val = list1.remove(0);
		
		assertEquals("removing 0", list2, list1);
		assertEquals("First element", 0, val);
	}
	
	@Test
	public void removeMiddle() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,4,5);
		
		int val = list1.remove(2);
		
		assertEquals("removing 3", list2, list1);
		assertEquals("element", 3, val);
	}
	
	/*					*
	 * 	   		 		*
	 * 	   EQUAL 		*
	 * 	 				*
	 *					*/
	
	@Test
	public void equalEmpty() {
		UnsortedList<Integer> list1 = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of();
		
		assertTrue("not equal", list1.equals(list2));
	}
	
	@Test
	public void equalNotEmpty() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4,5);
		
		assertTrue("not equal", list1.equals(list2));
	}
	
	/*					*
	 * 	   		 		*
	 * 	   STRING 		*
	 * 	 				*
	 *					*/
	
	@Test
	public void toStringEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals("not equal", "MyUnsortedList { size = 0, [] }", list.toString());
	}
	
	@Test
	public void toStringNotEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		
		assertEquals("not equal", "MyUnsortedList { size = 5, [1, 2, 3, 4, 5] }",list.toString());
	}
	
	/*					*
	 * 	    EQUAL 		*
	 * 	  COMPLEXE 		*
	 * 	 	TYPE		*
	 *					*/
	
	@Test
	public void equalBigIntegerEmpty() {
		UnsortedList<BigInteger> list1 = MyUnsortedList.of();
		UnsortedList<BigInteger> list2 = MyUnsortedList.of();
		
		assertTrue("not equal", list1.equals(list2));
	}
	
	@Test
	public void equalBigIntegerNotEmpty() {
		UnsortedList<BigInteger> list1 = MyUnsortedList.of(new BigInteger("1"),new BigInteger("2"),new BigInteger("3"),new BigInteger("4"),new BigInteger("5"));
		UnsortedList<BigInteger> list2 = MyUnsortedList.of(new BigInteger("1"),new BigInteger("2"),new BigInteger("3"),new BigInteger("4"),new BigInteger("5"));
		
		assertTrue("not equal", list1.equals(list2));
	}
	
	@Test
	public void noEqualType() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<String> list2 = MyUnsortedList.of("abcd");
		
		assertFalse("equal", list1.equals(list2));
	}
}
