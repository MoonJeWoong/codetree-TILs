# tree = [None for _ in range(26)]
a_to_idx = lambda x: ord(x) - ord('A')
get_child_idx = lambda idx: ((idx*2)+1,(idx*2)+2)
N = int(input())
tree = dict()
for _ in range(N):
    
    p,c1,c2 = list(input().split())
    if c1 == '.':
        c1 = None
    if c2 == '.':
        c2 = None
    tree[p] = (c1,c2)
# print(tree)

def preorder(n):
    print(n,end='')
    if n not in tree: return
    c1,c2 = tree[n]
    if c1: preorder(c1)
    if c2: preorder(c2)

def postorder(n):
    c1,c2 = tree[n]
    # if not c1 and not c2:
    #     print(n,end='')
    #     return
    
    if c1: postorder(c1)
    if c2: postorder(c2)
    print(n,end='')

def inorder(n):
    c1,c2 = tree[n]

    # if not c1 and not c2:
    #     print(n,end='')
    #     return
    if c1: inorder(c1)
    print(n,end='')
    if c2: inorder(c2)
    


preorder('A')
print()
inorder('A')
print()
postorder('A')