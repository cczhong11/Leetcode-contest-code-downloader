class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        s = str(num)
        n = len(s)
        ans = num
        for i in range(n-1):
            for j in range(i+1,n):
                tmps = ''
                for k in range(n):
                    if k == i:
                        tmps += s[j]
                    elif k == j:
                        tmps += s[i]
                    else:
                        tmps += s[k]
                ans = max(ans, int(tmps))
        return ans