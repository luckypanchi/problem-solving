import sys

input = sys.stdin.readline


def main():
    cogs = [list(map(int, input().strip())) for _ in range(4)]
    k = int(input())
    rolls = [list(map(int, input().split())) for _ in range(k)]

    for i in range(k):
        rolls[i][0] -= 1

    index = [[2, 6] for _ in range(4)]

    def go(arr):
        nonlocal index
        cog, d = arr

        if d == 1:
            index[cog][0] = (index[cog][0] - 1) % 8
            index[cog][1] = (index[cog][1] - 1) % 8
        else:
            index[cog][0] = (index[cog][0] + 1) % 8
            index[cog][1] = (index[cog][1] + 1) % 8

    for roll in rolls:
        start, direction = roll

        tmp = [(start, direction)]
        d = direction

        for idx in range(start, 3):
            if cogs[idx][index[idx][0]] != cogs[idx + 1][index[idx + 1][1]]:
                d = d * (-1)
                tmp.append((idx + 1, d))
            else:
                break

        d = direction
        for idx in range(start, 0, -1):
            if cogs[idx][index[idx][1]] != cogs[idx - 1][index[idx - 1][0]]:
                d = d * (-1)
                tmp.append((idx - 1, d))
            else:
                break

        for item in tmp:
            go(item)

    answer = 0
    v = 1

    for idx in range(4):
        head_idx = (index[idx][0] - 2) % 8
        if cogs[idx][head_idx] == 1:
            answer += v
        v *= 2

    print(answer)


main()
