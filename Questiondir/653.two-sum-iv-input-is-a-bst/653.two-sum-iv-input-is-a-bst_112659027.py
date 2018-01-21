class Solution(object) :
    def findTarget(self, root, tar) :
        dic = {}

        def dfs(node) :
            if node is None : return
            if node.val in dic :
                dic[node.val] += 1
            else :
                dic[node.val] = 1
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        for x in dic :
            y = tar - x
            if x == y :
                if dic[x] >= 2 :
                    return True
            else :
                if y in dic :
                    return True
        return False
