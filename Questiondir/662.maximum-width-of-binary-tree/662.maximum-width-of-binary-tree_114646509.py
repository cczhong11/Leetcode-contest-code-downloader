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
        self.dict = {}
        def traverse(root, pos, h):
            if not root:
                return
            if h not in self.dict:
                self.dict[h] = [pos, pos]
            else:
                self.dict[h][0] = min(self.dict[h][0], pos)
                self.dict[h][1] = max(self.dict[h][1], pos)
            traverse(root.left, pos * 2, h + 1)
            traverse(root.right, pos * 2 + 1, h + 1)
        traverse(root, 1, 1)
        res = 0
        for h in self.dict:
            res = max(res, self.dict[h][1] - self.dict[h][0] + 1)
        return res
        