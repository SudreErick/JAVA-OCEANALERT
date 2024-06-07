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

    public void setIdentificador(String identificador) {
        if (identificador.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite o Id do Profissional: ");
        }else{
            this.identificador = identificador;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (identificador.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite o seu nome: ");
        }else{
            this.nome = nome;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (identificador.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite a sua senha: ");
        }else{
            this.senha = senha;
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
