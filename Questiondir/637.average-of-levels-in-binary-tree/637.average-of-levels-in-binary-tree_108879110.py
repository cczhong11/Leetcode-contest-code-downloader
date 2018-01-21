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
        res = []
        def iterTree(root,dep):
            if root==None: return
            if dep>=len(res):
                res.append([root.val,1])
            else:
                num, total = res[dep][0] , res[dep][1]
                res[dep] = [(num*total+root.val)*1.0/(total+1), total+1]
            iterTree(root.left,dep+1)
            iterTree(root.right,dep+1)
        iterTree(root,0)
        return [x[0] for x in res]