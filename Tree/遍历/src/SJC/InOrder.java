package SJC;

import java.util.Stack;


/**
 * Created by SJC on 2017/12/25.
 */
public class InOrder {
    //中序遍历  4   2   8   5   10   9   11   1   6   3   7
    public static void inOrderTraverse(TreeNode head){
        if(head == null) return;
        inOrderTraverse(head.lChild);
        System.out.print(head.val+ ""+"   ");
        inOrderTraverse(head.rChild);
    }
    public static void inOrderTraverse2(TreeNode head){
        if(head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = head;
        stack.push(node);
//        node = node.lChild;
//        while (!stack.empty() || node != null){
//            if(node != null){
//                stack.push(node);
//                node = node.lChild;
//            }else {
//                node = stack.pop();
//                System.out.print(node.val + "   ");
//                node = node.rChild;
//            }
//        }
        while ((!stack.isEmpty())){
            while ((node = stack.peek()) != null){
                stack.push(node.lChild);
               // node = node.lChild;
            }
            stack.pop();        //空指针出栈
            if(!stack.isEmpty()){
                TreeNode N = stack.pop();
                System.out.print(N.val + "   ");
                stack.push(N.rChild);
            }
        }
    }
}
