class Solution(object):
    def work(self,s1,s2):
        if len(s1)==1:
            return True
        if len(s2)==len(s1)-1:
            return self.work(s2,'')
        le=len(s2)
        s=s1[le:le+2]
        if s not in self.d.keys():
            return False
        for c in self.d[s]:
            if self.work(s1,s2+c):
                return True
        return False
        
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        self.d=dict()
        for s in allowed:
            if s[:2] in self.d.keys():
                self.d[s[:2]].append(s[-1])
            else:
                self.d[s[:2]]=[s[-1]]
                
        return self.work(bottom,'')