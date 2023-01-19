import sys

input = sys.stdin.readline


def main():
    n = int(input())
    roads = list(map(int, input().split()))
    costs = list(map(int, input().split()))

    answer = 0
    current = costs[0]

    for i in range(n - 1):
        current = min(current, costs[i])
        answer += roads[i] * current

    print(answer)


main()
