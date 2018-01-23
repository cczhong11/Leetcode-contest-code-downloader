# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):

    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return None

        def inorder(root, lst):
            if not root:
                return
            inorder(root.left, lst)
            lst.append(root)
            inorder(root.right, lst)

        nodes = []
        inorder(root, nodes)
        for i in xrange(len(nodes)-2, -1, -1):
            nodes[i].val += nodes[i+1].val
        return root
