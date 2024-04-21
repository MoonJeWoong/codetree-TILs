N = int(input())
people = list()
for _ in range(N):
    n,h,w = input().split()
    h = int(h)
    w = int(w)
    people.append((n,h,w))

people.sort(key=lambda x:(x[1],-x[2]))

for n,h,w in people:
    print(f"{n} {h} {w}")