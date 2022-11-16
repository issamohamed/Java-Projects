import java.util.HashSet;
import java.util.HashMap;

public class TwoSum {

	public static int countSlow(int[] a) {
		
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] + a[j] == 0)
					count += 1;
			}
		}
		
		return count;
	}
	
	public static int countFast(int[] a) {

      // Your code goes here.
	  int num_of_pairs = 0;
	  int len_array = a.length;
	  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len_array; i++) {
            if (map.containsKey(0 - a[i])) {
                num_of_pairs += map.get(0 - a[i]);
            }
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            }
            else {
                map.put(a[i], 1);
            }
        }
        return num_of_pairs;
  }
}
