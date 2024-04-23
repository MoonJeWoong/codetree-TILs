N = int(input())
lines = list()
for i in range(N):
    x1, x2 = list(map(int,input().split())) 
    lines.append((x1,x2))


global max_val
max_val = 0

def is_overlap(x1,x2, lines):
    for a,b in lines:
        if a<=x1<=b or a<=x2<=b:
            return True
        if x1<=a<=x2 or x1<=b<=x2:
            return True

    return False

def backtrack(cnt, selected):
    global max_val
    if cnt == N:
        # if len(selected)==3:
        #     print(selected)
        max_val = max(len(selected),max_val)
        return

    
    x1, x2 = lines[cnt]
    if not is_overlap(x1,x2,selected):
        selected.append((x1,x2))
        backtrack(cnt+1, selected)
        selected.pop()
    backtrack(cnt+1, selected)
    
selected = list()
backtrack(0,selected)
print(max_val)