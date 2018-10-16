import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main extends Controller {
    public Main(DataManager acces, BbddModel bbddModel, FileManagerModel fileManagerModel) {
        super(acces, bbddModel, fileManagerModel);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        Entity entity;
        Curse curse = new Curse();
        Scanner sc = new Scanner(System.in);
        HashMap<String, Entity> hm_entities = new HashMap<String, Entity>();
        HashMap<Integer, Curse> hm_curses = new HashMap<Integer, Curse>();

        String str_id;
        String str_name;
        String str_first_characteristic;
        String str_second_characteristic;
        String str_third_characteristic;

        int id_curse;
        int int_close = 1;


        while (int_close != 0) {
            System.out.println("write the number: ");
            System.out.println("1 to acces into the bbdd if you use entities");
            System.out.println("2 to acces into the txt file if you use entities");
            System.out.println("3 to acces into the bbdd using hibernate");

            int int_option1 = sc.nextInt();
            switch (int_option1) {

                case 1:
                    controller.acces = new BbddModel();
                    break;
                case 2:
                    controller.acces = new FileManagerModel("src/Persona.txt");
                    break;
                case 3:
                    controller.acces = new HibernateModel();
                    break;

                default:

            }
            try {
                hm_entities = controller.getAcces().saveEntities();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                hm_curses = controller.getAcces().saveCurses();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("write the number: ");
            System.out.println("1 to add one entitie");
            System.out.println("2 to add one curse");
            System.out.println("3 to show all entities ");
            System.out.println("4 to show all curses");
            System.out.println("5 to delete one person");
            System.out.println("6 to save all data entities (if you have been choosen acces to txt file all data will be save into the bbdd else it will be save into the txt file.)");
            System.out.println("7 to save all data curses (if you have been choosen acces to txt file all data will be save into the bbdd else it will be save into the txt file.)");
            System.out.println("8 to exit");
            int int_option = sc.nextInt();
            switch (int_option) {
                case 1:
                    try {
                        hm_entities = controller.getAcces().saveEntities();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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
                    //controller.getAcces().searchCurse(id_curse);
                    hm_curses = controller.saveCurses();
                    curse = hm_curses.get(id_curse);

                    if (curse == null) {
                        System.out.println("ese id no existe");
                    } else {
                        entity = new Entity(str_id, str_name, str_first_characteristic, str_second_characteristic, str_third_characteristic, curse);
                        hm_entities.put(entity.getStr_mid(), entity);
                        try {
                            controller.getAcces().addEntity(entity);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:

                    System.out.println("Add the ID");
                    int id = sc.nextInt();
                    System.out.println("Add the name");
                    str_name = sc.next();
                    System.out.println("Add the first characteristic");
                    str_first_characteristic = sc.next();
                    System.out.println("Add the second characteristic");
                    str_second_characteristic = sc.next();
                    System.out.println("Add the third characteristic");
                    str_third_characteristic = sc.next();
                    curse = new Curse(id, str_name, str_first_characteristic, str_second_characteristic, str_third_characteristic);
                    hm_curses.put(curse.getInt_id(), curse);
                    try {
                        controller.getAcces().addCurse(curse);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    try {
                        controller.getAcces().showAll();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 4:
                    try {
                        controller.getAcces().showAllCurses();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                //borrar
                case 5:
                    System.out.println("write the id of the person you want to delete");
                    int int_id = sc.nextInt();
                    controller.getAcces().deleteOne(int_id);
                    break;
                case 6:


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
                case 7:


                    if (int_option1 == 2) {
                        controller.acces = new BbddModel();
                    } else {
                        controller.acces = new FileManagerModel("src/Curso.txt");

                    }

                    for (Map.Entry<Integer, Curse> entry : hm_curses.entrySet()) {
                        Integer k = entry.getKey();
                        Curse v = entry.getValue();
                        try {
                            controller.getAcces().addCurse(hm_curses.get(k));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("data saved!");


                    break;

                case 8:
                    int_close = 0;
                default:
            }
        }
    }


}
