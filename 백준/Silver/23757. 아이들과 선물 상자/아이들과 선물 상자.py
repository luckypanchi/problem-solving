import sys
import heapq

input = sys.stdin.readline


n, m = map(int, input().split())
boxes = list(map(int, input().split()))
childs = list(map(int, input().split()))

boxHeap = []

for box in boxes:
    heapq.heappush(boxHeap, (-box, box))

answer = 1
for child in childs:
    _, box = heapq.heappop(boxHeap)

    if box < child:
        answer = 0
        break
    elif child < box:
        left = box - child
        heapq.heappush(boxHeap, (-left, left))

print(answer)