class Solution(object):
    def judgePoint24(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        
        def pick(cards):
            n = len(cards)
            for i in xrange(n):
                for j in xrange(i + 1, n):
                    yield ([cards[i], cards[j]], cards[:i] + cards[i+1:j] + cards[j+1:])
        
        memo = {}
        def dfs(cards, ops):
            if ops == 0:
                return len(cards) == 1 and cards[0] == 24
            
            key = (tuple(cards), ops)
            if key in memo:
                return False
            for cand, rems in pick(cards):
                val = cand[0] + cand[1]
                if dfs(rems[:] + [val], ops - 1):
                    return True
                val = cand[0] - cand[1]
                if dfs(rems[:] + [val], ops - 1):
                    return True
                val = cand[0] * cand[1]
                if dfs(rems[:] + [val], ops - 1):
                    return True
                if cand[1] != 0:
                    val = cand[0] * 1.0 / cand[1]
                    if dfs(rems[:] + [val], ops - 1):
                        return True
                val = cand[1] - cand[0]
                if dfs(rems[:] + [val], ops - 1):
                    return True
                if cand[0] != 0:
                    val = cand[1] * 1.0 / cand[0]
                    if dfs(rems[:] + [val], ops - 1):
                        return True
            memo[key] = False
            return False
        return dfs(nums, 3)
            