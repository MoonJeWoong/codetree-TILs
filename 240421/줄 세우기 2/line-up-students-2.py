N = int(input())
people = list()
for i in range(N):
    h, w = list(map(int,input().split()))
    idx = i +1 
    people.append((idx,h,w))
people.sort(key=lambda x:(x[1],-x[2]))
for idx, h, w in people:
    print(h,w,idx)