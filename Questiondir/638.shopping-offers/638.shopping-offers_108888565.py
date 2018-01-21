class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        mem = dict()
        def search(state):
            ret = mem.get(state, None)
            if ret is not None:
                return ret
            ret = sum(a*b for a,b in zip(price, state))
            if ret == 0:
                mem[state] = ret
                return ret
            for item in special:
                sp, pp = item[:-1], item[-1]
                if pp >= ret:
                    continue
                new_state = tuple(b-a for a,b in zip(sp, state))
                if any(x < 0 for x in new_state):
                    continue
                ret = min(ret, pp + search(new_state))
            mem[state] = ret
            return ret
        return search(tuple(needs))

