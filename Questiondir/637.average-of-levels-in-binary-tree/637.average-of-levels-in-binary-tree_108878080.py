
class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        ret = []
        q = []
        if not root: return ret
        q.append((root, 0))
        while len(q) > 0:
            node, depth = q.pop(0)
            if len(ret) <= depth:
                ret.append([])
            ret[depth].append(node.val)
            for c in (node.left, node.right):
                if not c: continue
                q.append((c, depth+1))
        return [float(sum(x))/len(x) for x in ret]
