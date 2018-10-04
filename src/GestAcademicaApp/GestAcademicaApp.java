package GestAcademicaApp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.lang.System;

public class GestAcademicaApp {

    public static void main(String[] args) {
        GestAcademicaModel model = createData();
        GestAcademicaView view = new GestAcademicaView();

        GestAcademicaController control = new GestAcademicaController();
        control.setModel(model);
        control.setView(view);

        control.startFlow();

        System.out.println("Fim da Aplicação >> "
                + java.time.LocalDateTime.now());

        System.exit(0);
    }

    private static GestAcademicaModel createData() {
        List<Aluno> fichas = Arrays.asList(
                new Aluno("212", "Rui Mota", 21, "LEI", 13.7),
                new Aluno("120", "Paulo Rio", 22, "LEM", 12.7),
                new Aluno("200", "Maria Joao", 22, "LCC", 12.5),
                new Aluno("323", "Carlos Ferreira", 21, "LEI", 16));
        return new GestAcademicaModel(new HashSet<>(fichas));
    }


}
