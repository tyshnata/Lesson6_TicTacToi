import java.util.Random;
import java.util.Scanner;

public class TicTacToeSettings {

    private final Character[][] tableEmpty={
            {'_','|','_','|','_'},
            {'_','|','_','|','_'},
            {' ','|',' ','|',' '}
    };

    public Character[][] getTableEmpty() {
        return tableEmpty;
    }

    private void printTable(Character[][] table){
        for (int i=0;i<3;i++){
            for (int j=0;j<5;j++)
                System.out.print(table[i][j]);
            System.out.println();
        }
    }

    public void startGame(){
        Integer count=0;
        Character[][] table=new Character[3][5];
        for (int i=0;i<3;i++)
            for (int j=0;j<5;j++){
                table[i][j]=tableEmpty[i][j];
            }
        Integer cellNumber;
        ScannerClass scanner=new ScannerClass();
        printTable(table);
        while (true){
            System.out.println("Введите номер пустой ячейки 0, 1, 2,...,8 ");
            cellNumber=scanner.enterNumber();  //
            choiceCell(table,cellNumber,'x');
            count++;
            printTable(table);
            if (count==9){
                System.out.println("Ничья.");
                return;
            }
            if (control(table).equals('x')){
                whoIsWinner(control(table));
                return;
            }
            System.out.println();
            System.out.println("Ход компьютера: ");
            choiceCell(table,randomNumber(),'0');
            printTable(table);
            count++;
            if (control(table).equals('0')){
                whoIsWinner(control(table));
                return;
            }
        }
    }

    private Character control(Character[][] table){
        Character simbol='q';
        if(table[0][0].equals(table[0][2])&table[0][0].equals(table[0][4])){
            simbol=table[0][0];
        }
        if(table[1][0].equals(table[1][2])&table[1][0].equals(table[1][4])){
            simbol=table[1][0];
        }
        if(table[2][0].equals(table[2][2])&table[2][0].equals(table[2][4])){
            simbol=table[2][0];
        }
        if(table[0][0].equals(table[1][0])&table[0][0].equals(table[2][0])){
            simbol=table[0][0];
        }
        if(table[0][2].equals(table[1][2])&table[0][2].equals(table[2][2])){
            simbol=table[0][2];
        }
        if(table[0][4].equals(table[1][4])&table[0][4].equals(table[2][4])){
            simbol=table[0][4];
        }
        if(table[0][0].equals(table[1][2])&table[0][0].equals(table[2][4])){
            simbol=table[0][0];
        }
        if(table[0][4].equals(table[1][2])&table[0][4].equals(table[2][0])){
            simbol=table[0][4];
        }
        return simbol;
    }

    /** the method that determines the winner by the symbol 'x' or '0'*/
    private void whoIsWinner(Character simbol){
        if (simbol.equals('x')){
            System.out.println("Вы победили");
        }
        else {
            if(simbol.equals('0')){
            System.out.println("Вы проиграли");
            }
        }
    }

    /**method for selecting a random cell by a computer*/
    private Integer randomNumber(){
        Integer randomNum;
        Random random=new Random();
        randomNum=random.nextInt(9);
        return randomNum;
    }

    /**If the cell is busy, a message is displayed and the player selects another cell
     * If the cell is occupied and the computer is playing, a method is called that selects a new cell*/
    private void cellBusy(Character[][]table, Character simbol){
        if(simbol.equals('x')){
            System.out.println("Ячейка затята. ");
            startGame();
        }
        else {
            choiceCell(table, randomNumber(),'0');
        }
    }

   /** Method. Checks whether the cell is empty.
    * If empty writes a "x" or "0" to it.
    * If the cell is full, returns to the calling method*/
    private void choiceCell(Character[][] table,Integer number,Character simbol){
        switch (number){
            case 0:
                if(!table[0][0].equals('x')&!table[0][0].equals('0')){
                    table[0][0]=simbol;
                }
                else{
                    cellBusy(table, simbol);
                }
                break;
            case 1:
                if(!table[0][2].equals('x')&!table[0][2].equals('0')){
                    table[0][2]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            case 2:
                if(!table[0][4].equals('x')&!table[0][4].equals('0')){
                    table[0][4]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            case 3:
                if(!table[1][0].equals('x')&!table[1][0].equals('0')){
                    table[1][0]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            case 4:
                if(!table[1][2].equals('x')&!table[1][2].equals('0')){
                    table[1][2]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            case 5:
                if(!table[1][4].equals('x')&!table[1][4].equals('0')){
                    table[1][4]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            case 6:
                if(!table[2][0].equals('x')&!table[2][0].equals('0')){
                    table[2][0]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            case 7:
                if(!table[2][2].equals('x')&!table[2][2].equals('0')){
                    table[2][2]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            case 8:
                if(!table[2][4].equals('x')&!table[2][4].equals('0')){
                    table[2][4]=simbol;
                }
                else{
                    cellBusy(table,simbol);
                }
                break;
            default:
                System.out.println("Введите номер ячейки правильно.");
                return;//startGame();
        }
    }

}
