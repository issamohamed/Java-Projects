
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

public class QueryIndex {

	private static HashMap<String, String> readExcludeList(String fileName) throws FileNotFoundException {

		HashMap<String, String> excludeList = new HashMap<String, String>();

		Scanner excludeFile = new Scanner(new FileInputStream(fileName));
		while (excludeFile.hasNext()) {
			String s = excludeFile.next();
			/* add to the exclusion list */
			excludeList.put(s, "true");
		}
		
		excludeFile.close();
		return excludeList;
	}

	private static HashMap<String, HashSet<Integer>> createIndex(String fileName, HashMap<String, String> excludeList) throws FileNotFoundException {

		HashMap<String, HashSet<Integer>> st = new HashMap<String, HashSet<Integer>>();
		
		Scanner text = new Scanner(new FileInputStream(fileName));

		Integer page = 1;
		while (text.hasNext()) {

			String word = text.next();
			// if the word is "-----", increment the page count
			if (word.equals("-----")) {
				page = page + 1 ;
			}
			else {
				if (excludeList.get(word) != "true") {
					if(st.containsKey(word) == false) {
						HashSet<Integer> valueSet = new HashSet<Integer>() ;
						valueSet.add(page) ;
						st.put(word, valueSet) ;

					}
					else if(st.containsKey(word) == true) {
							HashSet<Integer> tempSet = st.get(word) ;
							tempSet.add(page) ;
							st.put(word, tempSet) ;
					}

				}
			}
			
			// if the word is in the exclude list, ignore it
			// if the word not in the symbol table, create a new entry for it
			// if the word is in the symbol table, add this page to its list of pages
		}
		
		text.close();
		
		return st;
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scnr = new Scanner(System.in);

		HashMap<String, String> excludeList = readExcludeList("exclude.txt");
		
		HashMap<String, HashSet<Integer>> st = createIndex("paginatedtale.txt", excludeList);

		while (scnr.hasNext()) {
			String word = scnr.next();
			if(excludeList.get(word) == "true") {
				System.out.println(word + ": Excluded from search." ) ;
			}
			else if( st.containsKey(word) == false) {
				System.out.println(word + ": Not in text.") ;
			}
			else if (st.containsKey(word) == true) {
				List<Integer> arr = new ArrayList<>(st.get(word));
				Collections.sort(arr); 
				System.out.print(word + ": ") ;
				for (Integer pageNumber : arr) {
					System.out.print(pageNumber + " ") ;
				}
				System.out.println() ;
			}

			// if the word is in the exclusion list
			//		print "Excluded from search."
			// else if the word is not in the text
			//		print "Not in text."
			// else
			//		print the list of page numbers
			//		use System.out.print(pageNumber + " ")
			//		followed by System.out.println() when done
		}
		
		scnr.close();
	}
}
	
