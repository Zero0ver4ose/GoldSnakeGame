import java.awt.Point;
import java.util.Scanner;

public class Snake {

    public static void main(String[] args) {

        Point spielerPosition = new Point(10, 9);
        Point schlangePosition = new Point(30, 2);
        Point goldPosition = new Point(6, 6);
        Point tuerPosition = new Point(8, 4);
        boolean weiter = true;
        boolean goldeingesammelt = false;

        while(weiter){
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(spielerPosition))
                        System.out.print("P");
                    else if (p.equals(schlangePosition))
                        System.out.print("S");
                    else if (p.equals(goldPosition))
                        System.out.print("G");
                    else if (p.equals(tuerPosition))
                        System.out.print("T");
                    else System.out.print(".");
                }
                System.out.println();
            }

            if (schlangePosition.equals(spielerPosition)) {
                weiter = false;
                System.out.println("Leider wurdest du aufgefressen");
            }

            if (spielerPosition.equals(goldPosition)){
                goldeingesammelt = true;
                System.out.println("Gold gefunden! finde den Ausgang");
                goldPosition = new Point(-1, -1);
            }
            if (spielerPosition.equals(tuerPosition) && goldeingesammelt){
                System.out.println("Du bist entkommen. Spiel beendet");
            }
            bewegeSpieler(spielerPosition);
            bewegeSchlange(schlangePosition, spielerPosition);
        }


    }

    private static void bewegeSchlange(Point schlangePosition, Point spielerPosition) {
        if (spielerPosition.x < schlangePosition.x){
            schlangePosition.x--;
        } else if (spielerPosition.x > schlangePosition.x){
            schlangePosition.x++;
        }
        if (spielerPosition.y < schlangePosition.y){
            schlangePosition.y--;
        } else if (spielerPosition.y > schlangePosition.y){
            schlangePosition.y++;
        }
    }

    private static void bewegeSpieler(Point spielerPosition) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        if (input.equals("w")){
            if(spielerPosition.y > 0){
                spielerPosition.y--;
            }
        } else if (input.equals("s")){
            if (spielerPosition.y < 9){
                spielerPosition.y++;
            }
        } else if (input.equals("a")){
            if (spielerPosition.x > 0){
                spielerPosition.x--;
            }
        } else if (input.equals("d")){
            if (spielerPosition.x < 39){
                spielerPosition.x++;
            }
        }
    }
}