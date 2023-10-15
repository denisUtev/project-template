package hw1;

public class Task6 {

    private static final int KAPREKAR_NUM = 6174;
    private static final int COUNT_FIGURES = 10;
    public static int countK(int num){
        int[] countFigure = new int[COUNT_FIGURES];
        while(num > 0){
            countFigure[num % COUNT_FIGURES]++;
            num /= 10;
        }
        int newNum = getMaxNum(countFigure) - getMinNum(countFigure);
        if(newNum == KAPREKAR_NUM)
            return 1;
        return 1 + countK(newNum);
    }

    private static int getMinNum(int[] countFigure){
        int num = 0;
        for(int i=0; i<COUNT_FIGURES; i++){
            for(int j = 0; j < countFigure[i]; j++)
                num = num * 10 + i;
        }
        return num;
    }

    private static int getMaxNum(int[] countFigure){
        int num = 0;
        for(int i=COUNT_FIGURES - 1; i>= 0; i--){
            for(int j = 0; j < countFigure[i]; j++)
                num = num * 10 + i;
        }
        return num;
    }
}
