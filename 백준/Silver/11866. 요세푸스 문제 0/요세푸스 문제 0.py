import sys

input = sys.stdin.readline


def main():
    n, m = map(int, input().split())

    flag = [False] * n
    answer = []
    total = n
    idx = -1
    cnt = 0

    while total:
        idx += 1
        idx = idx % n

        if flag[idx]:
            continue

        cnt += 1

        if cnt == m:
            flag[idx] = True
            answer.append(idx + 1)
            cnt = 0
            total -= 1

    print("<", end="")
    print(*answer, sep=", ", end="")
    print(">", end="")


main()
