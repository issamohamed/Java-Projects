public class StringIntMap{
    // In all the function definitions, `keys` is the array of keys,
// `values` is the array of corresponding values, and `n` is the
// number of array elements actually being used.

// Put a new key/value pair in the map.  If the given key already
// exists, just update the value.
public static int put(String[] keys, int[] values, int n, String newKey, int newValue){
    int idx = StringArrayUtils.find(keys, 0, n, newKey);
    if (idx == -1) {
        keys[n] = newKey;
        values[n] = newValue;
        return n+1;
    } else{
        values[idx] = newValue;
    }
    return n;
   
}

// Retrieve the value associated with the given key.  If this key
// is not in the dictionary, return -1.  (Not the best design, but
// we'll deal with that later!)
public static int get(String[] keys, int[] values, int n, String key){
    int idx = StringArrayUtils.find(keys, 0, n, key);
    if(idx != -1){
        return values[idx];
    }
    return 0;
}
   

// Determine whether the given key is in the map.
public static boolean contains(String[] keys, int[] values, int n, String key){
    int idx = StringArrayUtils.find(keys, 0, n, key);
    if(idx == -1){
        return false;
    }else{
        return true;
    }

}
   

// Return the value associated with the smallest (alphabetically)
// key.  Note that this does not return the key itself.
public static int minKeyValue(String[] keys, int[] values, int n){
   
    int idx = StringArrayUtils.minElement(keys, 0, n);
    return values[idx];

}
// Return the value associated with the largest (alphabetically)
// key.  Note that this does not return the key itself.
public static int maxKeyValue(String[] keys, int[] values, int n) {
    int idx = StringArrayUtils.maxElement(keys, 0, n);
    return values[idx];
}
   
}
