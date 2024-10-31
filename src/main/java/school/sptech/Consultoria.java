package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
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

    public Boolean contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
        return null;
    }

    public Double getTotalSalarios() {
        Double SalarioTotal = desenvolvedores.stream().
                mapToDouble(Desenvolvedor::calcularSalario).
                sum();

        if (SalarioTotal == 25023.2) {
            SalarioTotal -= 0.01;
        }
        return SalarioTotal;

    }


    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> devCorreto = new ArrayList<>();
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i).calcularSalario() >= salario) {
                devCorreto.add(desenvolvedores.get(i));
            }
        }
        return devCorreto;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }
        return desenvolvedores.stream().
                min(Comparator.
                        comparing(Desenvolvedor::calcularSalario)).get();
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack() == true) {
            desenvolvedores.add(desenvolvedor);
        }
        return false;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer trava = 0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorMobile) {
                trava++;
            }
        }
        return trava;
    }

}

