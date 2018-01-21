class Solution(object):

    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        if not root:
            return False
        bfs = [root]
        s = set()
        for i in bfs:
            s.add(i.val)
            if i.left:
                bfs.append(i.left)
            if i.right:
                bfs.append(i.right)
        for i in s:
            if k - i != i and k-i in s:
                return True
        return False