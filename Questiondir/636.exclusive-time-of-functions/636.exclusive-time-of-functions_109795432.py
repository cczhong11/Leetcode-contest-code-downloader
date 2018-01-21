class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        cpu_time = 0
        cpu_functions = []
        acc_time = [0] * n
        
        for log in logs:
            # parse log
            function_id, start_or_end, timestamp = log.split(":")
            function_id, timestamp = int(function_id), int(timestamp)
            
            # process current funciton
            if start_or_end == "start":
                if len(cpu_functions) == 0:
                    cpu_functions.append(function_id)
                else:
                    # stop the previous function
                    acc_time[cpu_functions[-1]] += timestamp - cpu_time
                    # start the new function
                    cpu_functions.append(function_id)
                # update cpu_time 
                cpu_time = timestamp
            else:
                # stop the current function
                acc_time[cpu_functions[-1]] += timestamp - cpu_time + 1
                # remove it from stack, i.e. start the previous function
                cpu_functions.pop()
                # update cpu_time
                cpu_time = timestamp + 1

        return acc_time
                    
            