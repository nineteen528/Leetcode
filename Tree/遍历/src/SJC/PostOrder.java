package SJC;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by SJC on 2017/12/28.
 */
public class PostOrder {
    public static void postOrderTraverse(TreeNode head){
        if(head == null) return;
        postOrderTraverse(head.lChild);
        postOrderTraverse(head.rChild);
        System.out.print(head.val + "   ");
    }
    public static void postOrderTraverse2(TreeNode head){
        //HashSet<TreeNode> visited = new HashSet<TreeNode>();
        if(head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode node;
        while (!stack.isEmpty()){
            while (( node = stack.peek()) != null){
                if(node.lChild != null && node.lChild.visited == true){
                    stack.push(null);
                    break;
                }
                stack.push(node.lChild);
            }
            stack.pop();                    //空指针出栈
            if(!stack.isEmpty()){
                node = stack.peek();
                if(node.rChild == null || node.rChild.visited == true){
                    System.out.print(node.val + "   ");
                    node.visited = true;
                    stack.pop();
                }else {
                    stack.push(node.rChild);
                }
            }
        }
    }
}
