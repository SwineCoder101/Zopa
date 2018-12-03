
import java.util.Scanner;
import java.util.*;
class LRUCache {
    Map<Integer,Integer> cacheMap;
    List<Integer> lRUKeys;
    int maxNumberOfKeys;
    int setCounter;

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        //Your code here
        cacheMap = new HashMap<Integer,Integer>();
        this.maxNumberOfKeys=N;
        lRUKeys = new ArrayList<Integer>();
        lRUKeys.add(0);
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        //Your code here
        Integer value = cacheMap.get(x);
        if (value==null)
            return -1;
        else
            return value;
    }

    private void updateLRUKey(int x){
        lRUKeys.remove(x);
        lRUKeys.add(x);
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here

        if(lRUKeys.size() < 10){
            if (cacheMap.containsKey(x)){
                //updateLRUKey(x);

                System.out.println(x + "   " + cacheMap.size() + "       " + lRUKeys.indexOf(x));
                lRUKeys.remove(lRUKeys.indexOf(x));
            }
        }
        else{
            cacheMap.remove(lRUKeys.get(0));
            lRUKeys.remove(0);
        }
        cacheMap.put(x,y);
        lRUKeys.add(x);

    }
}
