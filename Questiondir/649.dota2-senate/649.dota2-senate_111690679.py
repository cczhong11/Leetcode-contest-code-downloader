class Solution(object):
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
        n=len(senate)
        ban=[0]*n
        while True:
            
            i=0
            while i<len(senate):
                target='D' if senate[i]=='R' else 'R'
                t=senate.find(target,i,n)
                if t==-1:
                    t=senate.find(target,0,i)
                if t==-1:
                    return "Radiant" if senate[i]=='R' else "Dire"
                senate=senate[:t]+senate[t+1:]
                if t>i:
                    i+=1
                    
                
            
                
                    