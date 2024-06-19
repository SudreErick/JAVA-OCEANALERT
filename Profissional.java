package Leituras;
import ENUMS.TipoAnalise;
import ENUMS.EspecialidadeProfissional;
import javax.swing.*;

public class Profissional {
    private TipoAnalise analise;
    private String identificador;
    private String nome;
    private String senha;
    private EspecialidadeProfissional especialidade;

    public Profissional() {
    }

    public Profissional(String identificador, String nome, String senha, EspecialidadeProfissional especialidade, TipoAnalise analise) {
        this.setIdentificador(identificador);
        this.setNome(nome);
        this.setSenha(senha);
        this.setEspecialidade(especialidade);
        this.setAnalise(analise);
    }


    public String getIdentificador() {
        return identificador;
    }

    public boolean setIdentificador(String identificador) {
        if (identificador.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite o Id do Leituras.Profissional: ");
            return false;
        }else{
            this.identificador = identificador;
            return true;
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if (nome.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite o seu nome: ");
            return false;
        }else{
            this.nome = nome;
            return true;
        }
    }

    public String getSenha() {
        return senha;
    }

    public boolean setSenha(String senha) {
        if (senha.equals("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite a sua senha: ");
            return false;
        }else{
            this.senha = senha;
            return true;
        }
    }

    public EspecialidadeProfissional getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeProfissional especialidade) {
        this.especialidade = especialidade;
    }

    public TipoAnalise getAnalise() {
        return analise;
    }

    public void setAnalise(TipoAnalise analise) {
        this.analise = analise;
    }
}
