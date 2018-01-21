class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """

        dic = {}
        dic['0000'] = True

        blocked = {}
        for de in deadends:
            blocked[de] = True

        if "0000" in blocked:
            return -1
        q = []
        q.append(('0000', 0))
        while q:
            cur = q.pop(0)
            if cur[0] == target:
                return cur[1]
            for i in range(4):
                if cur[0][i] == '0':
                    temp = cur[0][0:i] + '9' + cur[0][i + 1:4]
                    if temp not in dic and temp not in blocked:
                        dic[temp] = True
                        q.append((temp, cur[1] + 1))
                    temp = cur[0][0:i] + '1' + cur[0][i + 1:4]
                    if temp not in dic and temp not in blocked:
                        dic[temp] = True
                        q.append((temp, cur[1] + 1))
                elif cur[0][i] == '9':
                    temp = cur[0][0:i] + '0' + cur[0][i + 1:4]
                    if temp not in dic and temp not in blocked:
                        dic[temp] = True
                        q.append((temp, cur[1] + 1))
                    temp = cur[0][0:i] + '8' + cur[0][i + 1:4]
                    if temp not in dic and temp not in blocked:
                        dic[temp] = True
                        q.append((temp, cur[1] + 1))
                else:
                    temp = cur[0][0:i] + chr(ord(cur[0][i]) - 1) + cur[0][i + 1:4]
                    if temp not in dic and temp not in blocked:
                        dic[temp] = True
                        q.append((temp, cur[1] + 1))
                    temp = cur[0][0:i] + chr(ord(cur[0][i]) + 1) + cur[0][i + 1:4]
                    if temp not in dic and temp not in blocked:
                        dic[temp] = True
                        q.append((temp, cur[1] + 1))
        return -1
