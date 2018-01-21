class Solution(object):
    def smallestRange(self, nums):
        S = set()
        for a in nums:
            S |= set(a)
        
        A = map(collections.deque, nums)
        best = -1000000, 1000000
        for left in sorted(S):
            right = -1000000
            for B in A:
                while B and B[0] < left:
                    B.popleft()
                if B:
                    right = max(right, B[0])
                else:
                    break
            else:
                if right > -1000000:
                    if right - left < best[1] - best[0]:
                        best = left, right
        return best