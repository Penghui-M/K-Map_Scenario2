import java.util.Scanner;

public class KarnaughMap {

    private int NumR;
    private int NumC;

    private int[][] map;

    public KarnaughMap(int[][] map) {
        this.map = map;
        NumR = map.length;
        NumC = map[0].length;
    }
    public int[][][] Group() {
        int numberof1 = Count1(map);
        int n = (int) (Math.log(numberof1) / Math.log(2)) + 2;
        int maxn = n;
        int numberofgroups = 0;
        int[][][] group = new int[10][NumR][NumC];
        boolean flag = true;
        for (int i = 0; i < NumR; i++) {
            for (int j = 0; j < NumC; j++) {
                for (int k = 0; k < 10; k++) {
                    group[k][i][j] = 0;

                }

            }
        }

        while (n > 0) {
            for (int i = 0; i < NumR; i++) {
                for (int j = 0; j < NumC; j++) {
                    if (this.ifalone(group, i, j, maxn) && map[i][j] == 1) {
                        //check 1X1
                        if (n == 1) {
                            group[numberofgroups][i][j] = 1;
                            numberofgroups++;
                        }
                        //check 2X1
                        else if (n == 2) {
                            for (int k = 0; k < 4; k++) {
                                if (k == 0) {
                                    if (map[i][(j + 1) % NumC] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][i][(j + 1) % NumC] = 1;
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 1) {
                                    if (map[(i + 1) % NumR][j] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][(i + 1) % NumR][j] = 1;
                                        numberofgroups++;
                                    }

                                } else if (k == 2) {
                                    if (map[i][(NumC + j - 1) % NumC] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][i][(NumC + j - 1) % NumC] = 1;
                                        numberofgroups++;
                                    }

                                } else {
                                    if (map[(NumR + i - 1) % NumR][j] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][(NumR + i - 1) % NumR][j] = 1;
                                        numberofgroups++;
                                    }
                                }
                            }
                        }
                        //check 2X2
                        else if (n == 3) {
                            for (int k = 0; k < 4; k++) {
                                if (k == 0) {
                                    if (map[(i + 1) % NumR][j] == 1 && map[i][(j + 1) % NumC] == 1 && map[(i + 1) % NumR][(j + 1) % NumC] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][(i + 1) % 4][j] = 1;
                                        group[numberofgroups][(i + 1) % 4][(j + 1) % 4] = 1;
                                        group[numberofgroups][i][(j + 1) % 4] = 1;
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 1) {
                                    if (map[(i + 1) % NumR][j] == 1 && map[i][(NumC + j - 1) % NumC] == 1 && map[(i + 1) % NumR][(NumC + j - 1) % NumC] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][(i + 1) % NumR][j] = 1;
                                        group[numberofgroups][(i + 1) % NumR][(NumC + j - 1) % NumC] = 1;
                                        group[numberofgroups][i][(NumC + j - 1) % NumC] = 1;
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 2) {
                                    if (map[(NumR + i - 1) % NumR][j] == 1 && map[i][(NumC + j - 1) % NumC] == 1 && map[(NumR + i - 1) % NumR][(NumC + j - 1) % NumC] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][(NumR + i - 1) % NumR][j] = 1;
                                        group[numberofgroups][(NumR + i - 1) % NumR][(NumC + j - 1) % NumC] = 1;
                                        group[numberofgroups][i][(NumC + j - 1) % NumC] = 1;
                                        numberofgroups++;
                                        break;
                                    }

                                } else {
                                    if (map[(NumR + i - 1) % NumR][j] == 1 && map[i][(j + 1) % NumC] == 1 && map[(NumR + i - 1) % NumR][(j + 1) % NumC] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][(NumR + i - 1) % NumR][j] = 1;
                                        group[numberofgroups][(NumR + i - 1) % NumR][(NumC + j + 1) % NumC] = 1;
                                        group[numberofgroups][i][(j + 1) % NumC] = 1;
                                        numberofgroups++;
                                        break;
                                    }
                                }
                            }
                        }
                        //check 1X4
                        else if (n == 4) {
                            for (int k = 0; k < 4; k++) {
                                if (k == 0) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[i][(j + a) % NumC] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][i][(j + a) % NumC] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 1) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[(i + a) % NumR][j] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][(i + a) % NumR][j] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 2) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[i][(NumC + j - a) % NumC] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][i][(NumC + j - a) % NumC] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[(NumR + i - a) % NumR][j] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][(NumR + i - a) % NumR][j] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                }
                            }
                        }//check 2X4
                        else if (n == 5) {
                            for (int k = 0; k < 8; k++) {
                                if (k == 0) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[i][(j + a) % NumC] != 1 || map[(i + 1) % NumR][(j + a) % NumC] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][i][(j + a) % NumC] = 1;
                                            group[numberofgroups][(i + 1) % NumR][(j + a) % NumC] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 1) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[i][(j + a) % NumC] != 1 || map[(NumR +i - 1) % NumR][(j + a) % NumC] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][i][(j + a) % NumC] = 1;
                                            group[numberofgroups][(NumR + i - 1) % NumR][(j + a) % NumC] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 2) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[(i + a) % NumR][(j + 1) % NumC] != 1 || map[(i + a) % NumR][j] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][(i + a) % NumR][(j + 1) % NumC] = 1;
                                            group[numberofgroups][(i + a) % NumR][j] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 3) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[(i + a) % NumR][(NumC + j - 1) % NumC] != 1 || map[(i + a) % NumR][j] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][(i + a) % NumR][(NumC + j - 1) % NumC] = 1;
                                            group[numberofgroups][(i + a) % NumR][j] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                }
                                if (k == 4) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[i][(NumC + j - a) % NumC] != 1 || map[(i + 1) % NumR][(NumC + j - a) % NumC] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][i][(NumC + j - a) % NumC] = 1;
                                            group[numberofgroups][(i + 1) % NumR][(NumC + j - a) % NumC] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 5) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[i][(NumC + j - a) % NumC] != 1 || map[(NumR + i - 1) % NumR][(j + a) % NumC] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][i][(NumC + j - a) % NumC] = 1;
                                            group[numberofgroups][(NumR + i - 1) % NumR][(NumC + j - a) % NumC] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 6) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[(NumR + i - a) % NumR][(j + 1) % NumC] != 1 || map[(NumR + i - a) % NumR][j] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][(NumR + i - a) % NumR][(j + 1) % NumC] = 1;
                                            group[numberofgroups][(NumR + i - a) % NumR][j] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                } else if (k == 7) {
                                    flag = true;
                                    for (int a = 0; a < 4; a++) {
                                        if (map[(NumR + i - a) % NumR][(NumC + j - 1) % NumC] != 1 || map[(NumR + i - a) % NumR][j] != 1) {
                                            flag = false;
                                        }
                                    }
                                    if (flag) {
                                        group[numberofgroups][i][j] = 1;
                                        for (int a = 0; a < 4; a++) {
                                            group[numberofgroups][(NumR + i - a) % NumR][(NumC + j - 1) % NumC] = 1;
                                            group[numberofgroups][(NumR + i - a) % NumR][j] = 1;
                                        }
                                        numberofgroups++;
                                        break;
                                    }
                                }

                            }
                        }
                        //check 4X4
                        else if (n == 6) {
                            flag = true;
                            for (int a = 0; a < 4; a++) {
                                for (int b = 0; b < 4; b++) {
                                    if (map[a][b] == 0) {
                                        flag = false;
                                    }
                                }
                            }
                            if (flag) {
                                for (int a = 0; a < 4; a++) {
                                    for (int b = 0; b < 4; b++) {
                                        group[numberofgroups][a][b] = 1;
                                    }
                                }
                                numberofgroups++;
                            }

                        }
                    }
                }
            }
            n--;


        }
        return group;


    }

    private boolean ifalone(int[][][] groups, int row, int col, int n) {
        for (int k = 0; k < 10; k++) {
            if (groups[k][row][col] != 0) {
                return false;
            }
        }

        return true;
    }

    private int Count1(int[][] map) {
        int count = 0;
        for (int i = 0; i < NumR; i++) {
            for (int j = 0; j < NumC; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }




    public static void main(String[] args) {
        int [][][] groups;
        int [][] a = {
                {1,0,0,0},
                {0,1,1,0},
                {0,1,1,0},
                {0,1,1,0}
        };

        KarnaughMap map = new KarnaughMap(a);
        groups = map.Group();
        for(int k = 0; k < 10; k++){
            for(int i = 0; i<map.NumR; i++){
                for(int j = 0; j<map.NumC; j++){
                    System.out.print(groups[k][i][j]);
                }
                System.out.println();
            }
        }


    }
}
