class Solution(object):
    def pathSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # sum_map[D][P]
        sum_map = [[0 for _ in range(8 + 1)] for _ in range(4 + 1)]
        is_leaf = [[False for _ in range(8 + 1)] for _ in range(4 + 1)]
        for i, num in enumerate(nums):
            d = num / 100
            p = (num / 10) % 10
            v = num % 10
            is_leaf[d][p] = True
            pp = (p + 1) / 2
            is_leaf[d - 1][pp] = False
            sum_map[d][p] = sum_map[d - 1][pp] + v
        ans = 0
        for d in range(1, 5):
            for p in range(1, 9):
                if is_leaf[d][p]:
                    ans += sum_map[d][p]
        return ans
