import sys

input = sys.stdin.readline

dx = (1, 1, 0, -1, -1, -1, 0, 1)
dy = (0, -1, -1, -1, 0, 1, 1, 1)


def main():
    n, m, k = map(int, input().split())
    a = [list(map(int, input().split())) for _ in range(n)]
    temp = [list(map(int, input().split())) for _ in range(m)]
    trees = [[[] for _ in range(n)] for _ in range(n)]

    for x, y, z in temp:
        trees[x - 1][y - 1].append(z)

    matrix = [[5] * n for _ in range(n)]

    def go():
        nonlocal matrix, trees

        for i in range(n):
            for j in range(n):
                if trees[i][j]:
                    trees[i][j].sort()
                    tmp_alive = []
                    death = 0
                    for age in trees[i][j]:
                        if matrix[i][j] - age < 0:
                            death += age // 2
                        else:
                            matrix[i][j] -= age
                            tmp_alive.append(age + 1)
                    matrix[i][j] += death
                    trees[i][j].clear()
                    trees[i][j].extend(tmp_alive)

        for i in range(n):
            for j in range(n):
                if trees[i][j]:
                    for age in trees[i][j]:
                        if age % 5 == 0:
                            for k in range(8):
                                ni = i + dy[k]
                                nj = j + dx[k]
                                if 0 <= ni < n and 0 <= nj < n:
                                    trees[ni][nj].append(1)

        for i in range(n):
            for j in range(n):
                matrix[i][j] += a[i][j]

    for _ in range(k):
        go()

    answer = 0

    for i in range(n):
        for j in range(n):
            answer += len(trees[i][j])

    print(answer)


main()
