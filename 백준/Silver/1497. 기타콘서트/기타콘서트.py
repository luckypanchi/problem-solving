import sys

input = sys.stdin.readline


def solve(curr, currFlag, count):
    if curr == n:
        c = str(bin(currFlag)[2:]).count("1")
        return (c, count)

    results = []
    results.append(solve(curr + 1, currFlag, count))

    _, flag = guitars[curr]
    for i in range(m):
        if flag[i] == "Y":
            currFlag |= 1 << i

    results.append(solve(curr + 1, currFlag, count + 1))

    results.sort(key=lambda x: (-x[0], x[1]))
    return results[0]


n, m = map(int, input().split())
guitars = [list(input().split()) for _ in range(n)]

answer = solve(0, 0, 0)

if answer[0] == 0:
    print(-1)
else:
    print(answer[1])