package GestAcademicaApp;

import java.util.List;



public class Menu {
    private List<Opcao> entries;
    private String header;

    public Menu(List<Opcao> entries, String header) {
        this.entries = entries;
        this.header = header;
    }

    public void show(){
        System.out.println("\n--------------------------------------");
        System.out.println(this.header);
        System.out.println("--------------------------------------");
        this.entries.forEach(
                op -> System.out.print(op.toString()));
        System.out.print("\tChoose an option: ");
    }
}
