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
        if not root or not root.left and not root.right:
            return False
        def traverse(root):
            if not root:
                return 0
            root.val += traverse(root.left) + traverse(root.right)
            return root.val
        self.tgt = traverse(root)
        if self.tgt % 2 != 0:
            return False
        self.tgt /= 2
        self.found = False
        def search(root):
            if not root or self.found:
                return
            if root.val == self.tgt:
                self.found = True
                return
            search(root.left)
            search(root.right)
        search(root)
        return self.found
        