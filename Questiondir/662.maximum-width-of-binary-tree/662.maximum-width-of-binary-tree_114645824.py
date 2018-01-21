# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def widthOfBinaryTree(self, root):
        minL, maxL = [], []
        def iterTree(root, depth, timestamp):
            if root==None: return
            if depth == len(minL):
                minL.append(timestamp)
                maxL.append(timestamp)
            else:
                minL[depth] = min(minL[depth], timestamp)
                maxL[depth] = max(maxL[depth], timestamp)                
            iterTree(root.left, depth+1, timestamp*2+1)
            iterTree(root.right,depth+1, timestamp*2+2)
        iterTree(root,0,0)
        return max([maxL[i]-minL[i] for i in range(len(maxL))])+1
        