class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dict_nums ={}
        for i in range(len(nums)): 
            if nums[i] in dict_nums:
                dict_nums[nums[i]]+=1
            else:
                dict_nums[nums[i]] = 1
        
        for ele in dict_nums:
            if dict_nums[ele] > (len(nums)//2):
                return ele

        