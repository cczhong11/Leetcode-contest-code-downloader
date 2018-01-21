class Solution:
    def intersectionSizeTwo(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        def verifyTwo(start, end):
            found_one = False
            found_two = False
            for i in result:
                if i >= start and i <= end:
                    if not found_one:
                        found_one = True
                    else:
                        found_two = True
                        return
            if not found_two:
                if end not in result:
                    result.add(end)
                elif end-1 not in result:
                    result.add(end-1)
                elif start not in result:
                    result.add(start)
                else:
                    result.add(start+1)


        intervals.sort(key=lambda x: x[1])
        result = set()
        end = -float('inf')

        for interval in intervals:
            if interval[0] > end:
                result.add(interval[1])
                end = interval[1]

        for start, end in intervals:
            verifyTwo(start, end)

        # print(result)

        return len(result)