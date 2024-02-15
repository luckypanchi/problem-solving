import sys
from collections import Counter

input = sys.stdin.readline


number = list(map(int, input().strip()))
target = list(map(int, input().strip()))
numberCounter = Counter(number)
targetCounter = Counter(target)

answer = []

for num in number:
    if targetCounter[num] != 0 and numberCounter[num] == targetCounter[num]:
        numberCounter[num] -= 1
        targetCounter[num] -= 1
    else:
        while answer:
            if answer[-1] >= num or not targetCounter[answer[-1]]:
                break
            targetCounter[answer[-1]] -= 1
            answer.pop()
        numberCounter[num] -= 1
        answer.append(num)

print(*answer, sep="")

"""
32312
23
Output : 321

324312
423
Output : 321

221231
12
Output : 2231

443232144332113214323214134231421214
11122222333444
Output : 4444333214332141321211

1021
10
Output : 21
"""