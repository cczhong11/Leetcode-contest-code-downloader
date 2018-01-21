import heapq

class Solution(object):
    def scheduleCourse(self, courses):
        """
        :type courses: List[List[int]]
        :rtype: int
        """
        courses.sort(key = lambda course: course[1])
        tot = 0
        h = []
        for course in courses:
            t, d = course
            #print t, d
            if tot+t > d:
                if len(h) > 0:
                    largest = -heapq.heappop(h)
                    if t < largest:
                        heapq.heappush(h, -t)
                        tot += t - largest
                    else:
                        heapq.heappush(h, -largest)
                
            else:
                tot += t
                heapq.heappush(h, -t)
            #print h
        return len(h)