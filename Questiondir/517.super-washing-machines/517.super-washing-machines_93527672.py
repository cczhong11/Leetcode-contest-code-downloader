class Solution(object):
    def findMinMoves(self, machines):
        """
        :type machines: List[int]
        :rtype: int
        """
        total_dress = sum(machines)
        if total_dress % len(machines) <> 0: return -1
        machines = [machine - total_dress / len(machines) for machine in machines]
        result = 0
        # less
        less2, partial_sum = 0, 0
        for i in range(len(machines)):
            partial_sum += machines[i]
            less2 = min(less2, partial_sum)
        partial_sum = 0
        for i in range(len(machines))[::-1]:
            partial_sum += machines[i]
            less2 = min(less2, partial_sum)
        result = max(result, -less2)
        # more
        more2, partial_sum = 0, 0
        for i in range(len(machines)):
            partial_sum += machines[i]
            more2 = max(more2, partial_sum)
        partial_sum = 0
        for i in range(len(machines))[::-1]:
            partial_sum += machines[i]
            more2 = max(more2, partial_sum)
        result = max(result, more2)
        # one more try
        for i in range(len(machines)):
            result = max(result, machines[i])
            #result = max(result, -machines[i])
        return result