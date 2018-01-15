package sjc;

import javax.xml.soap.Node;
import java.util.*;

/**
 * Created by SJC on 2017/12/12.
 */
class NN implements Comparable<NN>{
    Integer a;
    public NN(Integer m){
        a = m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NN nn = (NN) o;

        return a != null ? a.equals(nn.a) : nn.a == null;
    }

    @Override
    public int hashCode() {
        return a != null ? a.hashCode() : 0;
    }
    public int compareTo(NN p){
        return 1;
    }
}
public class solution {
    public static List <String> topKFrequent(String[] words, int k){
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else {
                map.put(word,1);
            }
        }
        System.out.println("ff");
        System.out.println(map.entrySet());
        List list = new ArrayList(map.entrySet());
        System.out.println(list.get(0));
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry obj1 = (Map.Entry) o1;
                Map.Entry obj2 = (Map.Entry) o2;
                if((int)obj1.getValue() < (int)obj2.getValue()){
                    return 1;
                }else if((int)obj1.getValue() == (int)obj2.getValue()){
                    return ((String)obj1.getKey()).compareTo((String) obj2.getKey());
                }else {
                    return  -1;
                }
            }
        });
        List <String> res = new ArrayList<>();
        //System.out.println(list.get(0).toString().substring(0,list.get(0).toString().indexOf('=')));
        for(int i = 0;i < k;i++){
            res.add(list.get(i).toString().substring(0,list.get(i).toString().indexOf('=')));
        }
        return res;
    }
    public static void main(String[] args) {
        String [] a = {"i", "love", "leetcode", "i", "love", "coding"};
        int top = 2;
        List<String> r =  topKFrequent(a,top);


    }
}



//similar solution  定义一个word类，重写word的比较方法
/*
class Word implements Comparable<Word> {
    String s;
    int cnt;

    public Word(String s_) {
        s = s_;
    }

    public int compareTo(Word w) {
        if (w.cnt == this.cnt) {
            return this.s.compareTo(w.s);
        }
        return w.cnt - this.cnt;
    }
}

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Word> m = new HashMap<>();
        List<Word> l = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!m.containsKey(words[i])) {
                m.put(words[i], new Word(words[i]));
                l.add(m.get(words[i]));
            }
            m.get(words[i]).cnt++;
        }
        List<String> res = new ArrayList<>();
        Collections.sort(l);
        for (int i = 0; i < k;i++) res.add(l.get(i).s);
        return res;
   }*/
