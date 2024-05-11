from collections import defaultdict
import sys
sys.setrecursionlimit(100000)

N = int(input())

tree = defaultdict(list)
for i in range(N-1):
    v1,v2 = list(map(int,input().split()))
    tree[v1].append(v2)
    tree[v2].append(v1)

dp = [[0,1] for _ in range(N+1)] 


def dfs(p,v):
    for c in tree[v]:
        if c == p: continue
        dfs(v,c)
        dp[v][0] += dp[c][1]
        dp[v][1] += min(dp[c][1],dp[c][0])
dfs(-1,1)
print(min(dp[1][0],dp[1][1]))