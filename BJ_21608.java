import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_21608 {

    static int N;
    static int seat[][];
    static int orderHistory[][];
    static int likelyFriends[][];
    static List<Point> dummyPoints;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        init();
        for (int i = 0; i < N * N; i++) {
            List<Point> seatCandidates = selectMostBlank(selectFavoriteSeats(i));
            seatCandidates.sort(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
            });
            Point point = seatCandidates.get(0);
            seat[point.x][point.y] = likelyFriends[i][0];
            orderHistory[point.x][point.y] = i;
        }


        System.out.println(getScore());
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seat = new int[N + 1][N + 1];
        orderHistory = new int[N + 1][N + 1];
        likelyFriends = new int[N * N][5];
        dummyPoints = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dummyPoints.add(new Point(i, j));
            }
        }

        for (int i = 0; i < N * N; i++) {
            String input = br.readLine();
            String students[] = input.split(" ");

            for (int j = 0; j <= 4; j++) {
                int studentNo = Integer.parseInt(students[j]);
                likelyFriends[i][j] = studentNo;
            }
        }
    }

    public static List<Point> selectFavoriteSeats(int order) {
        int maxCount = 0;
        List<Point> seatPoints = new ArrayList<>();
        //좌표 이동
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (seat[i][j] != 0) {
                    continue;
                }
                int count = 0;
                //4방향 인접 탐색
                for (int k = 0; k < 4; k++) {
                    int targetX = i + dx[k];
                    int targetY = j + dy[k];

                    if (isValid(targetX, targetY) && seat[targetX][targetY] != 0) {
                        for (int l = 1; l <= 4; l++) {
                            if (likelyFriends[order][l] == seat[targetX][targetY]) {
                                count++;
                                break;
                            }
                        }
                    }
                }

                if (maxCount != 0 && count == maxCount) {
                    seatPoints.add(new Point(i, j));
                } else if (maxCount < count) {
                    maxCount = count;
                    seatPoints.clear();
                    seatPoints.add(new Point(i, j));
                }
            }
        }
        if(seatPoints.size() == 0) {
            return dummyPoints.stream()
                    .filter(point -> seat[point.x][point.y] == 0)
                    .collect(Collectors.toList());
        }
        return seatPoints;
    }

    public static List<Point> selectMostBlank(List<Point> beforeSeats) {
        int maxCount = 0;
        List<Point> seatPoints = new ArrayList<>(beforeSeats);

        for (Point beforeSeat : beforeSeats) {
            int x = beforeSeat.x;
            int y = beforeSeat.y;
            int count = 0;

            for (int i = 0; i < 4; i++) {
                int targetX = x + dx[i];
                int targetY = y + dy[i];

                if (isValid(targetX, targetY) && seat[targetX][targetY] == 0) {
                    count++;
                }
            }

            if (maxCount != 0 && maxCount == count) {
                seatPoints.add(beforeSeat);
            } else if (maxCount < count) {
                maxCount = count;
                seatPoints.clear();
                seatPoints.add(beforeSeat);
            }
        }

        return seatPoints;
    }

    public static int getScore() {
        int score = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int order = orderHistory[i][j];
                List<Integer> friendList = new ArrayList<>();

                for(int k = 0; k < 4; k++) {
                    int targetX = i + dx[k];
                    int targetY = j + dy[k];

                    if(isValid(targetX, targetY)) {
                        friendList.add(seat[targetX][targetY]);
                    }
                }

                int count = 0;
                for(int l = 1; l <= 4; l++) {
                    if (friendList.contains(likelyFriends[order][l])) {
                        count++;
                    }
                }

                switch (count) {
                    case 1 : score += 1; break;
                    case 2 : score += 10; break;
                    case 3 : score += 100; break;
                    case 4 : score += 1000; break;
                }
            }
        }

        return score;
    }

    public static boolean isValid(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}