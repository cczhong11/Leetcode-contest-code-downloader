class Solution(object):
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
        senate = list(senate)
        stack = []
        while len(senate)>1 and len(set(senate))>1:
            i = 0
            while i<len(senate):
                if len(stack) == 0:
                    stack.append(senate[i])
                    i += 1
                else:
                    if senate[i] == stack[-1]:
                        stack.append(senate[i])
                        i += 1
                    else:
                        stack.pop()
                        senate.pop(i)
        
        if senate[0] == 'R':
            return "Radiant"
        else:
            return "Dire"
        