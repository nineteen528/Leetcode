package test;

import java.util.*;

/**
 * Created by SJC on 2017/11/25.
 * Given a chemical formula (given as a string), return the count of each atom.

 An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

 Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

 A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

 Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

 Example 1:
 Input:
 formula = "H2O"
 Output: "H2O"
 Explanation:
 The count of elements are {'H': 2, 'O': 1}.
 Example 2:
 Input:
 formula = "Mg(OH)2"
 Output: "H2MgO2"
 Explanation:
 The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 Example 3:
 Input:
 formula = "K4(ON(SO3)2)2"
 Output: "K4N2O14S4"
 Explanation:
 The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 */
public class solution {
    //栈解决方法
    public static String countOfAtoms(String formula){
       Stack<Map<String ,Integer>> stack = new Stack<>();
       Map <String ,Integer> map = new HashMap<>();
       int i = 0;
       int n = formula.length();
       while (i < n){
           char c = formula.charAt(i);
           i++;
           if(c == '('){
                stack.push(map);
                map = new HashMap<>();
           }else if(c == ')'){
               int val = 0;
               while (i < n && Character.isDigit(formula.charAt(i))){
                   val = val*10+formula.charAt(i++)-'0';
               }
               if(val == 0) val = 1;
               if(!stack.isEmpty()){
                   Map<String ,Integer> temp = map ;
                   map = stack.pop();
                   for(String key:temp.keySet()){
                       map.put(key,map.getOrDefault(key,0) + temp.get(key) * val);
                   }
               }
           }else{
               int start = i-1;
               while (i < n && Character.isLowerCase(formula.charAt(i))){
                   i++;
               }
               String s = formula.substring(start,i);
               int val = 0;
               while (i < n && Character.isDigit(formula.charAt(i))){
                   val = val*10+formula.charAt(i++)-'0';
               }
               if(val == 0){
                   val = 1;
               }
               map.put(s,map.getOrDefault(s,0)+val);
           }
       }
        System.out.println(map.get("Be"));
       StringBuilder sb = new StringBuilder();
       List<String> list = new LinkedList<>(map.keySet());
       Collections.sort(list);
       for(String key:list){
           sb.append(key);
           if(map.get(key) > 1){
               sb.append(map.get(key));
           }
       }
       return sb.toString();
    }

    public static void main(String[] args) {
        String a = "Be32";
        System.out.println(countOfAtoms(a));

    }
    //递归算法
    /*public String countOfAtoms(String formula) {
        Map<String, Integer> map = countHelper(formula);

        List<String> atoms = new ArrayList<>(map.keySet());
        Collections.sort(atoms);
        StringBuilder sb = new StringBuilder();
        for (String atom : atoms) {
            sb.append(atom + (map.get(atom) > 1 ? map.get(atom) : ""));
        }

        return sb.toString();
    }

    private Map<String, Integer> countHelper(String formula) {
        Map<String, Integer> map = new HashMap<>();
        if (formula.isEmpty()) return map;

        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                int count = 0, j = i;
                for (; j < formula.length(); j++) {
                    if (formula.charAt(j) == '(') count++;
                    else if (formula.charAt(j) == ')') count--;
                    if (count == 0) break;
                }
                Map<String, Integer> subMap = countHelper(formula.substring(i + 1, j));

                j++;
                int n = 1, k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                if (k > j) {
                    n = Integer.parseInt(formula.substring(j, k));
                }

                for (String atom : subMap.keySet()) {
                    map.put(atom, subMap.get(atom) * n + map.getOrDefault(atom, 0));
                }

                i = k;
            } else {
                int j = i + 1;
                while (j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') j++;

                int n = 1, k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                if (k > j) {
                    n = Integer.parseInt(formula.substring(j, k));
                }

                String atom = formula.substring(i, j);
                map.put(atom, n + map.getOrDefault(atom, 0));

                i = k;
            }
        }

        return map;
    }*/
}
