N = int(input())

def dfs(comb):
    if len(comb) == N:
        for c in comb:
            print(c,end=' ')
        print()
        return 
    
    for c in range(1,N+1):
        if c in comb: continue
        comb.append(c)
        dfs(comb)
        comb.pop()
dfs([])