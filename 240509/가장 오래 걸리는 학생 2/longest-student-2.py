N, M = list(map(int,input().split()))
graph = [list() for i in range(N+1)]
for i in range(M):
    i,j,d =  list(map(int,input().split()))
    graph[j].append((d,i))

visited = [False for i in range(N+1)]
dist = [float('inf') for i in range(N+1)]

from heapq import heappush as push, heappop as pop

que = list()

dist[N] = 0
push(que, (0,N))

max_cost = 0
while que:
    cost, index = pop(que)
    if visited[index]: continue
    visited[index] = True

    max_cost = max(cost, max_cost)

    for next_cost, next_index in graph[index]:

        new_cost = dist[index] + next_cost
        if dist[next_index] > new_cost:
            dist[next_index] = new_cost
            push(que, (new_cost, next_index))
print(max_cost)