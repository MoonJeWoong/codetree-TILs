N = int(input())
A = list(map(int,input().split()))
B = list(map(int,input().split()))
A.sort()
B.sort()

is_same = True

for a,b in zip(A,B):
    if a != b:
        is_same = False
        break

if is_same:
    print("Yes")
else:
    print("No")