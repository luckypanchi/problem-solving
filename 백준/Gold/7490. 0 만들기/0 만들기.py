import sys

input = sys.stdin.readline


def main():
    t = int(input())

    def solve(num, dest, result):
        if num == dest:
            if eval(result.replace(" ", "")) == 0:
                print(result)
            return

        solve(num + 1, dest, f"{result} {num+1}")
        solve(num + 1, dest, f"{result}+{num+1}")
        solve(num + 1, dest, f"{result}-{num+1}")

    for _ in range(t):
        n = int(input())

        solve(1, n, "1")
        print()


main()
