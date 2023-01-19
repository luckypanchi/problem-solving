import sys

input = sys.stdin.readline


n = int(input())
history = dict()

for _ in range(n):
    name, status = input().strip().split()
    if status == "enter":
        history[name] = True
    elif status == "leave":
        history[name] = False

results = []

for name, status in history.items():
    if status:
        results.append(name)

results.sort(reverse=True)

for name in results:
    print(name)
