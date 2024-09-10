import sys
from collections import deque

input = sys.stdin.readline

LIMIT = 5000000


def get_prime_sieve():
    sieve = [True] * (n + 1)
    sieve[1] = False

    for i in range(2, int(n**0.5) + 1):
        if sieve[i]:
            for j in range(i * i, n + 1, i):
                sieve[j] = False

    return sieve


n = int(input())

prime_sieve = get_prime_sieve()
dq = deque()
is_back = True

for curr in range(1, n + 1):
    if not prime_sieve[curr]:
        if is_back:
            dq.append("B")
        else:
            dq.appendleft("B")
    elif is_back and dq[-1] == "B":
        dq.pop()
        dq.append("S")
        dq.append("S")
        is_back = not is_back
    elif not is_back and dq[0] == "B":
        dq.popleft()
        dq.appendleft("S")
        dq.appendleft("S")
        is_back = not is_back
    elif is_back:
        dq.append("S")
        is_back = not is_back
    else:
        dq.appendleft("S")
        is_back = not is_back


b_count, s_count = 0, 0
while dq:
    curr = dq.pop()
    if curr == "B":
        b_count += 1
    else:
        s_count += 1

print(b_count, s_count)