import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Controller {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Entity entitie;
        Scanner sc = new Scanner(System.in);
        HashMap<String, Entity> hm_entities = new HashMap<String, Entity>();
        String str_id;
        String str_name;
        String str_first_characteristic;
        String str_second_characteristic;
        String str_third_characteristic;

        int int_close = 1;
        while (int_close != 0) {

            System.out.println("write: ");
            System.out.println("1 to add one person to the BBDD");
            System.out.println("2 to add one person to the txt file ");
            System.out.println("3 to show all people from the txt file");
            System.out.println("4 to show all people from the BBDD");
            System.out.println("5 ");
            int int_option = sc.nextInt();
            switch (int_option) {
                case 1:
                    System.out.println("Add the ID");
                    str_id = sc.next();
                    System.out.println("Add the name");
                    str_name = sc.next();
                    System.out.println("Add the first characteristic");
                    str_first_characteristic = sc.next();
                    System.out.println("Add the second characteristic");
                    str_second_characteristic = sc.next();
                    System.out.println("Add the third characteristic");
                    str_third_characteristic = sc.next();
                    entitie = new Entity(str_id, str_name, str_first_characteristic, str_second_characteristic, str_third_characteristic);
                    hm_entities.put(entitie.getId(), entitie);
                    try {
                        controller.getBbddModel().addEntity(entitie.getId(), entitie);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Add the ID");
                    str_id = sc.next();
                    System.out.println("Add the name");
                    str_name = sc.next();
                    System.out.println("Add the first characteristic");
                    str_first_characteristic = sc.next();
                    System.out.println("Add the second characteristic");
                    str_second_characteristic = sc.next();
                    System.out.println("Add the third characteristic");
                    str_third_characteristic = sc.next();
                    entitie = new Entity(str_id, str_name, str_first_characteristic, str_second_characteristic, str_third_characteristic);
                    try {
                        controller.getFileManagerModel().addEntity("src/Persona.txt", entitie);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        controller.getFileManagerModel().showAll("src/Persona.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 4:
                    try {
                        controller.getBbddModel().showAll(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    ;
                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
            }
        }
    }


}

