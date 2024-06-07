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

    public void setNomePessoa(String nomePessoa) {
        if (nomePessoa.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite o seu nome: ");
        }else{
            this.nomePessoa = nomePessoa;
        }
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        if (nomePessoa.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite qual a região de análise: ");
        }else{
            this.regiao = regiao;
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

    public void setDescricao(String descricao) {
        if (nomePessoa.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "ERRO! Digite a descrição da análise feita: ");
        }else{
            this.descricao = descricao;
        }
    }
}
