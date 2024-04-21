people = list()
for _ in range(5):
    n,h,w = input().split()
    h = int(h)
    w = float(w)
    people.append((n,h,w))

people.sort(key=lambda x:x[0])
print("name")
for n,h,w in people:
    print(f"{n} {h} {w}")
print()
people.sort(key=lambda x:-x[1])
print("height")
for n,h,w in people:
    print(f"{n} {h} {w}")