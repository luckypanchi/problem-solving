import sys

input = sys.stdin.readline

dx = (1, -1, 0, 0)
dy = (0, 0, -1, 1)


def main():
    n, k = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    horses = [list(map(lambda x: int(x) - 1, input().split())) for _ in range(k)]
    maps = [[[] for _ in range(n)] for _ in range(n)]

    for idx in range(k):
        y, x, d = horses[idx]
        maps[y][x].append(idx)

    def check(point):
        y, x = point
        if 0 <= y < n and 0 <= x < n and matrix[y][x] != 2:
            return True
        else:
            return False

    def go(matrix, horses, maps):
        cnt = 0
        while cnt < 1000:
            cnt += 1
            for i in range(k):
                y, x, d = horses[i]
                ny = y + dy[d]
                nx = x + dx[d]
                if not check((ny, nx)):
                    d ^= 1
                    ny = y + dy[d]
                    nx = x + dx[d]
                    horses[i][2] = d
                    if not check((ny, nx)):
                        continue
                idx = maps[y][x].index(i)
                for j in maps[y][x][idx:]:
                    horses[j][0] = ny
                    horses[j][1] = nx
                if matrix[ny][nx] == 0:
                    maps[ny][nx] += maps[y][x][idx:]
                elif matrix[ny][nx] == 1:
                    maps[ny][nx] += maps[y][x][idx:][::-1]
                del maps[y][x][idx:]
                if len(maps[ny][nx]) > 3:
                    return cnt
        return -1

    print(go(matrix, horses, maps))


main()
