class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        time = 0
        start = 0
        state = -1
        stk = []
        result = [0] * n
        
        for line in logs:
            elem = line.split(":")
            new_state = int(elem[0])
            t = elem[1]
            new_time = int(elem[2])
            
            if t == "start":
                stk.append(new_state)
                if state >= 0:
                    result[state] += new_time - time
                time = new_time
                state = new_state
            else:
                stk.pop()
                result[state] += new_time - time + 1
                if len(stk):
                    state = stk[-1]
                time = new_time + 1
            
        return result