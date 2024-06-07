import javax.swing.*;
import java.time.LocalDate;

public class AnaliseComunidade {
    private TipoAnalise analise;
    private String nomePessoa;
    private String regiao;
    private LocalDate dataOcorrencia;
    private String descricao;

    public AnaliseComunidade(){

    }

    public AnaliseComunidade(TipoAnalise analise, String nomePessoa, String regiao, LocalDate dataOcorrencia, String descricao) {
        this.analise = analise;
        this.nomePessoa = nomePessoa;
        this.regiao = regiao;
        this.dataOcorrencia = dataOcorrencia;
        this.descricao = descricao;
    }

    public TipoAnalise getAnalise() {
        return analise;
    }

    public void setAnalise(TipoAnalise analise) {
        this.analise = analise;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public boolean setNomePessoa(String nomePessoa) {
        if (nomePessoa.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite o seu nome: ");
            return false;
        }else{
            this.nomePessoa = nomePessoa;
            return true;
        }
    }

    public String getRegiao() {
        return regiao;
    }

    public boolean setRegiao(String regiao) {
        if (nomePessoa.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite qual a região de análise: ");
            return false;
        }else{
            this.regiao = regiao;
            return true;
        }
    }

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean setDescricao(String descricao) {
        if (nomePessoa.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite a descrição da análise feita: ");
            return false;
        }else{
            this.descricao = descricao;
            return true;
        }
    }
}
