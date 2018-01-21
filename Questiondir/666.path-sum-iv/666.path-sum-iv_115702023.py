class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution(object):
    def pathSum(self, nums):
        def f(node):
            if not node: return (0, 0) #val, count
            Lv,Lc = f(node.left)
            Rv,Rc = f(node.right)
            Av = Lv + Lc * node.val + Rv + Rc * node.val
            Ac = Lc + Rc
            if not node.left and not node.right:
                return node.val, 1
            return Av, Ac
        
        if not nums: return 0
        for x in nums:
            d, p, v = x/100, x/10%10, x%10
            if d == 1:
                root = Node(v)
            else:

                if d == 2:
                    if p == 1:
                        root.left = Node(v)
                    else:
                        root.right = Node(v)
                elif d== 3:
                    if p == 1:
                        root.left.left = Node(v)
                    elif p==2:
                        root.left.right = Node(v)
                    elif p==3:
                        root.right.left = Node(v)
                    elif p==4:
                        root.right.right = Node(v)
                else:
                    if p == 1:
                        root.left.left.left = Node(v)
                    elif p==2:
                        root.left.left.right = Node(v)
                    elif p==3:
                        root.left.right.left = Node(v)
                    elif p==4:
                        root.left.right.right =Node(v)
                    elif p==5:
                        root.right.left.left = Node(v)
                    elif p ==6:
                        root.right.left.right = Node(v)
                    elif p==7:
                        root.right.right.left = Node(v)
                    else:
                        root.right.right.right = Node(v)
        
        return f(root)[0]
        