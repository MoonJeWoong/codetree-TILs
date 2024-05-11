N = int(input())
parents = [-1 for _ in range(1+N)]
parents[1] = 1
for _ in range(N-1):
    p, c = list(map(int,input().split()))
    parents[c] = p
for i in range(2,N+1):
    print(parents[i])