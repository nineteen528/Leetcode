package SJC;

import java.util.*;

/**
 * Created by SJC on 2017/12/16.
 */
public class Solution {
    class RandomizedCollection {
        Map<Integer,HashSet<Integer>> map;
        List<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            list.add(val);
            if(!map.containsKey(val)){
                map.put(val,new HashSet<>());
                return true;
            }else {
                HashSet set =  map.get(val);
                set.add(list.size()-1);
                map.put(val,set);
                return false;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            else {
                HashSet<Integer> set = map.get(val);
                Iterator it = set.iterator();
                int index = (Integer) it.next();
                set.remove(index);
                if(set.isEmpty()){
                    map.remove(val);
                }
                if(index == list.get(list.size()-1)){
                   list.remove(list.size()-1);
                }else {
                    if(list.get(index) == list.get(list.size() - 1)){
                        set.remove(list.size()-1);
                        set.add(index);
                        list.remove(list.size()-1);
                    }else {
                        int lastnum = list.get(list.size()-1);
                        list.set(index,lastnum);
                        HashSet s = map.get(list.get(lastnum));
                        s.remove(list.size()-1);
                        s.add(index);
                        list.remove(list.size()-1);
                    }
                }
                return true;
            }
        }

        /** Get a random element from the collection. */
        public int getRandom() {
           int temp = new Random().nextInt(list.size());
           return list.get(temp);
        }
    }
}
