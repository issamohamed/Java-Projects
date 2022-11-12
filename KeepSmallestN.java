// Completed Issa Mohamed and Brandon Szeto
import java.util.Scanner;

public class KeepSmallestN {

	public static void main(String[] args) {

      // nToKeep is what the assignment description calls N.
		// DO NOT DELETE THIS NEXT LINE!!!
		int nToKeep = Integer.parseInt(args[0]);
		
		
		// Create a min or max priority queue.  You'll need
		// to figure out which.
		HeapMaxPQ heap_max =  new HeapMaxPQ(nToKeep) ;

		
		// Create a scanner object reading from System.in.
		Scanner sc = new Scanner(System.in);
		// For each integer read from the input...
		//    ...figure out how to use a priority queue to
		//    keep the nToKeep smallest ones.
		while (sc.hasNext()) {
			String input = sc.next();
			// first condition: if the queue has < than N elements, add it.
			if (heap_max.size() < nToKeep) {
				int int_value = Integer.parseInt(input);
				heap_max.insert(int_value);
			}
			// second condition: if the queue size is filled, compare the max element 
			// in the queue to the input which if its smaller, remove the max element from the queue.
			else {
				int int_value = Integer.parseInt(input);
				if (heap_max.max().compareTo(int_value) > 0) {
					heap_max.delMax() ;
					heap_max.insert(int_value);
				}
				// get the max element from our heapmax 
				// compare max element to the input value
				// if input value < max element, remove max element from the heap
				//  and add the input to the heap
			}
		}
		
		// Write out the final nToKeep smallest items
		// to System.out, one per line.
		while (heap_max.isEmpty() == false) {
			System.out.println(heap_max.delMax()) ;
		}
	}
}
