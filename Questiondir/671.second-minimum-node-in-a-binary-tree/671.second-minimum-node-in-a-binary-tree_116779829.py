class Solution(object):
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.dic = set()
        def search(node):
            if not node:
                return
            self.dic.add(node.val)
            search(node.left)
            search(node.right)
        search(root)
        vals = sorted(self.dic)
        if len(vals) <= 1:
            return -1
        else:
            return vals[1]

