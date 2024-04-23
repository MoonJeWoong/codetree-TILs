N = int(input())
board = list()
locs = list()
for i in range(N):
    line = list(map(int,input().split()))
    for j in range(N):
        if line[j] == 1:
            locs.append((i,j))
    board.append(line)

bomb = {
    1: [(-2,0), (-1,0), (1,0), (2,0)],
    2: [(-1,0), (0,1), (1,0), (0,-1)],
    3: [(-1,-1), (-1,1), (1,1), (1,-1)]
}

is_bound = lambda x,y: True if (0<=x<N) and (0<=y<N) else False
def bombed(x,y,btype):
    distoried_set = set()
    for dx,dy in bomb[btype]:
        nx,ny = x+dx, y+dy
        if is_bound(nx,ny) and (nx,ny) not in locs:
            distoried_set.add((nx,ny))
    return distoried_set

global max_val
max_val = 0
bombed_locs = set()
def backtack(cnt):
    global max_val

    if cnt == len(locs):
        distoried_num = len(bombed_locs) + len(locs)
        max_val = max(distoried_num, max_val)
        return
    for btype in [1,2,3]:
        x,y = locs[cnt]
        bl1 = bombed(x,y,btype)
        new_locs = bl1.difference(bombed_locs)
        
        bombed_locs.update(new_locs)
        # print(cnt, x,y)
        # print(btype,len(bombed_locs), len(new_locs), bombed_locs, new_locs)

        backtack(cnt+1)
        bombed_locs.difference_update(new_locs)

backtack(0)
print(max_val)