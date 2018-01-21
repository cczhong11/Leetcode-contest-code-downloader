class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        # backtracking
        self.min_needed = sum([p * n for p, n in zip(price, needs)])
        for idx, p in enumerate(price):
            s = [0] * (len(price) + 1)
            s[idx] = 1
            s[-1] = p
            special.append(s)
        self.bt(price, special, needs, 0, 0)
        
        return self.min_needed
    
    def bt(self, price, special, needs, paid, start):
        if sum(needs) == 0:
            if paid < self.min_needed:
                self.min_needed = paid
            return
        
        for idx in range(start, len(special)):
            if self.is_valid(needs, special[idx]) and paid + special[idx][-1] < self.min_needed:
                newneeds = [n - s for n, s in zip(needs, special[idx][:-1])]
                self.bt(price, special, newneeds, paid + special[idx][-1], idx)
                
    def is_valid(self, needs, spec):
        for n, s in zip(needs, spec[:-1]):
            if n < s:
                return False
        return True
                
            
                
            
        
        
        