import sys

input = sys.stdin.readline


def main():
    t = int(input())
    cogs = [input().strip() for _ in range(t)]
    headers = [0] * t
    k = int(input())

    for _ in range(k):
        num, d = map(int, input().split())
        candidates = [(num - 1, d)]

        idx, direct = num - 1, d
        while 1 <= idx:
            if (
                cogs[idx - 1][(headers[idx - 1] + 2) % 8]
                == cogs[idx][(headers[idx] - 2) % 8]
            ):
                break
            else:
                direct *= -1
                idx -= 1
                candidates.append((idx, direct))

        idx, direct = num - 1, d
        while idx < t - 1:
            if (
                cogs[idx][(headers[idx] + 2) % 8]
                == cogs[idx + 1][(headers[idx + 1] - 2) % 8]
            ):
                break
            else:
                direct *= -1
                idx += 1
                candidates.append((idx, direct))

        for idx, direct in candidates:
            headers[idx] = (headers[idx] - direct) % 8

    answer = 0
    for i in range(t):
        if cogs[i][headers[i]] == "1":
            answer += 1

    print(answer)


main()
