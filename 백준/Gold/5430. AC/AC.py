import sys
from collections import deque

input = sys.stdin.readline


def main():
    t = int(input())

    result = []

    for _ in range(t):
        ops = input().strip()
        n = int(input())
        tmp = input().strip("[]\n").split(",")
        que = deque(tmp)

        cnt = 0
        answer = None

        for op in ops:
            if op == "R":
                cnt += 1
            else:
                if n == 0:
                    answer = -1
                    break
                n -= 1
                if cnt % 2 == 0:
                    que.popleft()
                else:
                    que.pop()

        if answer != -1:
            if cnt % 2 == 0:
                answer = list(que)
            else:
                answer = list(que)[::-1]

        if answer == -1:
            answer = "error"
        else:
            answer = "[" + ",".join(answer) + "]"

        result.append(answer)

    for i in result:
        print(i)


main()
