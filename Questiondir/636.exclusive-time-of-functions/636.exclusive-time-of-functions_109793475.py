class Solution(object):
    def exclusiveTime(self, N, logs):
        A = []
        START, END = 'start', 'end'
        for x in logs:
            a,b,c = x.split(':')
            A.append( (int(a), b, int(c)))
        
        ans = [0] * N
        stack = []
        start_time = A[0][2]
        cur_time = A[0][2]
        elapsed = 0
        for i, (fn1, typ1, time1) in enumerate(A):
            if typ1 == START:
                stack.append((fn1, time1))
            else:
                fn2, time2 = stack.pop()
                delta = time1 - time2 + 1
                ans[fn1] += delta
                stack = [(f, t+delta) for f,t in stack]
        return ans