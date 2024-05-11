N, M = list(map(int,input().split()))
nums = list(map(int,input().split()))
def get_cnt(target):
    left = 0
    right = len(nums) - 1
    lower_bound = len(nums)
    while left <= right:
        mid = (left+right) // 2
        if nums[mid] >= target:
            lower_bound = min(lower_bound, mid)
            right = mid -1
        else:
            left = mid + 1
    left = 0
    right = len(nums) - 1
    upper_bound = len(nums)
    while left <= right:
        mid = (left+right) // 2
        if nums[mid] > target:
            upper_bound = min(upper_bound, mid)
            right = mid -1
        else:
            left = mid + 1
    return upper_bound-lower_bound
from collections import Counter
counter = Counter(nums)

for i in range(M):
    # print(get_cnt(int(input())))
    print(counter[int(input())])