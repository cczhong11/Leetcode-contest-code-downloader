# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def employeeFreeTime(self, avails):
        """
        :type avails: List[List[Interval]]
        :rtype: List[Interval]
        """
        axis = [0, 10 ** 8]
        label = [True, False]
        for em in avails:
            for interval in em:
                start = interval.start
                end = interval.end
                start_index = bisect.bisect_left(axis, start)
                if axis[start_index] != start:
                    axis.insert(start_index, start)
                    label.insert(start_index, label[start_index-1])
                end_index = bisect.bisect_left(axis, end)
                if axis[end_index] != end:
                    axis.insert(end_index, end)
                    label.insert(end_index, label[end_index-1])
                axis[start_index: end_index] = [start]
                label[start_index: end_index] = [False]
        result = list()
        i = 0
        while i < len(axis):
            if label[i]:
                if axis[i] == 0:
                    i += 1
                    continue
                origin = i
                while label[i]:
                    i += 1
                result.append(Interval(axis[origin], axis[i]))
            else:
                i += 1
        return result[:-1]