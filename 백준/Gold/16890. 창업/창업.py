import sys
from collections import deque
import math

input = sys.stdin.readline


string1 = list(input().strip())
string2 = list(input().strip())

n = len(string1)
string1 = sorted(string1)[: math.ceil(n / 2)]
string2 = sorted(string2, reverse=True)[: math.floor(n / 2)]

que1 = deque(string1)
que2 = deque(string2)

answer = ["?"] * n

left, right = 0, n - 1
for i in range(n):
    if i % 2 == 0:
        if que2 and que1[0] >= que2[0]:
            answer[right] = que1.pop()
            right -= 1
        else:
            answer[left] = que1.popleft()
            left += 1
    else:
        if que1 and que1[0] >= que2[0]:
            answer[right] = que2.pop()
            right -= 1
        else:
            answer[left] = que2.popleft()
            left += 1


print("".join(answer))
