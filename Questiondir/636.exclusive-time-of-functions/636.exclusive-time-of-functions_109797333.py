class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        res = {}
        stack = []
        lasttime = 1
        for log in logs:
            log_arr = log.encode('ascii','ignore').split(':')
            # start
            if log_arr[1] == 'start':
                if len(stack) != 0:
                    last = stack[-1]
                    if not last[0] in res:
                        res[last[0]] = int(log_arr[2]) - lasttime
                    else:
                        res[last[0]] += int(log_arr[2]) - lasttime
                stack.append(log_arr)
                lasttime = int(log_arr[2])
            # end
            elif log_arr[1] == 'end':
                last = stack.pop()
                if not last[0] in res:
                    res[last[0]] = int(log_arr[2]) + 1 - lasttime
                else:
                    res[last[0]] += int(log_arr[2]) + 1 - lasttime
                lasttime = int(log_arr[2]) + 1
            # print log, stack, res
        result = []
        for i in range(n):
            result.append(res[str(i)])
        return result
            
        