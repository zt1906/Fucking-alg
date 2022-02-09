//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 示例 2: 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 212 - 1] 范围内 
// -1000 <= node.val <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 
// 👍 667 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // method 1: 每个root节点需要将左孩子的next指向右孩子；同时将右孩子指向root.next.left。剩下的交给递归。
//    public Node connect(Node root) {
//        if (root == null)
//            return null;
//        if (root.left != null)
//            root.left.next = root.right;
//        if (root.right != null && root.next != null)
//            root.right.next = root.next.left;
//        connect(root.left);
//        connect(root.right);
//        return root;
//    }
    // method 2: 两两节点相连
//    public Node connect(Node root) {
//        connectTwoNode(root.left, root.right);
//        return root;
//    }
//    public void connectTwoNode(Node root1, Node root2) {
//        if (root1 == null || root2 == null)
//            return;
//        root1.next = root2;
//        connectTwoNode(root1.left, root1.right);
//        connectTwoNode(root1.right, root2.left);
//        connectTwoNode(root2.left, root2.right);
//    }
    // method 3: 层序遍历相连
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node top = queue.poll();
                top.next = (i != size - 1 ? queue.peek() : null);
                if (top.left != null)
                    queue.add(top.left);
                if (top.right != null)
                    queue.add(top.right);
            }
        }
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
