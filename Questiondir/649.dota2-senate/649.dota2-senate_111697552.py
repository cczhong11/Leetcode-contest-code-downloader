from collections import deque
class Solution(object):
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
            
        
        if 'D' not in senate:
            return 'Radiant'
        elif 'R' not in senate:
            return 'Dire'
        else:
            balance = 0 # positive if for radiance
            res = []
            for c in senate:
                
                if c == 'R':
                    if balance >= 0:
                        res.append('R')
                    balance += 1
                elif c == 'D':
                    if balance <= 0:
                        res.append('D')
                    balance -= 1
            
            for i in range(len(res)):
                if balance == 0:
                    break
                elif balance > 0 and res[i] == 'D':
                    res[i] = ''
                    balance -= 1
                elif balance < 0 and res[i] == 'R':
                    res[i] = ''
                    balance += 1
            new_senate = ''.join(res)
            #print new_senate, balance
            return self.predictPartyVictory(new_senate)
                    
            
        