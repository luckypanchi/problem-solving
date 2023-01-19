import sys

input = sys.stdin.readline


tc = int(input())

answers = []

for _ in range(tc):
    arr = list(map(int, input().split()))
    avg = sum(arr[1:]) / arr[0]
    cnt = 0
    for num in arr[1:]:
        if num > avg:
            cnt += 1
    answers.append("%.3f" % (100 * cnt / arr[0]))

for a in answers:
    print(a + "%")
