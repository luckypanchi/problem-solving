import sys

input = sys.stdin.readline


n, k = map(int, input().split())
order = list(map(int, input().split()))

plugs = []
answer = 0

for idx, item in enumerate(order):
    if item in plugs:
        continue

    elif len(plugs) < n:
        plugs.append(item)

    else:
        max_idx = 0
        target = None
        for p in plugs:
            if p not in order[idx:]:
                target = p
                break
            elif order[idx:].index(p) > max_idx:
                max_idx = order[idx:].index(p)
                target = p
        plugs[plugs.index(target)] = item
        answer += 1

print(answer)
