package name.vicentvalls.riskofwargames_wh;

/**
 * Created by vicent on 9/09/14.
 */
public class Probability {

    private static int[][] generateCases(int faces, int dices)
    {
        int[][] cases = new int[faces*dices][];
        int iterations = (int) (Math.pow(faces, dices));
        int prev;
        for (int i = 0; i < dices; i++) {
            cases[0][i] = 1;
        }
        for (int i = 1; i < iterations; i++) {
            prev = i-1;
            cases[i] = generateNextCase(cases[prev], 0, faces);
        }

        return cases;
    }

    private static int[][] removeMax(int[][] cases)
    {
        int[][] result = new int[cases.length][];//Remove initialization
        for(int i = 0; i < cases.length; i++) {
            if ((cases[i][0] <= cases[i][1])) {
                if (cases[i][1]<=cases[i][2]) {
                    result[i]= new int[]{cases[i][0], cases[i][1]};
                } else {
                    result[i]= new int[]{cases[i][0], cases[i][2]};
                }
            } else {
                if (cases[i][0]<=cases[i][2]) {
                    result[i]= new int[]{cases[i][0], cases[i][1]};
                } else {
                    result[i]= new int[]{cases[i][1], cases[i][2]};
                }
            }
        }
        return result;
    }

    private static int[][] removeMin(int[][] cases)
    {
        int[][] result = new int[cases.length][];//Remove initialization
        for(int i = 0; i < cases.length; i++) {
            if ((cases[i][0] >= cases[i][1])) {
                if (cases[i][1]>=cases[i][2]) {
                    result[i]= new int[]{cases[i][0], cases[i][1]};
                } else {
                    result[i]= new int[]{cases[i][0], cases[i][2]};
                }
            } else {
                if (cases[i][0]>=cases[i][2]) {
                    result[i]= new int[]{cases[i][0], cases[i][1]};
                } else {
                    result[i]= new int[]{cases[i][1], cases[i][2]};
                }
            }
        }
        return result;
    }

    private static int[] generateNextCase(int[] previusCase,int pos, int faces)
    {
        if(previusCase[pos] < faces) {
            previusCase[pos]++;
        } else {
            previusCase[pos] = 1;
            pos++;
            previusCase = generateNextCase(previusCase, pos, faces);
        }

        return previusCase;
    }

    public static int leadershipProbability(int leadership, boolean additional, boolean getMinor) {
        int dices = 2;
        int faces = 6;
        if (additional) {
            dices = 3;
        }
        int total = 0;
        int success = 0;
        int[][] cases = generateCases(faces, dices);
        if (getMinor) {
            cases = removeMax(cases);
        } else {

            cases = removeMin(cases);
        }
        for(int i = 0; i < cases.length; i++) {
            if ((cases[i][0]+cases[i][1]) <= leadership) {
                success++;
            }
            total++;
        }
        return Math.round(((success/total)*100));
    }


    public static int chargeProbability(int leadership, boolean additional, boolean getMinor) {
        int dices = 2;
        int faces = 6;
        if (additional) {
            dices = 3;
        }
        int total = 0;
        int success = 0;
        int[][] cases = generateCases(faces, dices);
        if (getMinor) {
            cases = removeMax(cases);
        } else {

            cases = removeMin(cases);
        }
        for(int i = 0; i < cases.length; i++) {
            if ((cases[i][0]+cases[i][1]) <= leadership) {
                success++;
            }
            total++;
        }
        return Math.round(((success/total)*100));
    }
}
