import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        return sum(root,new ArrayList<>(),list,sum,targetSum);
    }

    public List<List<Integer>> sum(TreeNode tree,List<Integer> list,List<List<Integer>> result,int sum,int targetSum) {
        if (tree == null) return null;
        sum += tree.val;
        list.add(tree.val);
        if (tree.left == null && tree.right == null && sum == targetSum) {
            result.add(list);
        }
        sum(tree.left,list,result,sum,targetSum);
        sum(tree.right,new ArrayList<>(list),result,sum,targetSum);
        return result;
    }

}


public class TestCopyConstruct {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,new TreeNode(3),new TreeNode(5));
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(6);
//        List<Integer> l2 = new ArrayList<>(l);
//        l2.add(5);
//        System.out.println(Arrays.toString(l.toArray()));
//        System.out.println(Arrays.toString(l2.toArray()));
        Solution solution = new Solution();
        int target = 6;
        solution.pathSum(treeNode,target);

    }
}
