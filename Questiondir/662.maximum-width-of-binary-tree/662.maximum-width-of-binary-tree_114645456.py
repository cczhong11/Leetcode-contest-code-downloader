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
        if not root:
            return 0
        
        level = [[root, 0]]
        max_width = 0
        while level:
            max_width = max(max_width, level[-1][1] - level[0][1] + 1)
            new_level = []
            for node, index in level:
                if node.left:
                    new_level.append([node.left, index*2])
                if node.right:
                    new_level.append([node.right, index*2+1])
            level = new_level
        return max_width