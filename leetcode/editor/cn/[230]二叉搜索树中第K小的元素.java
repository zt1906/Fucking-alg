//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 574 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.sun.javaws.IconUtil;
import sun.reflect.generics.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNodeV2 {
    int val;
    TreeNodeV2 left;
    TreeNodeV2 right;
    int size;
    int no;
    TreeNodeV2(){}
    TreeNodeV2(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    TreeNodeV2(int val, TreeNodeV2 left, TreeNodeV2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public int buildSize(TreeNodeV2 root) {
        if (root == null)
            return 0;
        int leftSize = buildSize(root.left);
        int rightSize = buildSize(root.right);
        root.size = leftSize + rightSize;
        return root.size + 1;
    }

    public int compare(TreeNodeV2 root, int k) {

    }

    public void preTraversal(TreeNodeV2 root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preTraversal(root.left);
        preTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNodeV2 root = new TreeNodeV2(5);
        root.left = new TreeNodeV2(4);
        root.right = new TreeNodeV2(3);
        preTraversal(root);
    }

    int no = 0;
    int kth = 0;

    public int kthSmallest(TreeNode root, int k) {
        kth(root, k);
        return kth;
    }

    public void kth(TreeNode root, int k) {
        if (root == null)
            return;
        kthSmallest(root.left, k);
        no++;
        if (no == k) {
            kth = root.val;
        }
        kthSmallest(root.right, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
