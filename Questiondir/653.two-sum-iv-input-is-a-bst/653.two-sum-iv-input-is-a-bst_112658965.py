# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

import collections
class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        cnt = collections.Counter()
        def walk(root):
            if not root: return
            cnt[root.val] += 1
            walk(root.left)
            walk(root.right)
        walk(root)
        for v, c in cnt.items():
            if v+v == k and c > 1:
                return True
            if v+v != k and cnt[k-v] > 0:
                return True
        return False


