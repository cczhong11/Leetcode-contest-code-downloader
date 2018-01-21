class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        f = [0]*10003
        total = [0]*10003
        for i in nums:
            total[i] += i
        f[0] = total[0]
        f[1] = total[1] if total[1] > total[0] else total[0]
        for i in range(2, 10001):
            if f[i] < f[i-1]:
                f[i] = f[i-1]
            if f[i] < f[i-2] + total[i]:
                f[i] = f[i-2] + total[i]
        return f[10000]
