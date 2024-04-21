A = list(input())
B = list(input())
A.sort()
B.sort()

is_same = True
for a, b in zip(A,B):
    if a != b:
        is_same = False
        break
if is_same:
    print("Yes")
else:
    print("No")