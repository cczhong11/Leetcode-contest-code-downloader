# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        stack = [(root, 1)]
        right_dep = []
        while stack:
            node, dep = stack.pop()
            if dep == d-1:
                right_dep.append(node)
            if dep < d-1:
                if node.left is not None:
                    stack.append((node.left, dep+1))
                if node.right is not None:
                    stack.append((node.right, dep+1))
        if not right_dep:
            new_root = TreeNode(v)
            new_root.left = root
            return new_root
        else:
            for node in right_dep:
                left = node.left
                right = node.right
                node.left = TreeNode(v)
                node.left.left = left
                node.right = TreeNode(v)
                node.right.right = right
            return root
        