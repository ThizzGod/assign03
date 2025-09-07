package assign03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCollectionTester {
	
	ArrayCollection<String> smallCollection; 
	ArrayCollection<Integer> largeCollection;
	
	ArrayCollection<String> smallSubCollection;
	ArrayCollection<Integer> largeSubCollection;
	
	ArrayCollection<String> smallCollectionAppendage;
	ArrayCollection<Integer> largeCollectionAppendage;
	
	@BeforeEach
	void setup() {
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
		for (int i = 0; i <= 150; i++) {
			largeCollection.add(i);
		}
		
		//setup sub collections
		smallSubCollection = new ArrayCollection<String>();
		smallSubCollection.add("Tony");
		smallSubCollection.add("Silvio");
		smallSubCollection.add("Christopher");
		
		largeSubCollection = new ArrayCollection<Integer>();
		for (int i = 50; i <= 100; i++) {
			largeSubCollection.add(i);
		}
		
		//setup collection appendages
		smallCollectionAppendage = new ArrayCollection<String>();
		smallCollectionAppendage.add("Johnny Sack");
		smallCollectionAppendage.add("Janice");
		smallCollectionAppendage.add("Adrianna");
		
		largeCollectionAppendage = new ArrayCollection<Integer>();
		for (int i = 151; i <= 200; i++) {
			largeCollectionAppendage.add(i);
		}
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
		
	}
	
	@Test
	void testContainsElementTrueSamllArray() {
		
	}

	@Test
	void testContainsElementFalseLargeArray() {
		
	}
	
	@Test 
	void testContainsElementFalseSmallArray() {
		
	}
	
	@Test
	void testSmallArrayDouble() {
		
	}
	
	@Test
	void testLargeArrayDouble() {
		
	}
	
	@Test
	void addAllSmallCollection() {
		
	}
	
	@Test
	void addAllLargeCollection() {
		
	}
	
	@Test
	void addAllEmptyCollection() {
		
	}
	
	@Test
	void addAllCollectionContainsDuplicates() {
		
	}
	
	@Test
	void testRemoveStartOfCollection() {
		
	}
	
	@Test
	void testRemoveElementMiddleOfCollection() {
		
	}
	
	@Test
	void testRemoveElementEndOfCollection() {
		
	}
	
	@Test
	void clearSmallColllection() {
		
	}
	
	@Test
	void clearLargeCollection() {
		
	}
	
	@Test
	void testRemoveAllLargeCollection() {
		
	}
	
	@Test
	void testRemoveAllSmallCollection() {
		
	}
	
	@Test
	void testContainsAllTrue() {
		
	}
	
	@Test
	void testContainsAllFalse() {
		
	}
	
	@Test
	void testToSortedList() {
		
	}
	
	@Test
	void testToArrayLargeColletion() {
		
	}
	
	@Test
	void testToArraySmallCollection() {
		
	}
	
	@Test
	void testToArrayEmptyCollection(){

	}
	
	@Test
	void testRetainAllElementsExist() {
		
	}
	
	@Test
	void testRetainAllElementsDoNotExist() {
		
	}
	
	@Test
	void testRetainAllSomeElementsExist() {
		
	}
	
	@Test
	void testRetainAllEmptyCollection() {
		
	}
	
 }
