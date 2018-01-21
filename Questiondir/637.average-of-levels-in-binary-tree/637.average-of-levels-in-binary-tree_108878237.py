# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        def helper(nodes):
            newnodes = []
            tot = 0
            for n in nodes:
                tot += n.val
                if n.left is not None:
                    newnodes.append(n.left)
                if n.right is not None:
                    newnodes.append(n.right)
            return (float(tot)/len(nodes), newnodes)
        
        mynodes = []
        avgs = []
        if root is not None:
            mynodes.append(root)
        while len(mynodes) > 0:
            (avg, mynodes) = helper(mynodes)
            avgs.append(avg)
        return avgs
            