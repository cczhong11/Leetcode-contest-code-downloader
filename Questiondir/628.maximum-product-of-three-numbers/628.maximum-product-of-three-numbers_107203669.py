class Solution(object):
    def maximumProduct(self, a):
        """
        :type nums: List[int]
        :rtype: int
        """
        a = sorted(a)
        ans = a[-1] * a[-2] * a[-3]
        ans = max(ans, a[0]*a[1]*a[2])
        ans = max(ans, a[0]*a[1]*a[-1])
        return ans