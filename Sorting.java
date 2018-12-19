package testing;

import java.util.ArrayList;
import java.util.List;

public class Sorting implements Comparable{

	public static void insertionSort(List<? extends Comparable> myIntegers)  {		
		List<Object> newList = new ArrayList<Object>();		
		int counter = 0;
		while(counter < myIntegers.size()) {
			newList.add(myIntegers.get(counter));
			counter++;
		}		
		for( int index = 1;index < newList.size();index++) {
			Comparable temp = (Comparable) newList.get(index);
			int j = index;
			while(j > 0 && (greaterThan(temp, (newList.get(j - 1)))<0)) {
				newList.set(j, newList.get(j-1));
				j--;
			}
			newList.set(j,temp);
		}				
		//printLists(newList);
	}

	public static void bubbleSort(List<? extends Comparable> myIntegers) {
		
		List<Object> newList = new ArrayList<Object>();	
		
		int sizer = 0;
		while(sizer < myIntegers.size()) {
			newList.add(myIntegers.get(sizer));
			sizer++;
		}
		for( int index = 1; index < newList.size(); index++) {
			for(int counter = 0; counter < newList.size() -1; counter++)
			{
				Comparable temp = (Comparable) newList.get(counter);
				if(greaterThan(temp, newList.get(counter + 1))>0) {
					Object S1 = newList.get(counter);
					newList.set(counter, newList.get(counter+1));
					newList.set(counter + 1, S1);
				}
			}
		}
		//printLists(newList);
	}
	
	public static void selectionSort(List<?extends Comparable> myIntegers) {
		
		List<Object> newList = new ArrayList<Object>();	
		
		int counter = 0;
		while(counter < myIntegers.size()) {
			newList.add(myIntegers.get(counter));
			counter++;
		}
		
		for(int index = 0; index < newList.size(); index++) {
			int min = index;
			for( int j = index + 1; j < newList.size(); j++) {
				Comparable temp = (Comparable)newList.get(j);
				if(greaterThan(temp, newList.get(min))<0) {
					min = j;
				}
			}
			Object S1 = newList.get(index);
			newList.set(index, newList.get(min));
			newList.set(min, S1);
		}
		//printLists(newList);
		
	}
	
	public static void quickSort(List<? extends Comparable> myIntegers) {
		List<Object> newList = new ArrayList<Object>();	
		
		int counter = 0;
		while(counter < myIntegers.size()) {
			newList.add(myIntegers.get(counter));
			counter++;
		}		
		quickSort(newList, 0, newList.size()-1);
		//printLists(newList);
	}
	
	public static void mergeSort(List<? extends Comparable> myIntegers) {
		
		List<Object> newList = new ArrayList<Object>();
		
		int counter = 0;
		while(counter < myIntegers.size()) {
			newList.add(myIntegers.get(counter));
			counter++;
		}
		mergeSortStarter(newList);		
		//printLists(newList);
		
	}
	
	public static void countingSort(List<? extends Integer> myIntegers) {
		List<Integer> newList = new ArrayList<Integer>();
		
		int counter = 0;
		int biggest = 0;
		while(counter < myIntegers.size()) {
			newList.add(myIntegers.get(counter));
			if(myIntegers.get(counter) > biggest) {
				biggest = myIntegers.get(counter);
			}
			counter++;
		}
		
		newList = coutingSort(newList, biggest);
		
		//printList(newList);
		
	}
	
	public static void radixSort(List<? extends Integer> myIntegers) {
		
		List<Integer> newList = new ArrayList<Integer>();		
		int counter = 0;
		while(counter < myIntegers.size()) {
			newList.add(myIntegers.get(counter));
			counter++;
		}
		
		List<Integer>[] buckets = new ArrayList[myIntegers.size()];
		for( int index = 0; index < newList.size();index++) {
			buckets[index] = new ArrayList<Integer>();
		}
		
		int divisor = 1;
		for( int index = 1; index < 4; index++) {
			for( int count = 0; count < newList.size(); count++) {
				int key = newList.get(count)/divisor;
				buckets[key%10].add(newList.get(count));
			}
			
			int k = 0;
			
			for( int count = 0; count < buckets.length; count++) {
				for( int x : buckets[count]) {
					newList.set(k++, x);					
				}
				buckets[count].clear();
			}
			
			divisor*=10;
		}
	}
		
	private static List<Integer> coutingSort(List<Integer> newList, int k) {
		List<Integer> result = new ArrayList<Integer>(newList.size());
		List<Integer> counts = new ArrayList<Integer>(k);
		
		
		for( int i = 0; i <= k; i++) {
			counts.add(0);
		}
		
		for( int i = 0; i < newList.size(); i++) {
			result.add(0);
		}
				
		
		for( int i = 0; i < newList.size(); i++) {
			int x = counts.get(newList.get(i));
			counts.set(newList.get(i), x + 1);
		}
		
		for( int i = 1; i <= k; i++) {
			counts.set(i, counts.get(i)+ counts.get(i-1));
		}
		
		for( int i = newList.size()-1; i >= 0; i--) {
			int x = counts.get(newList.get(i));
			result.set(x-1, newList.get(i));
			counts.set(newList.get(i), x-1);
		}
		
		return result;
		
	}
			
	private static void mergeSortStarter(List<Object> newList) {
		if(newList.size() > 1) {
			int mid = (newList.size())/2;
			
			List<Object> leftList = new ArrayList<Object>();
			List<Object> rightList = new ArrayList<Object>();
			
			for (int i=0; i<mid; i++) {
	            leftList.add(newList.get(i));
			}
			for (int i=mid; i<newList.size(); i++) {
	            rightList.add(newList.get(i));
			}
			mergeSortStarter(leftList);			
			mergeSortStarter(rightList);			
			merge(leftList, rightList, newList);
		}	
		
		
	}	
	
	private static void merge(List<Object> leftSide, List<Object> rightSide, List<Object> myIntegers) {
		int i = 0; int j = 0; int k = 0;
		
		while( i < leftSide.size() && j < rightSide.size()) {
			Comparable temp = (Comparable)leftSide.get(i);
			if(greaterThan(temp,rightSide.get(j))<0) {
				myIntegers.set(k, leftSide.get(i));
				i++;
			} else {
				myIntegers.set(k, rightSide.get(j));
				j++;
			}
			k++;				
		}
		
		while( i < leftSide.size()) {
			myIntegers.set(k, leftSide.get(i));
			i++;
			k++;
		}
		
		while( j < rightSide.size()) {
			myIntegers.set(k, rightSide.get(j));
			j++;
			k++;
		}		
	}
	
	private static void quickSort(List<Object> newList, int low, int high) {
		if(low < high) {
			System.out.println(newList.toString());
			int p = partition(newList, low, high);
			quickSort(newList, low, p-1);
			quickSort(newList, p+1, high);
		}		
	}
	
	private static int partition(List<Object> newList, int low, int high) {
		Object pivot = newList.get(high);
		int i = low - 1;
		
		for( int j = low; j < high; j++) {
			Comparable temp = (Comparable) newList.get(j);
			if( greaterThan(temp,pivot) <=0) {
				i = i + 1;
				Object S1 = newList.get(i);
				newList.set(i, newList.get(j));
				newList.set(j, S1);
			}
		}
		Object S1 = newList.get(i+1);
		newList.set(i+1, newList.get(high));
		newList.set(high, S1);
		return i + 1;
	}
		
	private static int greaterThan(Comparable left, Object right) {
		return left.compareTo(right);
	}
   
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void printLists(List<Object> newList) {
		for(int index = 0; index < newList.size();index++) {
			System.out.println(newList.get(index));
		}
	}
	
	public static void printList(List<Integer> newList) {
		for(int index = 0; index < newList.size();index++) {
			System.out.println(newList.get(index));
		}
	}

}