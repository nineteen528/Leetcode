package SJC;

import java.util.Stack;

/**
 * Created by SJC on 2017/12/27.
 */
public class PreOrder {
    public static void preOrderTraverse(TreeNode head){
        if(head == null) return;
        System.out.print(head.val+"   ");
        preOrderTraverse(head.lChild);
        preOrderTraverse(head.rChild);
    }
    public static void preOrderTraverse2(TreeNode head){
        if(head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode node = null;
        while (!stack.isEmpty()){
            while ((node = stack.peek()) != null){
                System.out.print(node.val + "   ");
                //node.visited = true;
                stack.push(node.lChild);
            }
            stack.pop();
            if(!stack.isEmpty()){
                node = stack.pop();
                stack.push(node.rChild);
            }
        }
    }
}
