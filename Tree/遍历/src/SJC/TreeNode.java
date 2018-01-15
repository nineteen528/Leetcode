package SJC;


import static SJC.PostOrder.postOrderTraverse2;

/**
 * Created by SJC on 2017/12/25.
 */
public class TreeNode {
    public int val;
    TreeNode lChild;
    TreeNode rChild;
    boolean visited;
    public TreeNode(int val) {
        this.val = val;
        visited = false;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);
        TreeNode c1 = new TreeNode(4);
         TreeNode c2 = new TreeNode(5);
        TreeNode c3 = new TreeNode(6);
        TreeNode c4 = new TreeNode(7);
        TreeNode d1 = new TreeNode(8);
        TreeNode d2 = new TreeNode(9);
        TreeNode e1 = new TreeNode(10);
        TreeNode e2 = new TreeNode(11);

        head.lChild = b1;head.rChild = b2;
        b1.lChild = c1;b1.rChild = c2;
        b2.lChild = c3;b2.rChild = c4;
        c2.lChild = d1;c2.rChild = d2;
        d2.lChild = e1;d2.rChild = e2;
        System.out.print("中序");
        InOrder.inOrderTraverse(head);
        System.out.println();
        System.out.print("循环中序");
        InOrder.inOrderTraverse2(head);

        System.out.println();
        System.out.print("递归先序");
        PreOrder.preOrderTraverse(head);
        System.out.println();
        System.out.print("循环先序");
        PreOrder.preOrderTraverse2(head);

        System.out.println();
        System.out.print("递归后序");
        PostOrder.postOrderTraverse(head);
        System.out.println();
        System.out.print("循环后序");
        postOrderTraverse2(head);
    }
}
