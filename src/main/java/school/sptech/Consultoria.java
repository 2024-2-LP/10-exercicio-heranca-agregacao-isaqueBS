package school.sptech;

import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.Comparator;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
        return null;
    }

    public Double getTotalSalario(){
        return desenvolvedores.stream().
                mapToDouble(Desenvolvedor::calcularSalario).
                sum();
    }


    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }
        return desenvolvedores.stream().
                min(Comparator.
                comparing(Desenvolvedor::calcularSalario)).get();
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
        }
        return false;
    }
}
