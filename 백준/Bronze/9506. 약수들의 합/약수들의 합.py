import sys

input = sys.stdin.readline


while True:
    n = int(input())
    if n == -1:
        break

    res = [1]
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            res.append(i)
            if i != n // i:
                res.append(n // i)

    if sum(res) == n:
        res.sort()
        print(f"{n} = ", end="")
        print(" + ".join(map(str, res)))
    else:
        print(f"{n} is NOT perfect.")