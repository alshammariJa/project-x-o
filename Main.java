import java.util.*;

public class Main {
    static ArrayList<Integer> userP =new ArrayList<Integer>();
    static ArrayList<Integer> spuP =new ArrayList<Integer>();
    public static void main(String[] args) {

            char [][] gameBoard = {
                    {' ','|',' ','|',' '},
                    {'_','+','_','+','_'},
                    {' ','|',' ','|',' '},
                    {'_','+','_','+','_'},
                    {' ','|',' ','|',' '}

            };

        printGame(gameBoard);
       while (true){
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the number (1-9): ");
         int posP=  scan.nextInt();
        System.out.println(posP);
while (userP.contains(posP)|| spuP.contains(userP)){
    System.out.println("position taken ");
    posP =  scan.nextInt();

}
        place(gameBoard ,posP,"Player");
         String  result=  cheickWinner();
           if(result.length()>0) {
               System.out.println(result);
               break;
           }
        Random spuNumber= new Random();
        int posS= spuNumber.nextInt(9)+1;

           while (userP.contains(posS)|| spuP.contains(posS)){
               posS= spuNumber.nextInt(9)+1;
           }
        place(gameBoard ,posS,"cpu");

         printGame(gameBoard);

        result=  cheickWinner();
        if(result.length()>0) {
            System.out.println(result);
            break;
        }
//           cheickWinner();
 }

    }
    public static  void printGame(char[][] gameBoard){
      for(char[]row :gameBoard){
        for (char c:row){
            System.out.print(c);
        }
        System.out.println();
    }

    }
    public static  void place(char[][] gameBoard, int position,String user){
        char symble= ' ';
        if (user.equals("Player")){
            symble='x';
            userP.add(position);
        } else if (user.equals("cpu")) {
            spuP.add(position);
            symble='o';
        }
        switch (position){
            case 1:
                gameBoard [0][0]= symble;
                break;
            case 2:
                gameBoard [0][2]= symble;
                break;
            case 3:
                gameBoard [0][4]= symble;
                break;
            case 4:
                gameBoard [2][0]= symble;
                break;
            case 5:
                gameBoard [2][2]= symble;
                break;
            case 6:
                gameBoard [2][4]= symble;
                break;
            case 7:
                gameBoard [4][0]= symble;
                break;
            case 8:
                gameBoard [4][2]= symble;
                break;
            case 9:
                gameBoard [4][4]= symble;
                break;
            default:
            break;

        }

    }
    public static String cheickWinner(){
        List topRaw= Arrays.asList(1,2,3);
        List midRaw= Arrays.asList(4,5,6);
        List botRaw= Arrays.asList(7,8,9);
        List leftCal= Arrays.asList(1,4,7);
        List midCal= Arrays.asList(2,5,8);
        List rigCal= Arrays.asList(3,6,9);
        List cross1= Arrays.asList(1,5,9);
        List cross2= Arrays.asList(7,5,3);
        List<List> wining = new ArrayList<List>();
        wining.add(topRaw);
        wining.add(midRaw);
        wining.add(botRaw);
        wining.add(leftCal);
        wining.add(midCal);
        wining.add(rigCal);
        wining.add(cross1);
        wining.add(cross2);
        for(List l :wining){
            if(userP.containsAll(l)){
                return "you won ";
            } else if (spuP.contains(l)) {
                return "spu wins ";
            } else if (userP.size()+spuP.size()==9) {
                return "stop ";
            }
        }


        return "";
    }

}
