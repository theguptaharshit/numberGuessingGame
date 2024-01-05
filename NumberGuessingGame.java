import java.util.*;
class NumberGuessingGame
{
    public static void main(String[] args) {
        int round = 1, score = 0;
        System.out.println("Welcome to number guessing game!");
        score = menu(round,score);
        System.out.println("Final Score = "+score);
    }

    public static int menu(int round, int score) {
        Scanner sc = new Scanner(System.in);
        int option=-1, previousScore;
        System.out.println("Round "+round);
        previousScore = game(4*round,(int)Math.pow(10,round),round);
        if(previousScore>score) {
            score += previousScore;
            while(option!=0 && option!=1){
                System.out.println("Enter 1 to continue or 0 leave.");
                option = sc.nextInt();
            }
            if(option==0) {
                return score;
            }
            else if(option==1) {
                return menu(++round,score);
            }
            else {
                return score;
            }
        }
        return score;
    }

    public static int game(int attempts, int max, int round) {
        Scanner sc = new Scanner(System.in);
        int ans=-1, num, attemptsForScore=attempts, score=0;
        while(ans<1) {
            ans = (int)(Math.random()*max);
        }
        System.out.println("Guess a number between 1 to "+max+" in "+attempts+" attempts.");
        while(attempts!=0) {
            System.out.print("Enter: ");
            num = sc.nextInt();
            if(!(num>=1 && num<=max)){
                while((num<1 || num>max)) {
                System.out.print("Try again within limits: ");
                num = sc.nextInt();
                }   
            }
            --attempts;
            if(num==ans) {
                System.out.println("Well done! You took "+(attemptsForScore-attempts)+" attempts.");
                score = (int)((attempts+1)*Math.pow(10,round+1)/attemptsForScore);
                System.out.println("Score = "+score);
                return score;
            }
            else if(num>ans) {
                System.out.println(num+" is higher.");
                System.out.println("Attempts left = "+attempts);
            }
            else {
                System.out.println(num+" is lower.");
                System.out.println("Attempts left = "+attempts);
            }
        }
        System.out.println("Attempts exhausted!");
        System.out.println("The number was = "+ans);
        return 0;
    }
}
