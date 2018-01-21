import datetime, calendar
class LogSystem(object):

    def __init__(self):
        self.logs = []

    def getDatetime(self, timestamp):
        tokens = [int(x) for x in timestamp.split(":")]
        dt = datetime.datetime(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5])
        return dt
    
    def getLastDay(self, dt):
        return calendar.monthrange(dt.year, dt.month)[1]
        
    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.logs.append([self.getDatetime(timestamp), id])
    
    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        dts, dte = self.getDatetime(s), self.getDatetime(e)
        if gra == "Year":
            dts = datetime.datetime(dts.year, 1, 1, 0, 0, 0)
            dte = datetime.datetime(dte.year, 12,31,23,59,59)
        elif gra == "Month":
          dts = datetime.datetime(dts.year, dts.month, 1, 0, 0, 0)
          dte = datetime.datetime(dte.year, dte.month, self.getLastDay(dte),23,59,59)
        elif gra == "Day":
          dts = datetime.datetime(dts.year, dts.month, dts.day, 0, 0, 0)
          dte = datetime.datetime(dte.year, dte.month, dte.day,23,59,59)
        elif gra == "Hour":
          dts = datetime.datetime(dts.year, dts.month, dts.day, dts.hour, 0, 0)
          dte = datetime.datetime(dte.year, dte.month, dte.day, dte.hour,59,59)
        elif gra == "Minute":
          dts = datetime.datetime(dts.year, dts.month, dts.day, dts.hour, dts.minute, 0)
          dte = datetime.datetime(dte.year, dte.month, dte.day, dte.hour, dte.minute,59)
        result = []
        for log in self.logs:
            dt = log[0]
            if dts <= dt and dt <= dte:
                result.append(log[1])
        return result


# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)