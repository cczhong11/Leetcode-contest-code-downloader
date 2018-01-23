# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):

    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        def dfs(root, ans):
            if not root:
                return 0
            l = dfs(root.left, ans)
            r = dfs(root.right, ans)
            ans[0] = max(ans[0], l+r+1)
            return max(l, r)+1

        ans = [0]
        dfs(root, ans)
        return ans[0]-1
