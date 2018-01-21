# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        height = 0
        q = [(root, 1)]
        while q:
            node, hei = q.pop()
            height = max(height, hei)
            if node.left:
                q.append((node.left, hei+1))
            if node.right:
                q.append((node.right, hei+1))
        size = [0] * (height+1)
        size[1] = 1
        for i in range(2, height+1):
            size[i] = 2*size[i-1] + 1
        ret = [[''] * size[height] for _ in range(height)]
        q = [(root, height, 0)]
        while q:
            node, hei, base = q.pop()
            ret[height-hei][base + size[hei-1]] = str(node.val)
            if node.left:
                q.append((node.left, hei-1, base))
            if node.right:
                q.append((node.right, hei-1, base + size[hei-1] + 1))
        return ret

