package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCollectionTester {
	
	ArrayCollection<String> smallCollection; 
	ArrayCollection<Integer> largeCollection;
	ArrayCollection<String> emptyCollection;
	
	ArrayCollection<String> smallSubCollection;
	ArrayCollection<Integer> largeSubCollection;
	
	ArrayCollection<String> smallCollectionAppendage;
	ArrayCollection<Integer> largeCollectionAppendage;
	
	Iterator<String> smallCollectionIterator;
	Iterator<Integer> largeCollectionIterator;
	
	@BeforeEach
	void setup() {
		//setup empty collection
		emptyCollection = new ArrayCollection<String>();
		//setup small collection less than 10 elements
		smallCollection = new ArrayCollection<String>();
		smallCollection.add("Tony");
		smallCollection.add("Junior");
		smallCollection.add("Carmela");
		smallCollection.add("Jennifer");
		smallCollection.add("Silvio");
		smallCollection.add("Paulie");
		smallCollection.add("Chistopher");
		smallCollection.add("Furio");
		
		//setup large collection over 100 elements
		largeCollection = new ArrayCollection<Integer>();
		for (int i = 0; i < 150; i++) {
			largeCollection.add(i);
		}
		
		//setup sub collections
		smallSubCollection = new ArrayCollection<String>();
		smallSubCollection.add("Tony");
		smallSubCollection.add("Silvio");
		smallSubCollection.add("Christopher");
		
		largeSubCollection = new ArrayCollection<Integer>();
		for (int i = 50; i < 100; i++) {
			largeSubCollection.add(i);
		}
		
		//setup collection appendages
		smallCollectionAppendage = new ArrayCollection<String>();
		smallCollectionAppendage.add("Johnny Sack");
		smallCollectionAppendage.add("Janice");
		smallCollectionAppendage.add("Adrianna");
		
		largeCollectionAppendage = new ArrayCollection<Integer>();
		for (int i = 150; i < 200; i++) {
			largeCollectionAppendage.add(i);
		}
		
		//setup iterators
		largeCollectionIterator = largeCollection.iterator();
		smallCollectionIterator = smallCollection.iterator();
	}
	
	@Test
	void testSizeLargeCollection() {
		
	}
	
	@Test
	void testSizeSmallCollection() {
		
	}
	
	@Test
	void testIsEmpty() {
		
	}
	
	@Test
	void testAddElementSmallCollection() {
		
	}
	
	@Test
	void testAddElementLargeCollection() {
		
	}
	
	@Test
	void testIteratorReturnsAnIterator() {
		
	}
	
	@Test
	void testIteratorHasNextEmptyCollection() {
		
	}
	
	@Test
	void testIteratorHasNextTrue() {
		
	}
	
	@Test
	void testIteratorNextReturnsNextElement() {
		
	}
	
	@Test
	void testIteratorNextReturnsFalse() {
		
	}
	
	@Test
	void testIteratorRemoveRemovesLastItemShown() {
		
	}
	
	@Test
	void testIteratorRemoveThrowsNoSuchElementException() {
		
	}
	
	@Test
	void testIteratorRemoveThrowsIllegalStateExceptionWhenUsedTwice() {
		
	}
	
	@Test 
	void testContainsElementTrueLargeArray() {
		assertTrue(largeCollection.contains(5));
	}
	
	@Test
	void testContainsElementTrueSamllArray() {
		assertTrue(smallCollection.contains("Tony"));
	}

	@Test
	void testContainsElementFalseLargeArray() {
		assertFalse(largeCollection.contains(-1));
	}
	
	@Test 
	void testContainsElementFalseSmallArray() {
		assertFalse(smallCollection.contains("AJ"));
	}
	
	@Test
	void addAllSmallCollection() {
		assertTrue(smallCollection.addAll(smallCollectionAppendage));
		assertEquals(11, smallCollection.size());
	}
	
	@Test
	void addAllLargeCollection() {
		assertTrue(largeCollection.addAll(largeCollectionAppendage));
		assertEquals(200, largeCollection.size());
	}
	
	@Test
	void addAllEmptyCollection() {
		assertFalse(smallCollection.addAll(emptyCollection));
	}
	
	@Test
	void addAllCollectionContainsDuplicates() {
		smallSubCollection.add("Meadow");
		assertTrue(smallCollection.addAll(smallSubCollection));
		assertTrue(smallCollection.contains("Meadow"));
		assertEquals(9, smallCollection.size());
	}
	
	@Test
	void testRemoveStartOfCollection() {
		assertTrue(largeCollection.remove(0));
		assertFalse(largeCollection.contains(0));
		assertEquals(149, largeCollection.size());
			
	}
	
	@Test
	void testRemoveElementMiddleOfCollection() {
		assertTrue(largeCollection.remove(75));
		assertFalse(largeCollection.contains(75));
		assertEquals(149, largeCollection.size());
		
	}
	
	@Test
	void testRemoveElementEndOfCollection() {
		assertTrue(largeCollection.remove(149));
		assertFalse(largeCollection.contains(149));
		assertEquals(149, largeCollection.size());
		
	}
	
	@Test 
	void testRemoveElementNotInCollection() {
		assertFalse(smallCollection.remove("Artie"));
		assertEquals(8, smallCollection.size());
	}
	
	@Test
	void clearSmallColllection() {
		smallCollection.clear();
		assertEquals(0, smallCollection.size());
	}
	
	@Test
	void clearLargeCollection() {
		largeCollection.clear();
		assertEquals(0, largeCollection.size());
	}
	
	@Test
	void testRemoveAllLargeCollection() {
		assertTrue(largeCollection.removeAll(largeSubCollection));
		assertEquals(100, largeCollection.size());
	}
	
	@Test
	void testRemoveAllSmallCollection() {
		assertTrue(smallCollection.removeAll(smallSubCollection));
		assertEquals(5, smallCollection.size());
	}
	
	@Test
	void testRemoveAllNoItemsRemoved() {
		assertFalse(smallCollection.removeAll(smallCollectionAppendage));
		assertEquals(8, smallCollection.size());
	}
	
	@Test
	void testRemoveAllSomeItemsRemoved() {
		smallSubCollection.add("Jackie Jr");
		assertTrue(smallCollection.removeAll(smallSubCollection));
		assertEquals(5, smallCollection.size());
		assertFalse(smallCollection.contains("Jackie Jr"));
	}
	
	@Test
	void testContainsAllTrue() {
		assertTrue(smallCollection.containsAll(smallSubCollection));
	}
	
	@Test
	void testContainsAllFalse() {
		assertFalse(largeCollection.containsAll(largeCollectionAppendage));
	}
	
	@Test
	void testToSortedList() {
		ArrayList<String> sortedComparison = new ArrayList<String>();
		sortedComparison.add("Carmela");
		sortedComparison.add("Chistopher");
		sortedComparison.add("Furio");
		sortedComparison.add("Jennifer");
		sortedComparison.add("Junior");
		sortedComparison.add("Paulie");
		sortedComparison.add("Silvio");
		sortedComparison.add("Tony");
		ArrayList<String> sortedList = smallCollection.toSortedList((s1, s2) -> s1.compareTo(s2));
		assertEquals(sortedComparison, sortedList);
	}
	
	@Test
	void testToArrayArrayTypeIsObject() {
		Object[] objArray = smallCollection.toArray();
		assertNotEquals(String.class, objArray.getClass().getComponentType());
		assertEquals(Object.class, objArray.getClass().getComponentType());
	}
	
	@Test
	void testToArrayLargeCollection() {
		Object[] largeArray = largeCollection.toArray();
		assertEquals(largeArray.length, largeCollection.size());
		assertEquals(largeCollectionIterator.next(), (Integer) largeArray[0]);
	}
	
	@Test
	void testToArraySmallCollection() {
		Object[] smallArray = smallCollection.toArray();
		assertEquals(smallArray.length, smallCollection.size());
		assertEquals(smallCollectionIterator.next(), (Integer) smallArray[0]);
		
	}
	
	@Test
	void testToArrayEmptyCollection(){
		Object[] emptyArray = emptyCollection.toArray();
		assertEquals(emptyArray.length, emptyCollection.size());
		
	}
	
	@Test
	void testRetainAllElementsExist() {
		assertFalse(largeCollection.retainAll(largeCollection));
		assertEquals(150, largeCollection.size());
	}
	
	@Test
	void testRetainAllElementsDoNotExist() {
		assertTrue(smallCollection.retainAll(smallCollectionAppendage));
		assertEquals(0, smallCollection.size());
	}
	
	@Test
	void testRetainAllSomeElementsExist() {
		smallSubCollection.add("Jackie Jr");
		assertTrue(smallCollection.retainAll(smallSubCollection));
		assertEquals(3, smallCollection.size());
		assertFalse(smallCollection.contains("Jackie Jr"));
	}
	
	@Test
	void testRetainAllEmptyCollection() {
		assertTrue(smallCollection.retainAll(emptyCollection));
		assertEquals(0, smallCollection.size());
	}
	
 }
