class Solution(object):
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        left = 1
        right = n
        ans = []
        x = 0
        while k > 1:
            if x == 0:
                ans.append(left)
                left += 1
            else:
                ans.append(right)
                right -= 1
            x = 1 - x
            k -= 1
        if x == 0:
            for i in range(left, right+1):
                ans.append(i)
        else:
            for i in range(right, left-1, -1):
                ans.append(i)
        return ans