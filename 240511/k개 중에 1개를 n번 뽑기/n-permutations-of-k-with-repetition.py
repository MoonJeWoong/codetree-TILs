K, N = list(map(int,input().split()))


def dfs(v,size):
    global K,N

    if size == N+1: 
        print(v)
        return
    for k in range(1,K+1):
        if v > 0:
            print(v, end=' ') 
        dfs(k,size+1)
dfs(0,1)