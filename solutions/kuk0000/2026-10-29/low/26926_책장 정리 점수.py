T = int(input())

for tc in range(1,T+1):
  N = int(input())
  books = list(map(int,input().split()))
  max_grade = -float('inf')
  # 현재 위치보다 오른쪽에 책 정리 점수가 낮은 것 탐색
  for i in range(N-1):
    cnt = 0
    for j in range(i+1,N):
      if books[i] > books[j]:
        cnt += 1
    max_grade = max(max_grade, cnt)

  print(f'#{tc} {max_grade}')
