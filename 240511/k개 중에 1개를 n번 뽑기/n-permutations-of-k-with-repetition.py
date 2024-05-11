K, N = list(map(int,input().split()))


def dfs(arr):
    global K,N
    if len(arr) == N:
        for a in arr:
            print(a,end=' ')
        print()
        return 
    for k in range(1,K+1):
        arr.append(k)
        dfs(arr)
        arr.pop()
    
dfs(list())