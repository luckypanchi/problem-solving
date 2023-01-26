import sys

input = sys.stdin.readline


def solve(flags, prev, curr_idx):
    if curr_idx == n:
        answers.append(flags)
        return True

    flag = False

    if not flag and prev < strings[curr_idx]:
        flag = solve(flags + "0", strings[curr_idx], curr_idx + 1)
    if not flag and prev < strings[curr_idx][::-1]:
        flag = solve(flags + "1", strings[curr_idx][::-1], curr_idx + 1)

    return flag


answers = []
tc = int(input())
for _ in range(tc):
    n = int(input())
    strings = [input().strip() for _ in range(n)]
    if not solve("0", strings[0], 1):
        solve("1", strings[0][::-1], 1)

for answer in answers:
    print(answer)