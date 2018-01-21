class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        ret = [0] * n
        stack = []
        for item in logs:
            flds = item.split(':')
            f = int(flds[0])
            time = int(flds[2])
            if flds[1] == 'start':
                if len(stack) > 0:
                    topf, topt = stack[-1]
                    ret[topf] += time - topt
                stack.append([f, time])
            else:
                topf, topt = stack.pop()
                ret[topf] += time - topt + 1
                if len(stack) > 0:
                    stack[-1][1] = time + 1
        return ret
