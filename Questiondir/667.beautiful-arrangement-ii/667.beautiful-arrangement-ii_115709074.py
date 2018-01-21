class Solution(object):
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        taken = [False for _ in range(k + 2)]

        ans = [1 for _ in range(n)]
        taken[1] = True
        for i in range(1, k + 1):
            d = k - i + 1
            if ans[i - 1] + d > k + 1 or taken[ans[i - 1] + d]:
                ans[i] = ans[i - 1] - d
                taken[ans[i - 1] - d] = True
            else:
                ans[i] = ans[i - 1] + d
                taken[ans[i - 1] + d] = True
        for i in range(k + 1, len(ans)):
            ans[i] = i + 1
        return ans
