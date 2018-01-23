
class Solution(object):
    def convertBST(self, root, prev=None):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.prev = 0
        def search(root):
            if not root: return 
            search(root.right)
            root.val += self.prev
            self.prev = root.val
            search(root.left)
        search(root)
        return root
