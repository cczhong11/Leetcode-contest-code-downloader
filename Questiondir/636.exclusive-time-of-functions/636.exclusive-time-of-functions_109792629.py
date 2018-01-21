class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        times = [0] * n
        stack = []
        
        for log in logs:
            s = log.split(':')
            f = int(s[0])
            typ = s[1]
            time = int(s[2])
            
            if typ == 'end':
                start = stack.pop()
                running = (time - start + 1)
                times[f] += running
                
                stack = [s + running for s in stack]
            else:
                stack.append(time)
        return times
        