class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        dp = {}
        n = len(price)
        dp[tuple([0] * n)] = 0

        def search(cur):
            if cur in dp:
                return dp[cur]
            answer = sum(i * j for i, j in zip(cur, price))
            for offer in special:
                oprice = offer[-1]
                offer = offer[:-1]
                if all(i >= j for i, j in zip(cur, offer)):
                    remain = tuple(i - j for i, j in zip(cur, offer))
                    answer = min(answer, search(remain) + oprice)
            dp[cur] = answer
            return answer

        return search(tuple(needs))
