import sys

input = sys.stdin.readline

directions = {"E": 0, "S": 1, "W": 2, "N": 3}

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    a, b = map(int, input().split())
    n, m = map(int, input().split())
    robots = [list(input().split()) for _ in range(n)]
    orders = [list(input().split()) for _ in range(m)]

    matrix = [[0] * a for _ in range(b)]

    for idx in range(len(robots)):
        x, y, d = robots[idx]
        y = b - int(y)
        x = int(x) - 1
        robots[idx] = [y, x, directions[d]]
        matrix[y][x] = idx + 1

    for order in orders:
        r, w, t = order
        r = int(r)
        t = int(t)
        y, x, d = robots[r - 1]
        matrix[y][x] = 0

        if w == "L":
            d = (d - t) % 4
        elif w == "R":
            d = (d + t) % 4
        elif w == "F":
            for _ in range(t):
                y += dy[d]
                x += dx[d]
                if not (0 <= y < b and 0 <= x < a):
                    print(f"Robot {r} crashes into the wall")
                    sys.exit(0)
                elif matrix[y][x] != 0:
                    print(f"Robot {r} crashes into robot {matrix[y][x]}")
                    sys.exit(0)

        matrix[y][x] = r
        robots[r - 1] = [y, x, d]

    print("OK")


main()
