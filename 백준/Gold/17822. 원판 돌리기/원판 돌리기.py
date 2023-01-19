import sys

input = sys.stdin.readline


def pArr(arr):
    for i in arr:
        print(i)


def main():
    n, m, t = map(int, input().split())
    plates = [list(map(int, input().split())) for _ in range(n)]
    ops = [list(map(int, input().split())) for _ in range(t)]

    for op in ops:
        op[2] = op[2] % m

    head = [0] * n

    for op in ops:
        x, d, k = op
        for idx in range(n):
            if (idx + 1) % x == 0:
                head[idx] = (head[idx] + k * (2 * d - 1)) % m
        targets = set()
        for idx in range(n):
            for i in range(m - 1):
                if plates[idx][i] != 0 and plates[idx][i] == plates[idx][i + 1]:
                    targets.add((idx, i))
                    targets.add((idx, i + 1))
            if plates[idx][m - 1] != 0 and plates[idx][m - 1] == plates[idx][0]:
                targets.add((idx, m - 1))
                targets.add((idx, 0))
        for move in range(m):
            current = list(map(lambda x: (x + move) % m, head))
            for idx in range(n - 1):
                if (
                    plates[idx][current[idx]] != 0
                    and plates[idx][current[idx]] == plates[idx + 1][current[idx + 1]]
                ):
                    targets.add((idx, current[idx]))
                    targets.add((idx + 1, current[idx + 1]))
        if len(targets) == 0:
            tmp = 0
            cnt = 0
            for i in range(n):
                for j in range(m):
                    if plates[i][j] != 0:
                        tmp += plates[i][j]
                        cnt += 1
            if cnt == 0:
                break
            avg = tmp / cnt
            for i in range(n):
                for j in range(m):
                    if plates[i][j] != 0:
                        if plates[i][j] < avg:
                            plates[i][j] += 1
                        elif plates[i][j] > avg:
                            plates[i][j] -= 1
        else:
            for (i, j) in targets:
                plates[i][j] = 0

    answer = 0
    for plate in plates:
        answer += sum(plate)

    print(answer)


main()
