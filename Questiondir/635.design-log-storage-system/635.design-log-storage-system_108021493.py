import datetime
class LogSystem(object):

    def __init__(self):
        self.A = []
    def put(self, tid, timestamp):
        dt = datetime.datetime.strptime(timestamp, '%Y:%m:%d:%H:%M:%S')
        self.A.append((tid, dt))

    def retrieve(self, s, e, gra):
        dts = datetime.datetime.strptime(s, '%Y:%m:%d:%H:%M:%S')
        dte = datetime.datetime.strptime(e, '%Y:%m:%d:%H:%M:%S')
        if gra == 'Year':
            dts = datetime.datetime(dts.year, 1, 1, 0, 0, 0)
            dte = datetime.datetime(dte.year +1, 1, 1, 0,0,0)
        elif gra == 'Month':
            dts = datetime.datetime(dts.year,dts.month, 1,0,0,0)
            try:
                dte = datetime.datetime(dte.year,dte.month+1, 1,0,0,0)
            except:
                dte = datetime.datetime(dte.year+1, 1, 1, 0, 0, 0)
        elif gra == 'Day':
            dts = datetime.datetime(dts.year,dts.month,dts.day, 0,0,0)
            dte = datetime.datetime(dte.year,dte.month,dte.day, 0,0,0) + datetime.timedelta(1)
        elif gra == 'Hour':
            dts = datetime.datetime(dts.year,dts.month,dts.day,dts.hour,0,0)
            dte = datetime.datetime(dte.year,dte.month,dte.day,dte.hour,0,0) + datetime.timedelta(hours=  1)
        elif gra == 'Minute':
            dts = datetime.datetime(dts.year,dts.month,dts.day,dts.hour,dts.minute,0)
            dte = datetime.datetime(dte.year,dte.month,dte.day,dte.hour,dte.minute,0) + datetime.timedelta(minutes = 1)
        ans = []
        def stat(dt):
            return dt.year, dt.month, dt.day, dt.hour, dt.minute, dt.second
        for tid, dt in self.A:
            #print gra, tid, stat(dts), stat(dt), stat(dte)
            if dts <= dt <= dte:
                ans.append(tid)
        return sorted(ans)

# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)