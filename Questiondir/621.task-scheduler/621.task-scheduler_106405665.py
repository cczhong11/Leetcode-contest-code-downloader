from collections import Counter

class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        ct = Counter(tasks).most_common()
        nxt = [[0, i] for i in xrange(26)]
        tasks = [0 for i in xrange(26)]
        for c, nt in ct:
            tasks[ord(c)-ord('A')] = nt
        t_left = sum(tasks)
        num_steps = 0
        while t_left > 0:
            mns, mncode = min(nxt)
            el_list = []
            for nstep, ncode in nxt:
                if tasks[ncode] == 0:
                    continue
                if nstep <= num_steps:
                	el_list.append((nstep, ncode))
            if not el_list:
            	mn_list = None
            	for nstep, ncode in nxt:
            		if tasks[ncode] == 0:
            			continue
        	        if mn_list is None or nstep < mn_list[0][0]:
        	            mn_list = [(nstep, ncode)]
        	        elif nstep == mn_list[0][0]:
        	            mn_list.append((nstep, ncode))
                num_steps = mn_list[0][0]
                el_list = mn_list
            bcode = el_list[0][1]
            for nstep, ncode in el_list:
                if tasks[ncode] > tasks[bcode]:
                    bcode = ncode
            tasks[bcode] -= 1
            t_left -= 1
            num_steps += 1
            nxt[bcode][0] = num_steps + n
        return num_steps
        
        
        