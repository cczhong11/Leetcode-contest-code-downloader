class Solution(object):
    def checkPossibility(self, nums):
        flag = True
        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                flag = False
                a = i
                break
        if flag: return True
        flag = True
        t = nums[a]
        nums[a] = nums[a+1]
        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                flag = False
                break
        if flag: return True
        flag = True
        nums[a] = t
        nums[a+1] = t
        print nums
        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                return False        
        return True
        
        