class Solution(object):
    def check(self, tup, needs):
        for i in range(len(needs)):
            if needs[i] < tup[i]:
                return False
        return True

    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        import Queue

        pq = Queue.PriorityQueue()
        pq.put( (0, [0] * len(price) ) )

        best = 0
        for i in range(len(price)):
            best += price[i] * needs[i]

        while True:
            if pq.empty():
                return best
            cost, tup = pq.get()
            if cost >= best:
                return best

            c2 = cost
            for i in range(len(price)):
                c2 += (needs[i] - tup[i]) * price[i]
            best = min(best, c2)
            
            # special
            for s in special:
                cp = tup[:]
                for i in range(len(cp)):
                    cp[i] += s[i]
                if self.check(cp, needs):
                    pq.put( (cost + s[-1], cp) )
