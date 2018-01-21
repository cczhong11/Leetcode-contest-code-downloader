# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d==1:
            New_root=TreeNode(v)
            New_root.left=root
            return New_root
            
        else:
            import collections
            Q=collections.deque()
            Q.append((root,1))
            while(Q):
                Node,level=Q.popleft()
                if level==d-1:
                
                    LT=TreeNode(v)
                    LR=TreeNode(v)
                    
                    LT.left=Node.left
                    LR.right=Node.right
                    
                    Node.left=LT
                    Node.right=LR
                else:
                    if Node.left!=None:
                        Q.append((Node.left,level+1))
                    if Node.right!=None:
                        Q.append((Node.right,level+1))
            return root