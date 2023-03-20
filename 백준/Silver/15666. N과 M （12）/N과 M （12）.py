import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split())))
answers = set()


def solve(prev, p, length):
    if length == m:
        answers.add(tuple(prev))
        return 
    
    for i in range(p, n):
        solve(prev + [numbers[i]], i, length + 1)


solve([], 0, 0)
answers = sorted(list(answers))

for answer in answers:
    print(*answer)