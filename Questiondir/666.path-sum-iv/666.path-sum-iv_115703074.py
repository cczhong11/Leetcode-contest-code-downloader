class Solution(object):
    def pathSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        g = [{} for i in range(6)]
        for i in nums:
            depth = i / 100
            pos = i / 10 % 10
            v = i % 10
            g[depth][pos] = v
        def dfs(depth, pos):
            left = pos * 2 - 1
            right = pos * 2
            lv, lnum = (0, 0)
            if left in g[depth + 1]:
                lv, lnum = dfs(depth + 1, left)
            rv, rnum = (0, 0)
            if right in g[depth + 1]:
                rv, rnum = dfs(depth + 1, right)
            if lnum == 0 and rnum == 0:
                return (g[depth][pos], 1)
            else:
                return (lv + rv + (lnum + rnum) * g[depth][pos], lnum + rnum)
        if len(nums) == 0:
            return 0
        v, num = dfs(1, 1)
        return v