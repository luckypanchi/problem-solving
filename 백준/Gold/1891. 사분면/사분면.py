import sys

input = sys.stdin.readline


def getPoint(arr, idx, r, c, size):
    if size == 1:
        return (r, c)
    else:
        m = size // 2
        if arr[idx] == "1":
            return getPoint(arr, idx + 1, r, c + m, m)
        elif arr[idx] == "2":
            return getPoint(arr, idx + 1, r, c, m)
        elif arr[idx] == "3":
            return getPoint(arr, idx + 1, r + m, c, m)
        elif arr[idx] == "4":
            return getPoint(arr, idx + 1, r + m, c + m, m)


def getAnswer(r, c, x, y, size):
    if size == 1:
        return ""

    m = size // 2
    if x >= c + m and y < r + m:
        return "1" + getAnswer(r, c + m, x, y, m)
    elif x < c + m and y < r + m:
        return "2" + getAnswer(r, c, x, y, m)
    elif x < c + m and y >= r + m:
        return "3" + getAnswer(r + m, c, x, y, m)
    elif x >= c + m and y >= r + m:
        return "4" + getAnswer(r + m, c + m, x, y, m)


def main():
    d, start = input().split()
    dx, dy = map(int, input().split())
    dy = -dy
    n = 2 ** int(d)
    y, x = getPoint(start, 0, 0, 0, n)
    x += dx
    y += dy

    if 0 <= x < n and 0 <= y < n:
        print(getAnswer(0, 0, x, y, n))
    else:
        print(-1)


main()
