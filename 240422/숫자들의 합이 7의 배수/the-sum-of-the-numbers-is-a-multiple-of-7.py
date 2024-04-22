N = int(input())
nums = list()

for _ in range(N):
    n = int(input())
    nums.append(n)

max_size = 0
for size in range(N,-1,-1):

    for i in range(0,N-size+1,1):
        arr = nums[i:i+size]
        if sum(arr) % 7 == 0:
            max_size = size
            break
    if max_size > 0:
        break
print(max_size)