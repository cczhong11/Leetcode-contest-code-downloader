class Solution(object):
    def findIntegers(self, N):
        #num 0 <= x <= N no consecutive 1s
        B = map(int, bin(N)[2:])
        memo = {}
        def solve(i, flag = True):
            #flag = not allowed to go higher
            if (i, flag) not in memo:
                if i >= len(B):
                    #print 'here', i
                    ans = +1 #(i==len(B))
                elif B[i] == 1:
                    newflag = flag
                    if i+1 < len(B) and B[i+1] == 1:
                        newflag = False
                    aa,bb = solve(i+2, newflag), solve(i+1, False)
                    #print 'aa bb', i+2, newflag, '.', i+1, flag, ';', aa, bb
                    ans = aa+bb
                elif B[i] == 0:
                    if flag:
                        ans = solve(i+1, flag) #must write 0
                        #print 'ansi', ans, i, flag
                    else:
                        ans = solve(i+1, flag) + solve(i+2, flag)
                        #print 'ansj', ans, i+1, flag
                        
                memo[i,flag]=ans
                return ans
            return memo[i,flag]
    
        return solve(0)