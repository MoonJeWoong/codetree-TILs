N, K = list(map(int,input().split()))
bomb_nums = list()
for i in range(N):
    num = int(input())
    bomb_nums.append(num)
last_idx = dict()

max_val = -1
for i, num in enumerate(bomb_nums):
    if num in last_idx:
        if i - last_idx[num] < K:
            max_val = max(num, max_val)
    last_idx[num] = i

print(max_val)