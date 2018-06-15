import java.util.Scanner;

public class ScannerClass {
   Scanner scanner=new Scanner(System.in);

    public Integer enterNumber(){
        Integer number;
        while (!scanner.hasNextInt()){
            System.out.println("Напишите число правильно. ");
            scanner.next();
        }
        number=scanner.nextInt();
        return number;
    }

    public String enterLine(){
        String letter;
        letter=scanner.nextLine();
        return letter;
    }
}
