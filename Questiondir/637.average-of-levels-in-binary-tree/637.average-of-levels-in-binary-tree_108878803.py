# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import defaultdict, deque

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        
        levels = defaultdict(list)
        
        bfs = deque()
        bfs.append((root, 0))
        
        maxlvl = 0
        while len(bfs) > 0:
            x, l = bfs.popleft()
            maxlvl = max(l, maxlvl)
            levels[l].append(x.val)
            if x.left:
                bfs.append((x.left, l+1))
            if x.right:
                bfs.append((x.right, l+1))
        
        # print levels
        avgs = [sum(levels[l])/(1.*len(levels[l])) for l in range(maxlvl+1)]
        return avgs
        