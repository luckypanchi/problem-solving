percentages = [10, 20, 30, 40]
max_plus_users = 0
max_benefit = 0


def solve(users, emoticons, idx, prev_costs):
    global max_plus_users, max_benefit

    if idx == len(emoticons):
        plus_users = 0
        benefit = 0
        for i in range(len(users)):
            _, user_pivot = users[i]
            if user_pivot <= prev_costs[i]:
                plus_users += 1
            else:
                benefit += prev_costs[i]

        if max_plus_users < plus_users:
            max_plus_users = plus_users
            max_benefit = benefit
        elif max_plus_users == plus_users and max_benefit < benefit:
            max_benefit = benefit

        return

    emoticon = emoticons[idx]

    for percent in percentages:
        costs = prev_costs[:]
        for i in range(len(users)):
            user_percent, _ = users[i]
            if user_percent <= percent:
                costs[i] += emoticon * (100 - percent) // 100
        solve(users, emoticons, idx + 1, costs)


def solution(users, emoticons):
    solve(users, emoticons, 0, [0] * len(users))
    return [max_plus_users, max_benefit]
