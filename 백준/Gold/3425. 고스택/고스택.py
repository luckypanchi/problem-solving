import sys

input = sys.stdin.readline


def go(commands, num):
    stack = [num]

    for command in commands:
        cmd = command.split()

        if cmd[0] == "NUM":
            stack.append(int(cmd[1]))
        elif cmd[0] == "POP":
            if len(stack) < 1:
                return "ERROR"
            stack.pop()
        elif cmd[0] == "INV":
            if len(stack) < 1:
                return "ERROR"
            tmp = stack.pop()
            stack.append((-1) * tmp)
        elif cmd[0] == "DUP":
            if len(stack) < 1:
                return "ERROR"
            stack.append(stack[-1])
        elif cmd[0] == "SWP":
            if len(stack) < 2:
                return "ERROR"
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            stack.append(tmp1)
            stack.append(tmp2)
        elif cmd[0] == "ADD":
            if len(stack) < 2:
                return "ERROR"
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            result = tmp1 + tmp2
            if abs(result) > 10**9:
                return "ERROR"
            stack.append(result)
        elif cmd[0] == "SUB":
            if len(stack) < 2:
                return "ERROR"
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            result = tmp2 - tmp1
            if abs(result) > 10**9:
                return "ERROR"
            stack.append(result)
        elif cmd[0] == "MUL":
            if len(stack) < 2:
                return "ERROR"
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            result = tmp1 * tmp2
            if abs(result) > 10**9:
                return "ERROR"
            stack.append(result)
        elif cmd[0] == "DIV":
            if len(stack) < 2:
                return "ERROR"
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            if tmp1 == 0:
                return "ERROR"
            tmp = abs(tmp2) // abs(tmp1)
            if tmp1 * tmp2 < 0:
                tmp = (-1) * tmp
            stack.append(tmp)
        elif cmd[0] == "MOD":
            if len(stack) < 2:
                return "ERROR"
            tmp1 = stack.pop()
            tmp2 = stack.pop()
            if tmp1 == 0:
                return "ERROR"
            tmp = abs(tmp2) % abs(tmp1)
            if tmp2 < 0:
                tmp = (-1) * tmp
            stack.append(tmp)

    if len(stack) != 1:
        return "ERROR"
    else:
        return stack[0]


answer = []


while True:
    cmd = input()[:-1]

    if cmd == "QUIT":
        break

    if cmd == "":
        continue

    commands = []

    while cmd != "END":
        commands.append(cmd)
        cmd = input()[:-1]

    n = int(input())
    numbers = [int(input()) for _ in range(n)]

    for num in numbers:
        print(go(commands, num))

    print()
