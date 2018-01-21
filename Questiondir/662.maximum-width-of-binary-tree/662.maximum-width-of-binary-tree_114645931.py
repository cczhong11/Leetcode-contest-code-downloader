# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        dic = {}
        def dfs(p, lev, ind):
            if p.left:
                dfs(p.left, lev + 1, ind * 2)
            if p.right:
                dfs(p.right, lev + 1, ind * 2 + 1)
            if not dic.has_key(lev):
                dic[lev] = [ind, ind]
            else:
                dic[lev][0] = min(dic[lev][0], ind)
                dic[lev][1] = max(dic[lev][1], ind)
        if not root:
            return 0
        dfs(root, 0, 1)
        # print dic
        res = 0
        for k in dic:
            res = max(res, dic[k][1] - dic[k][0])
        return res + 1