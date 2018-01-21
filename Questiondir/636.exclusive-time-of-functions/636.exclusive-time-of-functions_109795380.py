class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        times = [0] * n
        last_ts = 0
        lastf = -1
        s = []
        
        for log in logs:
            vals = log.split(':')
            fid = int(vals[0])
            soe = vals[1]
            ts = int(vals[2])
            
            elapsed = ts - last_ts
            if soe == 'start':
                if s:
                    times[s[-1]] += elapsed
                last_ts = ts
                s.append(fid)
            elif soe == 'end':
                times[fid] += elapsed + 1
                last_ts = ts + 1
                s.pop()

            lastf = fid
        return times
