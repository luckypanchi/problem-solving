import sys

input = sys.stdin.readline


n = int(input())
cranes = sorted(list(map(int, input().split())), reverse=True)
m = int(input())
boxes = sorted(list(map(int, input().split())), reverse=True)

if boxes[0] <= cranes[0]:
    answer = 0

    while boxes:
        for crane in cranes:
            for box in boxes:
                if box <= crane:
                    boxes.remove(box)
                    break

        answer += 1

    print(answer)

else:
    print(-1)
