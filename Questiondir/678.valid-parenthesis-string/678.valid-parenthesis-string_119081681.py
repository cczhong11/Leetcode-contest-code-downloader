class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n = len(s)
        memo = {}
        def dfs(idx, left):
            key = (idx, left)
            if key in memo:
                return memo[key]
            while idx < n:
                if left < 0:
                    memo[key] = False
                    return False
                if s[idx] == '(':
                    left += 1
                elif s[idx] == ')':
                    left -= 1
                else:
                    memo[key] = dfs(idx + 1, left) or dfs(idx + 1, left + 1) or dfs(idx + 1, left - 1)
                    return memo[key]
                idx += 1
            memo[key] = left == 0
            return memo[key]
        
        return dfs(0, 0)