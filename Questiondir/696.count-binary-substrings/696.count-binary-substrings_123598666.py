class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        cnt = [1]
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                cnt[-1] += 1
            else:
                cnt.append(1)
        total_cnt = 0
        for i in range(len(cnt) - 1):
            total_cnt += min(cnt[i], cnt[i+1])
        return total_cnt
        