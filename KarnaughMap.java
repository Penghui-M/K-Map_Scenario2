import java.util.ArrayList;
import java.util.List;
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
                                        break;
                                    }

                                } else if (k == 2) {
                                    if (map[i][(NumC + j - 1) % NumC] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][i][(NumC + j - 1) % NumC] = 1;
                                        numberofgroups++;
                                        break;
                                    }

                                } else {
                                    if (map[(NumR + i - 1) % NumR][j] == 1) {
                                        group[numberofgroups][i][j] = 1;
                                        group[numberofgroups][(NumR + i - 1) % NumR][j] = 1;
                                        numberofgroups++;
                                        break;
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
        group = this.remove(group,numberofgroups);
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

    private int[][][] remove(int[][][] group,int numberofgroup){
        int[][][] newgroup = new int[numberofgroup][NumR][NumC];
        for(int k = 0; k < numberofgroup; k++){
            for(int i = 0; i < NumR; i++){
                for(int j = 0; j < NumC; j++){
                    newgroup[k][i][j] = group[k][i][j];
                }
            }
        }
        return newgroup;
    }


    public  String generateBooleanExpression(int[][][] group) {
        List<Integer> cr = new ArrayList<>();
        List<Integer> cc = new ArrayList<>();
        StringBuilder expression = new StringBuilder();
        if((NumC == 4) && (NumR ==4)) {
            for(int k = 0; k < group.length; k++) {
                cr.clear();
                cc.clear();
                for (int i = 0; i < NumR; i++) {
                    for (int j = 0; j < NumC; j++) {
                        if (group[k][i][j] == 1) {
                            if (!(cr.contains(i))) {
                                cr.add(i);
                            }
                            if (!(cc.contains(j))) {
                                cc.add(j);
                            }
                        }
                    }
                }
                StringBuilder term = new StringBuilder();
                if ((cr.contains(0) || cr.contains(1)) && !(cr.contains(2) || cr.contains(3))) {
                    term.append("A'");
                }
                if (!(cr.contains(0) || cr.contains(1)) && (cr.contains(2) || cr.contains(3))) {
                    term.append("A");
                }
                if ((cr.contains(0) || cr.contains(3)) && !(cr.contains(1) || cr.contains(2))) {
                    term.append("B'");
                }
                if (!(cr.contains(0) || cr.contains(3)) && (cr.contains(1) || cr.contains(2))) {
                    term.append("B");
                }
                if ((cc.contains(0) || cc.contains(1)) && !(cc.contains(2) || cc.contains(3))) {
                    term.append("C'");
                }
                if (!(cc.contains(0) || cc.contains(1)) && (cc.contains(2) || cc.contains(3))) {
                    term.append("C");
                }
                if ((cc.contains(0) || cc.contains(3)) && !(cc.contains(1) || cc.contains(2))) {
                    term.append("D'");
                }
                if (!(cc.contains(0) || cc.contains(3)) && (cc.contains(1) || cc.contains(2))) {
                    term.append("D");
                }
                expression.append(term);
                expression.append(" + ");
            }
        } else if ((NumR == 2) && (NumC == 4)) {
            for(int k = 0; k < group.length; k++) {
                cr.clear();
                cc.clear();
                for (int i = 0; i < NumR; i++) {
                    for (int j = 0; j < NumC; j++) {
                        if (group[k][i][j] == 1) {
                            if (!(cr.contains(i))) {
                                cr.add(i);
                            }
                            if (!(cc.contains(j))) {
                                cc.add(j);
                            }
                        }
                    }
                }
                StringBuilder term = new StringBuilder();
                if ((cc.contains(0) || cc.contains(1)) && !(cc.contains(2) || cc.contains(3))) {
                    term.append("A'");
                }
                if (!(cc.contains(0) || cc.contains(1)) && (cc.contains(2) || cc.contains(3))) {
                    term.append("A");
                }
                if ((cc.contains(0) || cc.contains(3)) && !(cc.contains(1) || cc.contains(2))) {
                    term.append("B'");
                }
                if (!(cc.contains(0) || cc.contains(3)) && (cc.contains(1) || cc.contains(2))) {
                    term.append("B");
                }
                if (cr.contains(0) && !(cr.contains(1))) {
                    term.append("C'");
                }
                if (cr.contains(1) && !(cr.contains(0))) {
                    term.append("C");
                }
                expression.append(term);
                expression.append(" + ");
            }
        } else if ((NumR == 2) && (NumC == 2)) {
            for(int k = 0; k < group.length; k++) {
                cr.clear();
                cc.clear();
                for (int i = 0; i < NumR; i++) {
                    for (int j = 0; j < NumC; j++) {
                        if (group[k][i][j] == 1) {
                            if (!(cr.contains(i))) {
                                cr.add(i);
                            }
                            if (!(cc.contains(j))) {
                                cc.add(j);
                            }
                        }
                    }
                }
                StringBuilder term = new StringBuilder();
                if (cr.contains(0) && !(cr.contains(1))) {
                    term.append("A'");
                }
                if (cr.contains(1) && !(cr.contains(0))) {
                    term.append("A");
                }
                if (cc.contains(0) && !(cc.contains(1))) {
                    term.append("B'");
                }
                if (cc.contains(1) && !(cc.contains(0))) {
                    term.append("B");
                }
                expression.append(term);
                expression.append(" + ");
            }

        }
        expression.delete(expression.length() - 3, expression.length());
        return expression.toString();

    }




    public static void main(String[] args) {
        int [][][] groups;
        int [][] a = {
                {0,0,1,1},
                {1,1,0,0}
        };

        KarnaughMap map = new KarnaughMap(a);
        groups = map.Group();
        System.out.println(map.generateBooleanExpression(groups));
        for(int k = 0; k < groups.length; k++){
            for(int i = 0; i < map.NumR; i++){
                for(int j = 0; j < map.NumC; j++){
                    System.out.print(groups[k][i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
