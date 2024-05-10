N, M = list(map(int,input().split()))
graph = [ list() for _ in range(N+1)]
pq = []
import sys

INT_MAX = sys.maxsize
dist = [INT_MAX for _ in range(N+1)]

k = int(input())
for _ in range(M):
    v1,v2,w = list(map(int,input().split()))
    graph[v1].append((w,v2))
    graph[v2].append((w,v1))

visited = [False for _ in range(N+1)]

dist[k] = 0

from heapq import heappush as push, heappop as pop

push(pq,(0,k))


while pq:
    w, v1 = pop(pq)
    if visited[v1]: continue
    visited[v1] = True
    for near in graph[v1]:
        n_w, v2 = near
        new_w = w + n_w
        if dist[v2] > new_w: 
            dist[v2] = new_w
            push(pq,(new_w,v2))



for i in range(1, N + 1):
    print(dist[i])