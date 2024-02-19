import sys
from collections import Counter

input = sys.stdin.readline


N, taesu, P = map(int, input().split())
scores = list(map(int, input().split())) + [taesu]
counter = Counter(scores)

scores = sorted(list(set(scores)), reverse=True)

grade = 0
for score in scores:
    if grade + counter[score] > P:
        print(-1)
        break
    elif score == taesu:
        print(grade + 1)
        break

    grade += counter[score]