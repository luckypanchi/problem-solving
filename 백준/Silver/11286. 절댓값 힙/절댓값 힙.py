import sys
import heapq

input = sys.stdin.readline


class node:
    def __init__(self, origin):
        self.origin = origin
        self.absolute = abs(origin)

    def __lt__(self, other):
        if self.absolute < other.absolute:
            return True
        elif self.absolute == other.absolute:
            return self.origin < other.origin

    def __str__(self):
        return f"{self.origin}"


n = int(input())
heap = []

for _ in range(n):
    num = int(input())
    if num == 0:
        if heap:
            print(heapq.heappop(heap).origin)
        else:
            print(0)
    else:
        heapq.heappush(heap, node(num))
