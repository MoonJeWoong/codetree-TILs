N = int(input())
nums = list(map(int,input().split()))

for i in range(N):
    if i%2 == 0: # odd
        print(sorted(nums[:i+1])[i//2], end=' ')