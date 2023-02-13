import sys
from collections import deque

input = sys.stdin.readline


s = int(input())

que = deque()
que.append((1, 0, 0))
visited = [(1, 0)]

while que:
    screen, clipboard, t = que.popleft()

    if (screen, screen) not in visited:
        visited.append((screen, screen))
        que.append((screen, screen, t + 1))

    if clipboard != 0 and (screen + clipboard, clipboard) not in visited:
        visited.append((screen + clipboard, clipboard))
        que.append((screen + clipboard, clipboard, t + 1))
        if screen + clipboard == s:
            print(t + 1)
            sys.exit()

    if screen > 0 and (screen - 1, clipboard) not in visited:
        visited.append((screen - 1, clipboard))
        que.append((screen - 1, clipboard, t + 1))
        if screen - 1 == s:
            print(t + 1)
            sys.exit()