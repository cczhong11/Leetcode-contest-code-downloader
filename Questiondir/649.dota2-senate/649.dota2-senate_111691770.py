class Solution(object):
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
        senate = list(senate)
        current = 0
        span = 0
        radC = 0
        dirC = 0
        rSpan = 0
        dSpan = 0
        while(rSpan < len(senate) + 2 and dSpan < len(senate) + 2):
            rSpan += 1
            dSpan += 1
            if senate[current] == "D":
                rSpan = 0
                if radC > 0:
                    senate[current] = "_"
                    radC -= 1
                    span = 0
                else:
                    dirC += 1
            elif senate[current] == "R":
                dSpan = 0
                if dirC > 0:
                    senate[current] = "_"
                    dirC -= 1
                    span = 0
                else:
                    radC += 1
            current += 1
            current %= len(senate)
        if rSpan >= len(senate) + 2:
            return "Radiant"
        if dSpan >= len(senate) + 2:
            return "Dire"