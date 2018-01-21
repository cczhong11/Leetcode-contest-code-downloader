class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num == 0:
            return 0
        ln = []
        while num > 0:
            ln.append(num % 10)
            num /= 10
        ln = ln[::-1]
        tmp = sorted(ln, key=lambda x: -x)
        i = 0
        while i < len(ln) and ln[i] == tmp[i]:
            i += 1
        if i < len(ln):
            j = len(ln)-1
            while ln[j] != tmp[i]:
                j -= 1
            ln[i], ln[j] = ln[j], ln[i]
        ans = 0
        p = 1
        for n in ln[::-1]:
            ans += n*p
            p *= 10
        return ans
        