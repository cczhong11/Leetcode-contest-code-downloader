class Solution(object):
    def nextClosestTime(self, time):
        """
        :type time: str
        :rtype: str
        """
        d = set(time)
        count = 0
        hour = int(time[:2])
        minute = int(time[3:])
        while True:
            minute += 1
            hour += minute/60
            minute%=60
            hour %= 24
            if all([c in d for c in list("%02d%02d"%(hour, minute))]):
                break
        return "%02d:%02d"%(hour, minute)