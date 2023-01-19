import sys

input = sys.stdin.readline


def main():
    n = int(input())
    balls = []

    for idx in range(n):
        color, size = map(int, input().split())
        balls.append([color, size, idx])

    total = 0
    balls.sort(key=lambda x: x[1])
    colors = [0] * (n + 1)
    points = [0] * n

    j = 0
    for i in range(n):
        a = balls[i]
        b = balls[j]

        while b[1] < a[1]:
            total += b[1]
            colors[b[0]] += b[1]
            j += 1
            b = balls[j]

        points[a[2]] = total - colors[a[0]]

    for p in points:
        print(p)


main()
