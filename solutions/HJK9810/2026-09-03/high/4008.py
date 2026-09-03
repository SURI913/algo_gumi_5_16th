OPER = ['+', '-', '*', '/']

def calc(first, second, order):
    if order == '+':
        return first + second
    elif order == '-':
        return first - second
    elif order == '*':
        return first * second
    elif order == '/':
        return int(first / second)

def initial_code(nums, cases):
    oper_size = sum(cases)
    min_result = float('inf')
    max_result = min_result * -1

    def dfs(idx, total, order):
        nonlocal max_result
        nonlocal min_result

        if order == 0:
            max_result = max(total, max_result)
            min_result = min(total, min_result)
        else:
            for op in range(len(cases)):
                if cases[op]:
                    cases[op] -= 1
                    next_total = calc(total, nums[idx], OPER[op])
                    dfs(idx + 1, next_total, order - 1)
                    cases[op] += 1

    dfs(1, nums[0], oper_size)
    return max_result, min_result

def algorithm():
    N = int(input())
    cases = list(map(int, input().split()))
    numbers = list(map(int, input().split()))
    max_result, min_result = initial_code(numbers, cases)

    return max_result - min_result

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f'#{test_case} {algorithm()}')
