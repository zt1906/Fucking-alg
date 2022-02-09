//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 220 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    // 当preStart==preEnd的时候，说明仅剩一个结点。直接return即可。不用再查找preStart+1结点。
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || postorder == null || preorder.length == 0 || postorder.length == 0)
            return null;

        return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        // 此处留意一下即可
        if (preStart == preEnd)
            return root;

        int value = preorder[preStart + 1];
        int index = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == value) {
                index = i;
                break;
            }
        }
        int leftSize = index - postStart + 1;
        root.left = construct(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = construct(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
