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

import heapq as hq

hq.heappush(pq, (0,k))

while pq:
    cost, idx = hq.heappop(pq)

    if visited[idx]: continue
    visited[idx] = True

    for near_cost, near_idx in graph[idx]:
        new_dist = dist[idx] + near_cost
        if dist[near_idx] > new_dist:
            dist[near_idx] = new_dist
            hq.heappush(pq, (new_dist, near_idx))
for i in range(1, N + 1):
    # 만약 도달이 불가능하다면 -1을 출력합니다.
    if dist[i] == INT_MAX:
        print(-1)
    else:
        print(dist[i])