import sys
from collections import Counter, defaultdict

input = sys.stdin.readline


string = input().strip()
counter = Counter(string)

rPositionList = []
rInfoDict = defaultdict(list)

kCnt = 0
for i in range(len(string)):
    s = string[i]
    if s == "R":
        rPositionList.append(i)
        rInfoDict[i].append(kCnt)
        rInfoDict[i].append(counter["K"] - kCnt)
    else:
        kCnt += 1

left, right = 0, len(rPositionList) - 1
answer = 0
while left <= right:
    _left, _right = rPositionList[left], rPositionList[right]

    answer = max(
        answer,
        right - left + 1 + min(rInfoDict[_left][0], rInfoDict[_right][1]) * 2,
    )

    if rInfoDict[_left][0] <= rInfoDict[_right][1]:
        left += 1
    else:
        right -= 1

print(answer)