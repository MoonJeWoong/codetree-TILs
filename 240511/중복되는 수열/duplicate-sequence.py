N = int(input())
nums = list()
for i in range(N):
    nums.append(input())
nums.sort(key= lambda x: len(x))

class Trie():
    def __init__(self,is_end=False):
        self.is_end = is_end
        self.children = [None for _ in range(10)]

tree = Trie()

def insert(node,vals):
    has_prefix = False
    for v in vals:
        if node.children[int(v)] is None:
            node.children[int(v)] = Trie()
        node = node.children[int(v)]
        if node.is_end: has_prefix = True
    if node.is_end: has_prefix = True
    node.is_end = True
    return has_prefix
has_prefix = False
for num in nums:
    if insert(tree, num):
        has_prefix = True
        break
print(0) if has_prefix else print(1)