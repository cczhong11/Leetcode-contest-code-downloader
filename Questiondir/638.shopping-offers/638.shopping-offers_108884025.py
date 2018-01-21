class Solution(object):
    minp = 0
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        def fun(need, prc):
            full = True
            for s in special:
                tmp = need[:]
                for i in range(len(need)):
                    tmp[i] = need[i]-s[i]
                    if tmp[i]<0:
                        break
                else:
                    full = False
                    fun(tmp, prc+s[-1])
            if full:
                for i in range(len(need)):
                    prc += need[i]*price[i]
                if prc<self.minp:
                    self.minp = prc
                    
        self.minp = 6*sum(price)+10
        fun(needs, 0)
        s = 0
        for i in range(len(price)):
            s += price[i]*needs[i]
        self.minp = min(self.minp, s)
        return self.minp