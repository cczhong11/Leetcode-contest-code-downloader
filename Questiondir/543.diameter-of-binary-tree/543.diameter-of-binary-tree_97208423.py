
class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 1
        def search(root):
            if not root: return 0
            lef = search(root.left)
            rig = search(root.right)
            self.ans = max(self.ans, lef+rig+1)
            return max(lef, rig) + 1
        search(root)
        return self.ans - 1

        
