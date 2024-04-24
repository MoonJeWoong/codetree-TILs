N, M = list(map(int,input().split()))
board = list()
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)


area_mem = dict()
area_mem[0] = [(0,0)]
def generate_area(K):
    if K in area_mem:
        return area_mem[K]    
    else:
        data = list()
        dx,dy = -K,0
        while dy < K:
            data.append((dx,dy))
            dx += 1
            dy += 1
        assert dx == 0
        while dx < K:
            data.append((dx,dy))
            dx += 1
            dy -= 1
        assert dy == 0
        while dy > -K:
            data.append((dx,dy))
            dx -= 1
            dy -= 1
        assert dx == 0
        while dx > -K:
            data.append((dx,dy))
            dx -= 1
            dy += 1
        area_mem[K] = generate_area(K-1) + data
        # data.append((x+dx,y+dy))
        return area_mem[K]
cost_k = lambda k: (k*k)+(k+1)*(k+1)

max_coin = 0
for x in range(N):
    for y in range(N):
        for k in range(N):
            cost = cost_k(k)
            num_coin = 0
            for dx,dy in generate_area(k):
                if not ((0<=(x+dx)<N) and (0<=(y+dy)<N)): continue
                if board[x+dx][y+dy] == 1:
                    num_coin += 1
            if num_coin*M - cost >= 0:
                max_coin = max(num_coin, max_coin)
            
print(max_coin)
        
        
        


            
        # data = list()
        # for dx,dy in zip([ k for k in range(K)], [k for k in range(K,-1,-1)]):
        #     print(1,(x+dx,y+dy))
        #     data.append((x+dx,y+dy))
        # for dx,dy in zip([ k for k in range(K-1,-1,-1)], [k for k in range(-1,-K-1,-1)]):
        #     data.append((x+dx,y+dy))
        #     print(2,(x+dx,y+dy))
        # for dx,dy in zip([ k for k in range(1,-K-1,-1)], [k for k in range(-K+1,1,1)]):
        #     data.append((x+dx,y+dy))
        #     print(3,(x+dx,y+dy))
        # for dx,dy in zip([ k for k in range(-K+1,0,1)], [k for k in range(1,K,1)]):
        #     data.append((x+dx,y+dy))
        #     print(4,(x+dx,y+dy))
        # return data + generate_area(x,y,K-1)