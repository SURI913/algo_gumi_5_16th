def calc_sum(boards, row, col, N):
    total = 0

    for idx in range(N):
        total += boards[row][idx]
        total += boards[idx][col]

    return total - boards[row][col]

def algorithm():
    N = int(input())
    boards = [list(map(int, input().split())) for _ in range(N)]

    max_score = 0
    for row in range(N):
        for col in range(N):
            score = calc_sum(boards, row, col, N)
            max_score = max(max_score, score)

    return max_score

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
