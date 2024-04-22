N = int(input())
nums = list()
num_accum = [0] * N
for i in range(N):
    n = int(input())
    nums.append(n)
    if i == 0:
        num_accum[i] = n
    else:
        num_accum[i] = n + num_accum[i-1]

max_size = 0
if num_accum[-1] % 7 == 0:
    max_size = N

for size in range(N,-1,-1):
    # print(size)
    if max_size > 0:
        break
    for i in range(N-size):
        j = size+i
        val = num_accum[j]- num_accum[i]
        if val % 7 == 0:
            max_size = size
            break

            

print(max_size)