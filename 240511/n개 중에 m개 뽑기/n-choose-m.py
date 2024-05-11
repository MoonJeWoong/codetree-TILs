N,M = list(map(int,input().split()))
visisted = set()
def dfs(arr):
    if len(arr) == M:
        for a in arr:
            print(a,end=' ')
        print()
    else:
        sidx = 1
        if arr: 
            sidx = max(arr)
        for n in range(sidx,N+1):
            if n in arr: continue
            arr.append(n)
            dfs(arr)
            arr.pop()
dfs(list())