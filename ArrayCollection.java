package assign03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Daniel Kopta and Josi Gac and Max Barker
 * Implements the Collection interface using an array as storage.
 * The array must grow as needed.
 * An ArrayCollection can not contain duplicates.
 * All methods should be implemented as defined by the Java API, unless otherwise specified.
 * 
 * It is your job to fill in the missing implementations and to comment this class. 
 * Every method should have comments (Javadoc-style prefered). 
 * The comments should at least indicate what the method does, 
 * what the arguments mean, and what the returned value is. 
 * It should specify any special cases that the method
 * handles. Any code that is not self-explanatory should be commented.
 *
 * @param <T> - generic type placeholder
 */
public class ArrayCollection<T> implements Collection<T> {

	private T data[]; // Storage for the items in the collection
	private int size; // Keep track of how many items this collection holds

	// There is no clean way to convert between T and Object, so we suppress the warning.
	@SuppressWarnings("unchecked")  
	public ArrayCollection()
	{
		size = 0;
		// We can't instantiate an array of unknown type T, so we must create an Object array, and typecast
		data = (T[]) new Object[10]; // Start with an initial capacity of 10
	}

	/**
	 * This is a helper method specific to ArrayCollection
	 * Doubles the size of the data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow()
	{
		T newData[] = (T[]) new Object[size*2];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * Adds the specified item to this collection if it's not already there
	 * It will return a boolean based on if it's present or not
	 * 
	 * @param arg0 the item to be added
	 * @return returns true if it was added and false if it wasn't
	 */
	public boolean add(T arg0) {
		if (!this.contains(arg0)) {
			data[size] = arg0;
			size++;
			if (size == data.length) {
				this.grow();
			}
			return true;
		}
		return false;
	}

	/**
	 * Adds all items from the specified collection into this collection without any duplicates
	 * 
	 * @param arg0 the collection of items to be added
	 * @return returns true if at;east one item was added or false if none were added
	 */
	public boolean addAll(Collection<? extends T> arg0) {
		int previousSize = size;
		for (T element : arg0) {
			if (!this.contains(element)) {
				this.add(element);
			}
		}
		if (size > previousSize) {
			return true;
		}
		return false;
	}

	/**
	 * Removes all the items from the collection by setting the size to zero
	 */
	public void clear() {
		
		 size = 0;
	}

	/**
	 * Determines whether the collection contains the specific object
	 * 
	 * @param arg0 the object to check if the collection contains
	 * @return true if the collection has it, false if it doesn't
	 */
	public boolean contains(Object arg0) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	/**
     * Determines whether this collection contains all items from the specified collection
     *
     * @param arg0 the collection to check against
     * @return true if all items in arg0 are contained in this collection, false if not
	 */
	public boolean containsAll(Collection<?> arg0) {
		for (Object element : arg0) {
			if (!this.contains(element)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the collection is empty
	 * 
	 * @return returns true if its empty or false if it's not
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

    /**
     * Returns an iterator over the items in this collection
     *
     * @return returns a new iterator for this collection
     */
	public Iterator<T> iterator() {
		return new ArrayCollectionIterator();
	}

    /**
     * Removes the specified object from this collection or if the
     * object is not in this collection the method returns false
     *
     * @param arg0 the object to be removed
     * @return returns true if the object was removed, false if it wasn't
     */
	public boolean remove(Object arg0) {
		if (!this.contains(arg0)) {
			return false;
		}
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(arg0)) {
				iterator.remove();
			}
		}
		return true;
	}

	/**
	 * Removes all items from this collection that are in the specified collection
	 * 
	 * @param arg0 the collection containing items to be removed
	 * @return returns true if an item was removed, false if one wasn't
	 */
	public boolean removeAll(Collection<?> arg0) {
		int previousSize = size;
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			if (arg0.contains(iterator.next())) {
				iterator.remove();
			}
		}
		if (size < previousSize) {
			return true;
		}
		return false;
	}

	/**
	 * Retains only the items in this collection that are also in the specified collection
	 * 
	 * @param arg0 the collection containing items to retain
	 * @return returns true if any items were removed, false if not
	 */
	public boolean retainAll(Collection<?> arg0) {
		int previousSize = size;
		Iterator<T> iterator = this.iterator();		
		while (iterator.hasNext()) {
			if (!arg0.contains(iterator.next())) {
				iterator.remove();
			}
		}
		if (this.size < previousSize) {
			return true;
		}
		return false;
	}

	/**
	 * A getter for the size of the array
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns an new array of type Object containing the elements
	 * of this collection.
	 */
	public Object[] toArray() {
		Object[] objectArray = new Object[size];
		for (int i = 0; i < size; i++) {
			objectArray[i] = data[i];
		}
		return objectArray;
	}

	/* 
	 * Don't implement this method (unless you want to).
	 * It must be here to complete the Collection interface.
	 * We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {
		return null;
	}



	/*
     
	*/
	/**
	 * Sorting method specific to ArrayCollection - not part of the Collection interface.
     	Must implement a selection sort (see Assignment 2 for code).
     	Must not modify this ArrayCollection.
	 * @param cmp - the comparator that defines item ordering
	 * @return - the sorted list
	 */
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		ArrayList<T> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(data[i]);
		}
		for(int i = 0; i < this.size() - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < this.size(); j++)
				if(cmp.compare(list.get(j), list.get(minIndex)) < 0)
					minIndex = j;
			T temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
		return list;
	}


	/**
	 * @author Josi Gac and Max Barker
	 * This private Iterator class iterates over and returns the private
	 * instance variables of an ArrayCollection object. Calling the iterator
	 * method of an ArrayCollection object will return an ArrayCollectionIterator object.
	 * Use this generated object in order to access the elements of an ArrayCollection.
	 */
	private class ArrayCollectionIterator implements Iterator<T>
	{
		int cursor;
		int removeCallsConsecutive;
		public ArrayCollectionIterator()
		{
			cursor = 0; //tracks where the next item of the collection will be
			removeCallsConsecutive = 0; //tracks how many times in a row remove() has been called
		}

		/**
		 * Returns true if there is another item in the collection after
		 * the current cursor position. Otherwise returns false. 
		 * Use this method to NoSuchElementException exceptions when
		 * using the next method of this iterator.
		 * 
		 * @return - true if another item exists, otherwise false
		 */
		public boolean hasNext() {
			if (cursor + 1 > size) {
				return false;
			}
			return true;
		}

		/**
		 * Call this method to return the item under the cursor and move
		 * the cursor forward to the next element of the collection.
		 * 
		 * @return - an object of the type contained in the ArrayCollection
		 * which created this Iterator.
		 */
		public T next() {
				if (cursor == size) {
					throw new NoSuchElementException();
				}
				T returnValue = data[cursor];
				cursor++;
				if (removeCallsConsecutive == 1) {
					removeCallsConsecutive--;
				}
				return returnValue;
		}

		/**
		 * Removes the last item returned by the "next" method of this Iterator from
		 * the ArrayCollection which created this Iterator.
		 * 
		 * NOTE: you cannot call this method twice in a row or before at least 
		 * one call to "next".
		 * 
		 * @throws IllegalStateException - when used twice in a row or before
		 * at least one call to "next".
		 */
		public void remove() {
			if (cursor == 0) {
				throw new IllegalStateException();
			}
			if (removeCallsConsecutive >= 1) {
				throw new IllegalStateException();
			}
			for (int i = cursor - 1; i < size; i++) {
				data[i] = data[i + 1];
			}
			removeCallsConsecutive++;
			size--;
			cursor--;
		}

	}

}