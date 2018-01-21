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
        if not root: return res
        st = [root]
        while st:
            new_st = []
            val = []
            for nn in st:
                val.append(nn.val)
                if nn.left: new_st.append(nn.left)
                if nn.right: new_st.append(nn.right)
            res.append(1.0 * sum(val) / len(val))
            st = new_st
        return res