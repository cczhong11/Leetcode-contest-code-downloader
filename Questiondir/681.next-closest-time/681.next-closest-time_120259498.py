from datetime import datetime, timedelta

def check(dt, time_str):
    dt_str = datetime.strftime(dt, "%H%M")
    _time_str = set(list(dt_str))
    if _time_str & time_str == _time_str:
        return True
    return False
    
class Solution(object):
    def nextClosestTime(self, time):
        """
        :type time: str
        :rtype: str
        """
        time_str = set(list(time.replace(':', '')))
        time = datetime.strptime(time, "%H:%M")
        while True:

            time = time + timedelta(minutes=1)
            if check(time, time_str):
                return time.strftime("%H:%M")

        