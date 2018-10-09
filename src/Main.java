import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
         int id_curse;
        int int_close = 1;

        while (int_close != 0) {
            System.out.println("write the number: ");
            System.out.println("1 to acces into the bbdd");
            System.out.println("2 to acces into the txt file");

            int int_option1 = sc.nextInt();
            switch (int_option1) {

                case 1:
                    controller.acces = new BbddModel();
                    break;
                case 2:
                    controller.acces = new FileManagerModel("src/Persona.txt");
                    break;

                default:

            }
            System.out.println("write the number: ");
            System.out.println("1 to add one person");
            System.out.println("2 to show all people ");
            System.out.println("3 to delete one person");
            System.out.println("4 to save all data (if you have been choosen acces to txt file all data will be save into the bbdd else it will be save into the txt file.)");
            System.out.println("5 to exit");
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
                    System.out.println("Add the id curse");
                    id_curse = sc.nextInt();
                    entitie = new Entity(str_id, str_name, str_first_characteristic, str_second_characteristic, str_third_characteristic,id_curse);
                    hm_entities.put(entitie.getId(), entitie);
                    try {
                        controller.getAcces().addEntity(entitie);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        controller.getAcces().showAll();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                //borrar
                case 3:
                    System.out.println("write the id of the person you want to delete");
                    int int_id = sc.nextInt();
                    controller.getAcces().deleteOne(int_id);
                    break;
                case 4:

                    try {
                        hm_entities = controller.getAcces().saveEntities(hm_entities);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (int_option1 == 2) {
                        controller.acces = new BbddModel();
                    } else {
                        controller.acces = new FileManagerModel("src/Persona.txt");

                    }
                    for (Map.Entry<String, Entity> entry : hm_entities.entrySet()) {
                        String k = entry.getKey();
                        Entity v = entry.getValue();
                        try {
                            controller.getAcces().addEntity(hm_entities.get(k));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("data saved!");


                    break;
                case 5:
                    int_close = 0;
                default:
            }
        }
    }


}
