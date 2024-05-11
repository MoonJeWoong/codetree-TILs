from collections import defaultdict
N = int(input())

children = defaultdict(list)
distance = dict()
for _ in range(N-1):
    v1,v2,d = list(map(int,input().split()))
    children[v1].append(v2)
    distance[(v1,v2)] = d

global max_d
max_d = 0

def dfs(v,d):
    global max_d
    child = children[v]

    if not child:
        max_d = max(max_d, d)
        return 
    for c in child:
        new_d = distance[(v,c)]
        dfs(c,d+new_d)
dfs(1,0)
print(max_d)