import sys

input = sys.stdin.readline


while True:
    N, A, B = map(int, input().split())

    if (N, A, B) == (0, 0, 0):
        break

    array = sorted([list(map(int, input().split())) for _ in range(N)], key=lambda x: -abs(x[1] - x[2]))  # fmt: skip

    answer = 0
    for balloons, distA, distB in array:
        if distA <= distB:
            cost = min(balloons, A)

        else:
            cost = balloons - min(balloons, B)

        answer += distA * cost + distB * (balloons - cost)

        A -= cost
        B -= balloons - cost

    print(answer)