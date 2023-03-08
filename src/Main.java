import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int guests;
        Scanner Input= new Scanner(System.in);
        System.out.println("Anzahl der angemeldeten Gäste");
        guests= Input.nextInt();

        while(true){
            System.out.println("+X Gäste anmelden, 0Programm beenden, -X Gäste entfernen");
            int value = Input.nextInt();
            if(value == 0){
                break;
            }
            if(value > 0){
                for (int i = 0; i < value; i++){
                    guests++;
                    System.out.println("angemeldet");
                }

            }
            if (value < 0 ){
                for (int i = 0; i > value; i--){
                    guests--;
                    System.out.println("abgemeldet");
                }
            }
            System.out.println("Gäste angemeldet " + guests);
        }




    }
}