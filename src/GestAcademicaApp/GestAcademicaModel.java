package GestAcademicaApp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GestAcademicaModel {
    private Set<Aluno> fichas;

    public GestAcademicaModel() {
        this.fichas = new HashSet<>();
    }

    public GestAcademicaModel(Set<Aluno> alunos) {
        fichas = alunos;
    }

    // Student operation mode
    void insereAluno(Aluno al){
        this.fichas.add(al);
    }

    boolean existeAluno(String codAluno){
        return this.fichas.stream().anyMatch(al -> al.getNro().equals(codAluno));
    }

    Aluno getAluno(String codAluno){
        return this.fichas.stream()
                .filter(al -> al.getNro().equals(codAluno))
                .findFirst()
                .get();
    }

    void removeAluno(String codAluno){
        this.fichas = this.fichas
                .stream()
                .filter(al -> !al.getNro().equals(codAluno))
                .collect(Collectors.toSet());
    }

    int numDeAlunos(){
        return this.fichas.size();
    }

    Aluno[] toArrayAlunos(){
        return this.fichas
                .stream()
                .map(Aluno::clone)
                .toArray(size -> new Aluno[size]);
    }

    List<Aluno> toListAlunos(){
        return this.fichas
                .stream()
                .map(Aluno::clone)
                .collect(Collectors.toList());
    }

    // Course operation mode
    List<Aluno> alunosDoCurso(String curso){
        return this.fichas
                .stream()
                .filter(a -> a.getDegree().equals(curso))
                .collect(Collectors.toList());
    }

    Aluno[] toArrayCurso(String curso){
        return this.fichas
                .stream()
                .filter(a -> a.getDegree().equals(curso))
                .toArray(size -> new Aluno[size]);
    }

    Set<String> cursos(){
        return this.fichas
                .stream()
                .map(Aluno::getDegree)
                .collect(Collectors.toSet());
    }

    boolean existeCurso(String codCurso){
        return this.fichas
                .stream()
                .anyMatch(a -> a.getDegree().equals(codCurso));
    }

    int numAlunosDoCurso(String curso){
        return (int)this.fichas
                .stream()
                .filter(a -> a.getDegree().equals(curso))
                .count();
    }
}
