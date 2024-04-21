N,K,T = input().split()
N = int(N)
K = int(K)
words = list()
for _ in range(N):
    word = input()
    if word.startswith(T):
        words.append(word)
words.sort()
print(words[K-1])