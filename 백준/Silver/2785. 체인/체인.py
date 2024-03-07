import sys

input = sys.stdin.readline


n = int(input())
chains = sorted(list(map(int, input().split())))

answer = 0
for chain in chains:
    if chain == n - 2:
        answer += chain
        break
    elif chain > n - 2:
        answer += n - 1
        break
    else:
        n -= chain + 1
        answer += chain

print(answer)