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
        if d == 1:
            new_root = TreeNode(v)
            new_root.left = root
            return new_root
            
        bin = [(root, 1)]
        idx = 0
        while idx < len(bin):
            cur, lv = bin[idx]
            idx += 1
            
            if lv == d-1:
                new_left = TreeNode(v)
                new_left.left = cur.left
                cur.left = new_left
                new_right = TreeNode(v)
                new_right.right = cur.right
                cur.right = new_right
            else:
                if cur.left is not None:
                    bin.append((cur.left, lv+1))
                if cur.right is not None:
                    bin.append((cur.right, lv+1))
        return root
            