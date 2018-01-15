import java.util.*;

/**
 * Created by SJC on 2017/12/13.
 *In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

 Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

 You need to output the sentence after the replacement.

 Example 1:
 Input: dict = ["cat", "bat", "rat"]
 sentence = "the cattle was rattled by the battery"
 Output: "the cat was rat by the bat"
 *
 */
public class Solution {
    public static String replaceWords(List<String> dict, String sentence) {
        String res ="";
        String []sen = sentence.split(" ");
        System.out.println(sen.length);
        Set<String> set = new HashSet<>();
        for(String s: dict){
            set.add(s);
        }
        for(String s : sen) {
            int i = 0;
            for (i = 0; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    res += s.substring(0, i) + " ";
                    break;
                }
            }
            if (i == s.length()) {
                res += s + " ";
            }
        }
        return res.substring(0,res.length()-1);
    }
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict,sentence));
    }
}
