package test;

import java.util.ArrayList;

/**
 * Created by SJC on 2017/12/3.
 */
public class Node {
    public ArrayList<Integer> a;
    public Node(ArrayList aa){
        a = aa;
    }
    public ArrayList getA(){
        return this.a;
    }
    public ArrayList setA(){
        a = new ArrayList<>();
        a.add(2);
        return a;
    }
}
