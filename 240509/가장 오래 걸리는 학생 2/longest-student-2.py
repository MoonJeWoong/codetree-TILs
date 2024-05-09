N, M = list(map(int,input().split()))
graph = [list() for i in range(N+1)]
for i in range(M):
    i,j,d =  list(map(int,input().split()))
    graph[j].append((d,i))

visited = [False for i in range(N+1)]
dist = [float('inf') for i in range(N+1)]

import heapq as hq

pq = list()
hq.heappush(pq,(0,N))

max_cost = 0
dist[N] = 0
# print(graph)

while pq:
    cost, idx = hq.heappop(pq)
    # print(idx)
    if visited[idx]: continue
    visited[idx] = True

    max_cost = max(cost, max_cost)
    
    for near_cost, near_idx in graph[idx]:
        
        new_cost = dist[idx] + near_cost
        # print("\t", new_cost, near_cost,near_idx)
        if dist[near_idx] > new_cost:
            dist[near_idx] = new_cost
            hq.heappush(pq, (new_cost, near_idx))

# print(dist)
print(max_cost)