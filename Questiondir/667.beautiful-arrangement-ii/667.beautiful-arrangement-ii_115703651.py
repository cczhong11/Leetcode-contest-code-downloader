class Solution(object):
    def constructArray(self, n, k):
        cur = 1
        ans = []
        while n > k + cur:
            ans.append(cur)
            cur += 1
            
        rem = collections.deque(range(cur, n+1))
        d=1
        while rem:
            if d:
                ans.append(rem.popleft())
            else:
                ans.append(rem.pop())
            d ^=1
        return ans