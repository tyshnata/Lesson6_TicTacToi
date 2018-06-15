public class TicTacToe {

    public static void main(String[] args){
        playOrExit();
    }

    private static void playOrExit(){
        TicTacToeSettings game=new TicTacToeSettings();
        ScannerClass scan = new ScannerClass();
        String letter;
        while (true){
            System.out.println("Чтобы сыграть, введите 'p' ");
            System.out.println("Чтобы выйти, введите 'q'");
            letter=scan.enterLine();
            switch (letter){
                case "p":
                    game.startGame();
                    break;
                case "q":
                    System.out.println("Пока!");
                    return;
                default:
                    System.out.println("Введите символ правильно.");
                    break;
            }
        }

    }
}
