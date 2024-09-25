import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
m = int(input())
recommends = list(map(int, input().split()))

recommend_count = [0] * 101
updated = [0] * 101
is_selected = [False] * 101

select_count = 0

for i in range(m):
    curr = recommends[i]

    if is_selected[curr]:
        recommend_count[curr] += 1

    elif select_count < n:
        select_count += 1
        is_selected[curr] = True
        recommend_count[curr] += 1
        updated[curr] = i

    else:
        remove_target = -1
        target_recommend_count = INF
        target_updated = INF
        for t in range(1, 101):
            if is_selected[t]:
                if recommend_count[t] < target_recommend_count or (
                    recommend_count[t] == target_recommend_count and updated[t] < target_updated
                ):
                    remove_target = t
                    target_recommend_count = recommend_count[t]
                    target_updated = updated[t]

        is_selected[remove_target] = False
        recommend_count[remove_target] = 0

        is_selected[curr] = True
        recommend_count[curr] += 1
        updated[curr] = i


for t in range(1, 101):
    if is_selected[t]:
        print(t, end=" ")