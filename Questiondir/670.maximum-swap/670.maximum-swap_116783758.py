class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        ret = num
        dig = []
        while num > 0:
            a, b = divmod(num, 10)
            dig.append(b)
            num = a
        dig = dig[::-1]
        def cal():
            ans = 0
            for v in dig:
                ans = ans * 10 + v
            return ans
        for i in range(len(dig)):
            for j in range(i+1, len(dig)):
                dig[i], dig[j] = dig[j], dig[i]
                ret = max(ret, cal())
                dig[i], dig[j] = dig[j], dig[i]
        return ret

