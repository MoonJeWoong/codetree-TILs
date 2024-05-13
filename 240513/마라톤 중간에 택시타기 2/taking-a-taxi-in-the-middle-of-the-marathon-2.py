N = int(input())
checkpoints = list()
for i in range(N):
    x, y  =list(map(int,input().split()))
    checkpoints.append((x,y))

eclidean = lambda p1,p2: abs(p1[0]-p2[0]) + abs(p1[1]-p2[1])

def compute_total(skip):
    points = [ checkpoints[i] for i in range(N) if i != skip]
    
    dist = 0
    for p1,p2 in zip(points,points[1:]):
        dist += eclidean(p1,p2)
    return dist

min_dist = float('inf')
for skip in range(1,N):
    dist = compute_total(skip)
    min_dist = min(dist,min_dist)
print(min_dist)