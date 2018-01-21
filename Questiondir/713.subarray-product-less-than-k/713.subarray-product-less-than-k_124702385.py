class Solution:
    def numSubarrayProductLessThanK(self, nums, k):
        q, ans = [], 0
        for x in nums:
            if x >= k:
                q = []
                continue
            else:#search the position
                for pos in range(len(q) - 1, -1, -1):
                    tmp = q[pos] * x
                    if tmp >= k:
                        q = q[pos + 1:] if pos + 1 < len(q) else [] 
                        break;
                    else:
                        q[pos] = tmp
                q.append(x)
                ans += len(q)
        return ans