import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    n = int(input())
    matrix = [[0] * n for _ in range(n)]
    students = [list(map(int, input().split())) for _ in range(n**2)]
    position = []

    for idx in range(n**2):
        candidates = []
        for y in range(n):
            for x in range(n):
                if matrix[y][x] == 0:
                    fav_cnt = 0
                    blank_cnt = 0
                    for i in range(4):
                        nx = x + dx[i]
                        ny = y + dy[i]
                        if 0 <= nx < n and 0 <= ny < n:
                            if matrix[ny][nx] in students[idx][1:]:
                                fav_cnt += 1
                            elif matrix[ny][nx] == 0:
                                blank_cnt += 1
                    candidates.append((fav_cnt, blank_cnt, y, x))
        candidates.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))
        _, _, y, x = candidates[0]
        matrix[y][x] = students[idx][0]
        position.append((y, x))

    answer = 0

    for idx in range(n**2):
        y, x = position[idx]
        cnt = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if matrix[ny][nx] in students[idx][1:]:
                    cnt += 1
        if cnt != 0:
            answer += 10 ** (cnt - 1)

    print(answer)


main()
