N = int(input())
nums = list()

for _ in range(N):
    n = int(input())
    nums.append(n)

max_size = 0
for size in range(N,-1,-1):
    # if size < 3: break
    init_sum =sum(nums[0:size])
    # print(size, init_sum, nums[0:size], N-size)
    if init_sum % 7 == 0:
        max_size = size
        break
    for i in range(N-size):
        # print("\t",i, size+i, '\t', nums[i],nums[size+i])
        init_sum = init_sum - nums[i] + nums[size+i]
        if init_sum % 7 == 0:
            max_size = size
    if max_size > 0:
        break
print(max_size)