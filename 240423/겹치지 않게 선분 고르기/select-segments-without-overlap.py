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

    return False

def backtrack(cnt, selected):
    if cnt == N:
        global max_val
        max_val = max(len(selected),max_val)
        return
    
    for i, (x1,x2) in enumerate(lines):
        if is_overlap(x1,x2,selected):
            continue
        selected.append((x1,x2))
        backtrack(cnt+1, selected)
        selected.pop()

selected = list()
backtrack(0,selected)
print(max_val)