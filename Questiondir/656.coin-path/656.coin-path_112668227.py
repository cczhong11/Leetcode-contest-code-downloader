class Solution(object):
    def cheapestJump(self, A, B):
        """
        :type A: List[int]
        :type B: int
        :rtype: List[int]
        """
        if len(A) == 1:
            return [1]
        A = A[::-1]
        # coin, from
        dp = [(None, None) for _ in range(len(A))]
        dp[0] = (A[0], None)
        for i, coin in enumerate(A):
            if coin == -1 or (dp[i][1] is None and i != 0):
                continue
            for l in range(1, B + 1):
                if i + l >= len(A) or A[i+l] == -1:
                    continue
                if (dp[i+l][0] is None or
                    dp[i][0]+A[i+l] < dp[i+l][0] or
                    (dp[i][0]+A[i+l] == dp[i+l][0] and i > dp[i+l][1])):
                    dp[i+l] = (dp[i][0] + A[i+l], i)
        if dp[-1][1] is None:
            return []
        answer = []
        i = len(A)-1
        while True:
            answer.append(len(A)-i)
            if dp[i][1] is None:
                break
            i = dp[i][1]
        return answer