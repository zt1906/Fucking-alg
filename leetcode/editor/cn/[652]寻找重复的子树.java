//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 366 👎 0


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
    // 将每个结点的子树构造并序列化，保存到HashMap中，同时计次。
    List<TreeNode> rst = new ArrayList<>();
    HashMap<String, Integer> subTreeMaps = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        build(root);
        return rst;
    }

    public String build(TreeNode root) {
        if (root == null)
            return "#";
        String left = build(root.left);
        String right = build(root.right);
        String subTree = left + "," + right + "," + root.val;

        int cnt = subTreeMaps.getOrDefault(subTree, 0);
        if (cnt == 1) {
            rst.add(root);
        }
        subTreeMaps.put(subTree, cnt + 1);

        return subTree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
