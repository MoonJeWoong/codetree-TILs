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


dist[k] = 0

import heapq as hq

hq.heappush(pq,(0,k))

while pq:
    min_dist, min_idx = hq.heappop(pq)

    if min_dist != dist[min_idx]: continue

    for next_dist, next_idx in graph[min_idx]:
        new_dist = dist[min_idx] + next_dist
        if dist[next_idx] > new_dist:
            dist[next_idx] = new_dist
            hq.heappush(pq, (new_dist, next_idx))

for i in range(1, N+1):
    if dist[i] == INT_MAX:
        print(-1)
    else:
        print(dist[i])