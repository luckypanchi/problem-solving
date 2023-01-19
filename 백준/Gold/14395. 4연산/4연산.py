import sys
from collections import deque

input = sys.stdin.readline

limit = 1000000000


def main():
    start, dest = map(int, input().split())

    answers = []
    visited = []

    if start == dest:
        print(0)
        return

    def bfs(start, string):
        que = deque()
        que.append((start, string))
        while que:
            num, record = que.popleft()
            visited.append(num)
            if num == dest:
                answers.append(record)
                continue
            if 2 * num <= limit and 2 * num not in visited:
                que.append((num + num, record + "+"))
            if 0 not in visited:
                que.append((0, record + "-"))
            if num * num <= limit and num * num not in visited:
                que.append((num * num, record + "*"))
            if num != 0 and 1 not in visited:
                que.append((1, record + "/"))

    bfs(start, "")

    if len(answers) == 0:
        answer = -1
    elif len(answers) == 1:
        answer = answers[0]
    else:
        length = len(answers[0])
        for i in range(length - 1, -1, -1):
            answers.sort(key=lambda x: x[i])
        for i in answers:
            if len(i) == length:
                answer = i
                break

    print(answer)


main()
