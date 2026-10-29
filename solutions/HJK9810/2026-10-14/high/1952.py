MONTH_SIZE = 12

def use_dfs(months, pays):
    min_result = float('inf')
    stack = []

    stack.append((0, 0))

    while stack:
        month, total = stack.pop()

        if month >= MONTH_SIZE:
            min_result = min(min_result, total)
            continue

        if months[month] == 0:
            stack.append((month + 1, total))
            continue

        stack.append((month + 1, total + pays[0] * months[month]))
        stack.append((month + 1, total + pays[1]))
        stack.append((month + 3, total + pays[2]))

    return min_result

def algorithm():
    pays = list(map(int, input().split()))
    months = list(map(int, input().split()))

    year_result = pays[-1]
    dfs_result = use_dfs(months, pays)

    return min(year_result, dfs_result)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
