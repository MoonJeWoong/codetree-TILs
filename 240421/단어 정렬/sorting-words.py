N = int(input())
words = list()
for _ in range(N):
    w = input()
    words.append(w)

words.sort()
for w in words:
    print(w)