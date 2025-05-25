import java.util.Scanner;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class typing_test{

  private static final String[] Texts = {
        "The quick brown fox jumps over the lazy dog.",
        "Typing is fun! Let's code in Java.",
        "Practice makes perfect. Just keep going!",
        "Java is one of the best programming languages.",
        "Speed and accuracy are both important."
    };

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        String text = Texts[ThreadLocalRandom.current().nextInt(0,Texts.length)];
        System.out.println("type the following text");
        System.out.println("=============================");
        System.out.println(text);
        System.out.println("=============================");


        System.out.println("\n press enter to start......");
        sc.nextLine();


        Instant start = Instant.now();

        System.out.println("now you gotta start typinh \n");
        String userInput = sc.nextLine();

        Instant end = Instant.now();

        // calculate results

        long timeTakenSeconds = java.time.Duration.between(start,end).getSeconds();
        double wpm = ((double) userInput.split("\\s+").length/timeTakenSeconds)*60;

        int correctchars = 0;
        for(int i = 0; i<Math.min(userInput.length(),text.length());i++){
            if(userInput.charAt(i)==text.charAt(i)){
                correctchars++;
            }
        }

        double accuracy = ((double) correctchars/text.length())*100;

        System.out.println("\n --- the results --------");
        System.out.printf("time taken: %.2f seconds%n", (double) timeTakenSeconds);
        System.out.printf("wpm : %.2f%n" , wpm);
        System.out.printf("accuracy : %.2f%% %n", accuracy);
    }

    
}

