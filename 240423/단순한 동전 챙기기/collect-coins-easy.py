N = int(input())
board = list()
nums = list()
start_point, end_point = None, None
for i in range(N):
    line = input()
    for j in range(N):
        if line[j] in ['1','2','3','4','5','6','7','8','9']:
            nums.append((int(line[j]), i,j))
        elif line[j] == 'E':
            end_point = (i,j)
        elif line[j] == 'S':
            start_point = (i,j)

nums.sort()
nums = [(a,b) for _,a,b in nums]

def get_distance(a,b):
    return abs(a[0]-b[0]) + abs(a[1]-b[1])

global min_d
min_d = N*N*N
def backtrack(cnt,selected):
    global min_d
    if len(selected) == 3:
        d = get_distance(start_point, selected[0])
        for a,b in zip(selected, selected[1:]):
            d += get_distance(a,b)
        d += get_distance(selected[-1],end_point)
        min_d = min(d, min_d)
        return 
    if cnt == len(nums):
        return
    point = nums[cnt]
    selected.append(point)
    backtrack(cnt+1, selected)
    selected.pop()
    backtrack(cnt+1, selected)



if len(nums) < 3:
    print(-1)
else:
    selected = list()
    backtrack(0,selected)
    print(min_d)