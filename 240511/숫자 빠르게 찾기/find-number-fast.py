N, M = list(map(int,input().split()))
nums = list(map(int,input().split()))

def find_idx(target):
    left = 0
    right = len(nums)

    while left <= right:
        mid = (left + right)//2
        if nums[mid] == target:
            return mid +1
        elif nums[mid] > target:
            right = mid - 1
        elif nums[mid] < target:
            left = mid + 1
        else: 
            assert False
    return -1


for i in range(M):
    print(find_idx(int(input())))