class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        ans, l = [0] * n, []
        for log in logs:
            i, se, t = log.split(':')
            i, t = map(int, [i, t])
            if se == 'start':
                if l:
                    ans[l[-1][0]] += t - l[-1][-1]
                l.append([i, t])
            else:
                _, t_ = l.pop()
                ans[i] += t + 1 - t_
                if l:
                    l[-1][-1] = t + 1
        return ans