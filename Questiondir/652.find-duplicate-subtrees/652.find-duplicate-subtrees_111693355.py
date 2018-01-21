# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        self.d = {}
        def dfs(root):
            if root is None:
                return (0, 0)
            # try:
            #     self.d[root.val].append(root)
            # except KeyError:
            #     self.d[root.val] = [root]
            totalL, depthL = dfs(root.left)
            totalR, depthR = dfs(root.right)
            if depthL > depthR:
                this = (totalL + totalR + 1, depthL + 1)
            else:
                this = (totalL + totalR + 1, depthR + 1)
            thisHash = (root.val, this[0], this[1])
            try:
                self.d[thisHash].append(root)
            except KeyError:
                self.d[thisHash] = [root]
            return this
        
        dfs(root)
        
        def isSame(r1, r2):
            if r1 is None and r2 is None:
                return True
            if r1 is None or r2 is None:
                return False
            if r1.val != r2.val:
                return False
            if r1.left is None and r2.left is not None:
                return False
            if r1.left is not None and r2.left is None:
                return False
            if r1.right is None and r2.right is not None:
                return False
            if r1.right is not None and r2.right is None:
                return False

            return isSame(r1.left, r2.left) and isSame(r1.right, r2.right)

        ans = []
        for key, listOfRoot in self.d.iteritems():
            sameAs = [None]*len(listOfRoot)
            for i in range(len(listOfRoot)):
                if sameAs[i] is not None:
                    continue
                foundSame = False
                for j in range(i+1, len(listOfRoot)):
                    if isSame(listOfRoot[i], listOfRoot[j]):
                        sameAs[j] = i
                        foundSame = True
                if foundSame:
                    ans.append(listOfRoot[i])
        return ans
            