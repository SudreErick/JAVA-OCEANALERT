import javax.swing.*;
import java.time.LocalDateTime;

public class LeituraSensor extends Sensor {
    private double temperatura;
    private double salinidade;
    private double nivelOxigenio;
    private double nivelPlasticos;
    private double nivelQuimicos;
    private double nivelPH;
    private double nivelTurbidez;
    private double nivelNutrientes;
    private String presencaFitoplancton;
    private String presencaZooplancton;
    private String presencaMetaisPesados;
    private double velocidadeCorrente;
    private Direcao direcaoCorrente;
    private LocalDateTime momentoLeitura;

    //Construtor Sem Passagem
    public LeituraSensor() {
    }


    // Construtor com Passagem
    public LeituraSensor(String id, double latitude, double longitude, double profundidade, double temperatura, double salinidade, double nivelOxigenio, double nivelPlasticos, double nivelQuimicos, double nivelPH, double nivelTurbidez, double nivelNutrientes, String presencaFitoplancton, String presencaZooplancton, String presencaMetaisPesados, double velocidadeCorrente, Direcao direcaoCorrente, LocalDateTime momentoLeitura) {
        super(id, latitude, longitude, profundidade);
        this.setTemperatura(temperatura);
        this.setSalinidade(salinidade);
        this.setNivelOxigenio(nivelOxigenio);
        this.setNivelPlasticos(nivelPlasticos);
        this.setNivelQuimicos(nivelQuimicos);
        this.setNivelPH(nivelPH);
        this.setNivelTurbidez(nivelTurbidez);
        this.setNivelNutrientes(nivelNutrientes);
        this.setPresencaFitoplancton(presencaFitoplancton);
        this.setPresencaZooplancton(presencaZooplancton);
        this.setPresencaMetaisPesados(presencaMetaisPesados);
        this.setVelocidadeCorrente(velocidadeCorrente);
        this.setDirecaoCorrente(direcaoCorrente);
        this.setMomentoLeitura(momentoLeitura);
    }

    public double getTemperatura() {
        return temperatura;
    }

    public boolean setTemperatura(double temperatura) {
        if (temperatura >= -2 && temperatura <= 35) {
            this.temperatura = temperatura;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : TEMPERATURA FORA DOS LIMITES (FAIXAS ACEITÁVEIS: -2°C - 35°C)");
            return false;
        }
    }

    public double getSalinidade() {
        return salinidade;
    }

    public boolean setSalinidade(double salinidade) {
        if (salinidade >= 32 && salinidade <= 38) {
            this.salinidade = salinidade;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : NÍVEL DE SALINIDADE EM DESEQUILÍBRIO (FAIXAS ACEITÁVEIS: 32ppt - 38ppt)");
            return false;
        }
    }

    public double getNivelOxigenio() {
        return nivelOxigenio;
    }

    public boolean setNivelOxigenio(double nivelOxigenio) {
        if (nivelOxigenio >= 5 && nivelOxigenio <= 15) {
            this.nivelOxigenio = nivelOxigenio;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : NÍVEL DE OXIGÊNIO EM DESEQUILÍBRIO (FAIXAS ACEITÁVEIS: 5 mg/L - 15 mg/L)");
            return false;
        }
    }

    public double getNivelPlasticos() {
        return nivelPlasticos;
    }

    public boolean setNivelPlasticos(double nivelPlasticos) {
        if (nivelPlasticos >= 5 && nivelPlasticos <= 50) {
            this.nivelPlasticos = nivelPlasticos;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : NÍVEL DE PLÁSTICOS FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 5ppm - 50ppm)");
            return false;
        }
    }

    public double getNivelQuimicos() {
        return nivelQuimicos;
    }

    public boolean setNivelQuimicos(double nivelQuimicos) {
        if (nivelQuimicos >= 2 && nivelQuimicos <= 20) {
            this.nivelQuimicos = nivelQuimicos;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : NÍVEL DE SUBSTÂNCIAS QUÍMICAS FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 2ppm - 20ppm)");
            return false;
        }
    }

    public double getNivelPH() {
        return nivelPH;
    }

    public boolean setNivelPH(double nivelPH) {
        if (nivelPH >= 7.2 && nivelPH <= 8.6) {
            this.nivelPH = nivelPH;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : NÍVEL DE PH EM DESEQUILÍBRIO (FAIXAS ACEITÁVEIS: 7.2 - 8.6)");
            return false;
        }
    }

    public double getNivelTurbidez() {
        return nivelTurbidez;
    }

    public boolean setNivelTurbidez(double nivelTurbidez) {
        if (nivelTurbidez >= 0 && nivelTurbidez <= 10) {
            this.nivelTurbidez = nivelTurbidez;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : NÍVEL DE TURBIDEZ FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 0 NTU - 10 NTU)");
            return false;
        }
    }

    public double getNivelNutrientes() {
        return nivelNutrientes;
    }

    public Boolean setNivelNutrientes(double nivelNutrientes) {
        if (nivelNutrientes >= 0.5 && nivelNutrientes <= 5) {
            this.nivelNutrientes = nivelNutrientes;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : NÍVEL DE NUTRIENTES FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 0.5ppm - 5ppm)");
            return false;
        }
    }

    public String getPresencaFitoplancton() {
        return presencaFitoplancton;
    }

    public boolean setPresencaFitoplancton(String presencaFitoplancton) {
        if (presencaFitoplancton.equalsIgnoreCase("SIM") || presencaFitoplancton.equalsIgnoreCase("NAO")) {
            this.presencaFitoplancton = presencaFitoplancton;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "REGISTRO INVÁLIDO");
            return false;
        }
    }

    public String getPresencaZooplancton() {
        return presencaZooplancton;
    }

    public boolean setPresencaZooplancton(String presencaZooplancton) {
        if (presencaZooplancton.equalsIgnoreCase("SIM") || presencaZooplancton.equalsIgnoreCase("NAO")) {
            this.presencaZooplancton = presencaZooplancton;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "REGISTRO INVÁLIDO");
            return false;
        }
    }

    public String getPresencaMetaisPesados() {
        return presencaMetaisPesados;
    }

    public boolean setPresencaMetaisPesados(String presencaMetaisPesados) {
        if (presencaMetaisPesados.equalsIgnoreCase("SIM") || presencaMetaisPesados.equalsIgnoreCase("NAO")) {
            this.presencaMetaisPesados = presencaMetaisPesados;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "REGISTRO INVÁLIDO");
            return false;
        }
    }

    public double getVelocidadeCorrente() {
        return velocidadeCorrente;
    }

    public boolean setVelocidadeCorrente(double velocidadeCorrente) {
        if (velocidadeCorrente >= 0 && velocidadeCorrente <= 200) {
            this.velocidadeCorrente = velocidadeCorrente;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : VELOCIDADE CORRENTE FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 0 ms - 200 ms)");
            return false;
        }
    }

    public Direcao getDirecaoCorrente() {
        return direcaoCorrente;
    }

    public void setDirecaoCorrente(Direcao direcaoCorrente) {
        this.direcaoCorrente = direcaoCorrente;
    }

    public LocalDateTime getMomentoLeitura() {
        return momentoLeitura;
    }

    public void setMomentoLeitura(LocalDateTime momentoLeitura) {
        this.momentoLeitura = momentoLeitura;
    }


    //SOBRESCRITA DE METODOS (CLASSE: SENSOR)

    public void GerarRelatorioTerminal() {
        System.out.println("Temperatura: " + getTemperatura() + "\nSalinidade: " + getSalinidade() + "\nNivel Oxigenio: " + getNivelOxigenio() + "\nNivel Plasticos: " + getNivelPlasticos() + "\nNivel Quimicos: " + getNivelQuimicos() + "\nNivel PH: " + getNivelPH() + "\nNivel Turbides: " + getNivelTurbidez() + "\nNivel Nutrientes: " + getNivelNutrientes() + "\nPresenca Fitoplancton: " + getPresencaFitoplancton() + "\nPresenca Zooplancton: " + getPresencaZooplancton() + "\nPresenca Metais Pesados: " + getPresencaMetaisPesados() + "\nVelocidade Corrente: " + getVelocidadeCorrente() + "\nDirecao Corrente: " + getDirecaoCorrente() + "\nMomento Leitura: " + getMomentoLeitura());
    }

    public void GerarRelatorioJOP() {
        JOptionPane.showMessageDialog(null, "Temperatura: " + getTemperatura() + "\nSalinidade: " + getSalinidade() + "\nNivel Oxigenio: " + getNivelOxigenio() + "\nNivel Plasticos: " + getNivelPlasticos() + "\nNivel Quimicos: " + getNivelQuimicos() + "\nNivel PH: " + getNivelPH() + "\nNivel Turbides: " + getNivelTurbidez() + "\nNivel Nutrientes: " + getNivelNutrientes() + "\nPresenca Fitoplancton: " + getPresencaFitoplancton() + "\nPresenca Zooplancton: " + getPresencaZooplancton() + "\nPresenca Metais Pesados: " + getPresencaMetaisPesados() + "\nVelocidade Corrente: " + getVelocidadeCorrente() + "\nDirecao Corrente: " + getDirecaoCorrente() + "\nLatitude: " + getLatitude() + "\nLongitude: " + getLongitude() + "\nProfundidade: " + getProfundidade() + "\nMomento Leitura: " + getMomentoLeitura());
    }

}