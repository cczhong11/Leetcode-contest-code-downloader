# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def checkEqualTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def calc_sum(n):
            if not n:
                return 0
            return n.val+calc_sum(n.left)+calc_sum(n.right)
        s = [calc_sum(root)]
        def dfs(n):
            if not n:
                return (0, False)
            left, left_b = dfs(n.left)
            right, right_b = dfs(n.right)
            if left_b or right_b:
                return (0,True)
            if (s[0]-right == right and n.right) or (s[0]-left == left and n.left):
                return (0,True)
            return (left+n.val+right, False)
        return dfs(root)[1]