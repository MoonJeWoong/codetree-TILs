N = int(input())

nums = [0 for i in range(N+1)]
accum_nums = [0 for i in range(N+1)]
from collections import defaultdict
tree = defaultdict(list)

for i in range(2,N+1):
    t,a,p = list(map(int,input().split()))
    if t == 1:
        nums[i] += a
    else:
        nums[i] -= a
    tree[p].append(i)

def dfs(v):
    accum_nums[v] += nums[v]
    if not tree[v]: return
    
    for c in tree[v]:
        dfs(c)
        accum_nums[v] += accum_nums[c]
    # accum_nums[v] += nums[v]
dfs(1)
print(accum_nums[1])