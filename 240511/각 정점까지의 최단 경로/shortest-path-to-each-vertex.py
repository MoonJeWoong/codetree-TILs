from collections import defaultdict
from heapq import heappop as pop, heappush as push
N, M = list(map(int,input().split()))
K = int(input())
graph = defaultdict(list)
for _ in range(M):
    v1,v2,w = list(map(int,input().split()))
    graph[v1].append((w,v2))
    graph[v2].append((w,v1))


dist = [float('inf') for _ in range(N+1)]
visited = [False for _ in range(N+1)]
dist[K] = 0

que = [(0,K)]
while que:
    w, n = pop(que)
    if visited[n]: continue
    visited[n] = True

    for near in graph[n]:
        n_weight, n_node = near
        if visited[n_node]: continue
        new_weight = n_weight + w
        if dist[n_node] > new_weight:
            dist[n_node] = new_weight
            push(que, (new_weight, n_node))

for i in range(1,N+1):
    d = dist[i] if dist[i] != float('inf') else -1
    print(d)