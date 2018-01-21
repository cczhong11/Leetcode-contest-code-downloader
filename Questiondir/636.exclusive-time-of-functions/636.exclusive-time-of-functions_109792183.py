class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        prevTime = None
        stack = []
        answer = [0] * n
        for log in logs:
            function_id, start_or_end, timestamp = log.split(":")
            function_id = int(function_id)
            timestamp = int(timestamp)
            if prevTime is None:
                prevTime = timestamp
                stack.append(function_id)
            else:
                if start_or_end == "start":
                    if len(stack) > 0:
                        answer[stack[-1]] += timestamp - prevTime
                    prevTime = timestamp
                    stack.append(function_id)
                else:
                    timestamp += 1
                    answer[function_id] += timestamp - prevTime
                    prevTime = timestamp
                    stack.pop()
        return answer
