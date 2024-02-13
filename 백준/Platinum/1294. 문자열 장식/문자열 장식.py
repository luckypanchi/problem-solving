import sys
import heapq

input = sys.stdin.readline


class string:
    def __init__(self, s):
        self.s = s

    def __lt__(self, other):
        if self.s + other.s < other.s + self.s:
            return True
        else:
            return False


n = int(input())
h = []

for _ in range(n):
    heapq.heappush(h, string(input().strip()))

answer = ""

while h:
    s = heapq.heappop(h).s
    answer += s[0]
    if len(s) > 1:
        heapq.heappush(h, string(s[1:]))

print(answer)