# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        def findDepth(root):
            if (root == None):
                return 0
            return max(findDepth(root.left), findDepth(root.right))+1
        depth = findDepth(root)
        nLen = (1<<depth)-1
        ans = [["" for x in xrange(nLen)] for y in xrange(depth)]
        def pTree(root, l, r, d):
            if root == None:
                return
            mid = l + (r-l)/2
            ans[d][mid] = str(root.val)
            pTree(root.left, l, mid-1, d+1)
            pTree(root.right, mid+1, r, d+1)
            return
        pTree(root,0, nLen-1, 0)
        return ans
        