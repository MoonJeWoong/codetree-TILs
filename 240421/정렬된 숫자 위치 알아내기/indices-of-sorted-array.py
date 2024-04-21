N = int(input())

nums = list(map(int,input().split()))

from collections import deque, defaultdict

idx_map = defaultdict(deque)

num_with_idx = list()
for i, n in enumerate(sorted(nums)):
    idx = i+1
    idx_map[n].append(idx)
    num_with_idx.append((idx,n))

for n in nums:
    print(idx_map[n].popleft(), end=' ')