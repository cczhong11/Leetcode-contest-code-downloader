class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        dp, offers = {(0,) * len(price): 0}, {}
        for ss in special:
            ok = True
            for i in xrange(len(price)):
                if ss[i] > needs[i]:
                    ok = False
                    break
            if not ok: continue
            offers[tuple(ss[:-1])] = min(offers.get(tuple(ss[:-1]), 1 << 30), ss[-1])
        
        def get(state):
            if state in dp: return dp[state]
            ppp = sum(state[i] * price[i] for i in xrange(len(price)))
            for offer, val in offers.items():
                new_s = tuple(state[i] - offer[i] for i in xrange(len(state)))
                ok = True
                for p in new_s:
                    if p < 0: ok = False
                if ok:
                    new_p = get(new_s) + val
                    if new_p < ppp: ppp = new_p
            dp[state] = ppp
            return ppp
        
        res = get(tuple(needs))
        
        return res
        
                    