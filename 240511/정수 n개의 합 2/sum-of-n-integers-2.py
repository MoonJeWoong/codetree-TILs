N,K = list(map(int, input().split()))
nums = list(map(int, input().split()))

accum = 0
nums_accum = [0 for _ in range(N)]
max_accum = 0
for i,n in enumerate(nums):
    accum += n
    nums_accum[i] = accum
    if i >= K:
        max_accum = max(max_accum, nums_accum[i]-nums_accum[i-K] )
    elif i==(K-1):
        max_accum = max(max_accum, nums_accum[i])
    else:
        pass
print(max_accum)