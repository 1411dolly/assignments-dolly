import java.util.Scanner;

interface Furniture {
     void stressTest();
     void fireTest();
}

abstract class Chair implements Furniture {
    public abstract String chairType();

}

abstract class Table implements Furniture {
    public abstract String tableType();
}

class MetalChair extends Chair {
    @Override
    public void stressTest() {
        System.out.println("Failed Stress Test");
    }
    @Override
    public void fireTest() {
        System.out.println("Passed Fire Test");
    }
    @Override
    public String chairType() {
        return "metalchair";
    }
}

class MetalTable extends Table {
    @Override
    public void stressTest() {
        System.out.println("Passed Stress Test");
    }
    @Override
    public void fireTest() {
        System.out.println("Passed Fire Test");
    }
    @Override
    public String tableType() {
        return "metaltable";
    }
}

class WoodenTable extends Table {
    @Override
    public void stressTest() {
        System.out.println("Passed Stress Test");
    }

    @Override
    public void fireTest() {
        System.out.println("Failed Fire Test");
    }
    @Override
    public String tableType() {
        return "woodentable";
    }
}


class WoodenChair extends Chair {
    @Override
    public void stressTest() {
        System.out.println("Failed Fire Test");
    }
    @Override
    public void fireTest() {
        System.out.println("Failed Fire Test");
    }
    @Override
    public String chairType() {
        return "woodenchair";
    }
}

public class Q9Furniture {
    public static void main(String[] args) {
        Table table = null;
        Chair chair = null;
        char choice;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Enter type of chair/table");
            String str = input.next();
            switch (str) {
                case "woodenchair":
                    chair = new WoodenChair();
                    System.out.println(chair.chairType());
                    chair.stressTest();
                    chair.fireTest();
                    break;
                case "metalchair":
                    chair = new MetalChair();
                    System.out.println(chair.chairType());
                    chair.stressTest();
                    chair.fireTest();
                    break;
                case "woodentable":
                    table = new WoodenTable();
                    System.out.println(table.tableType());
                    table.stressTest();
                    table.fireTest();
                    break;
                case "metaltable":
                    table = new MetalTable();
                    System.out.println(table.tableType());
                    table.stressTest();
                    table.fireTest();
                    break;
                default:
                    System.out.println("enter valid input");
                    break;

            }
            System.out.println("do you want to continue?");
            choice=input.next().charAt(0);
        }while (choice=='y'||choice=='Y');
    }
}