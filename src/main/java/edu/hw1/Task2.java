package hw1;

public class Task2 {

    public static int countDigits(int num){
        int count = 0;

        do{
            num /= 10;
            count++;
        }while(num > 0);

        return count;
    }
}
