Q = int(input())

class Command():

    def add(s,x):
        if (s >> x) & 1 == 0:
            s ^= (1<<x)
        return s
    def delete(s,x):
        if (s >> x) & 1 == 1:
            s ^= (1<<x)
        return s
    def print_(s,x):
        print((s >> x) & 1)
        return s        

    def toggle(s,x):
        s ^= (1<<x)
        return s
    def clear(s, x):
        return 0


s = 0
for _ in range(Q):
    order = input()
    if order == 'clear':
        command = order
        val = None
    else:
        command, val = order.split()
        val = int(val)
        if command == 'print':
            command += '_'
    s = getattr(Command, command)(s,val)