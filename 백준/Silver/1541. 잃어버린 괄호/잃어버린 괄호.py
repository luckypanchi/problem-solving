import sys

input = sys.stdin.readline


def main():
    expression = input().strip()
    op = []
    numbers = []

    for i in range(len(expression)):
        if expression[i] == "+" or expression[i] == "-":
            op.append(i)

    if not op:
        print(int(expression))
        return

    numbers.append(int(expression[: op[0]]))

    for i in range(len(op) - 1):
        numbers.append(int(expression[op[i] : op[i + 1]]))

    numbers.append(int(expression[op[-1] :]))

    for i in range(len(numbers) - 1):
        if numbers[i] < 0 and numbers[i + 1] > 0:
            numbers[i + 1] *= -1
        if i != 0 and numbers[i] == 0:
            if numbers[i - 1] < 0 and numbers[i + 1] > 0:
                numbers[i + 1] *= -1

    print(sum(numbers))


main()
