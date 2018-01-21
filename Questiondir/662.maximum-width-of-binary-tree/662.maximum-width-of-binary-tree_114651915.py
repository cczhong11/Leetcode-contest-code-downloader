# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        ret = [0]
        left = {}
        def dfs(n, pos, level):
            if not n:
                return
            if level not in left:
                left[level] = pos
            else:
                left[level] = min(left[level], pos)
            ret[0] = max(ret[0], pos-left[level])
            dfs(n.left, pos*2-1, level+1)
            dfs(n.right, pos*2, level+1)
        dfs(root, 1, 0)
        return ret[0]+1