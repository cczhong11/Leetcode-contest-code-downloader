class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        stack = [[None, None, 0]]
        time_dict = {}
        for log in logs:
            func_id, state, timestamp = log.split(':')
            if state == 'start':
                stack.append([func_id, timestamp, 0])
            else:
                _, start_timestamp, sub_time = stack.pop()
                total_time = int(timestamp) - int(start_timestamp) + 1
                int_id = int(func_id)
                time_dict[int_id] = time_dict.get(int_id, 0) + total_time - sub_time
                stack[-1][2] += total_time
        return [time_dict[int_id] for int_id in sorted(time_dict)]
                
                
        