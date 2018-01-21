class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        rep=[0 for i in range(26)]
        for c in tasks:
            rep[ord(c)-ord('A')]+=1
        rep.sort()
        tot=0
        while rep[-1]>1:
            tot+=n+1
            for i in range(25,max(24-n,-1),-1):
                if rep[i]>0:
                    rep[i]-=1
            rep.sort()
        return tot+sum(rep)
        