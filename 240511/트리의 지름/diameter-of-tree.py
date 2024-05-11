N = int(input())
graph = [[0 for _ in range(N+1)] for _ in range(N+1)]
for _ in range(N-1):
    v1,v2,d = list(map(int,input().split()))
    graph[v1][v2] = d

global max_d
max_d = 0

def dfs(v,d):
    global max_d
    children = graph[v]
    if sum(children) == 0:
        max_d = max(max_d, d)
        return 
    for i,c_d in enumerate(children):
        if c_d == 0: continue
        dfs(i,d+c_d)
dfs(1,0)
print(max_d)