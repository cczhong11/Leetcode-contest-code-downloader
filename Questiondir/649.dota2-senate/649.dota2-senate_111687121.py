class Solution(object):
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
        if len(senate) == 0:
            return "Radiant"
        if len(senate) == 1:
            return "Radiant" if senate[0] == "R" else "Dire"
        senate = list(senate)
        
        rCount = 0
        dCount = 0
        for i in senate:
            if i == "R":
                rCount += 1
            else:
                dCount += 1

        count = 0

        while rCount !=0 and dCount != 0:
            for i in range(len(senate)):
                if senate[i] == "w":
                    continue
                if count == 0:
                    major = senate[i]
                    count = 1
                else:
                    if senate[i] == major:
                        count += 1
                    else:
                        count -= 1
                        if senate[i] == "R":
                            rCount -= 1
                        else:
                            dCount -= 1
                        senate[i] = "w"
                        
        return "Radiant" if dCount==0 else "Dire"