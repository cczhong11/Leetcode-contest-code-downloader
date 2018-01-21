class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        bn = self.convert2(num)
        repo = {}
        
        def solve(blist):
            if blist in repo:
                return repo[blist]
                
            while blist and blist[0] == 0:
                blist = blist[1:]
            if len(blist) <= 0:
                repo[blist] = 1
                return 1
            if len(blist) == 1:
                repo[blist] = blist[0]+1
                return blist[0]+1
            if len(blist) == 2:
                repo[blist] = 3
                return 3
                
            if blist[1] == 1:
                rv = solve(tuple([1]*(len(blist)-1))) + solve(tuple([1]*(len(blist)-2)))
            else:
                rv = solve(tuple([1]*(len(blist)-1))) + solve(blist[2:])
            repo[blist] = rv
            return rv
            
        return solve(bn)
        
    def convert2(self, n):
        return tuple([int(x) for x in list('{0:0b}'.format(n))])
    
    