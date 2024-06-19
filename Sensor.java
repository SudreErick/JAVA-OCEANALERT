package Leituras;

import javax.swing.*;

public class Sensor {

    private String id;
    private double latitude;
    private double longitude;
    private double profundidade;

    //Construtor sem Passagem de Parâmetros
    public Sensor() {
    }

    // Construtor com Passagem de Parâmetros
    public Sensor(String id, double latitude, double longitude, double profundidade) {
        this.setId(id);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setProfundidade(profundidade);
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public boolean setId(String id) {
        if (id.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "ERRO! Digite o Id do Leituras.Sensor utilizado na coleta de informações: ");
            return false;
        } else {
            this.id = id;
            return true;
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public boolean setLatitude(double latitude) {
        if (latitude >= 1 && latitude < 10000000) {
            this.latitude = latitude;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 1 - 10000000)");
            return false;
        }
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean setLongitude(double longitude) {
        if (latitude >= 1 && latitude <= 10000000) {
            this.longitude = longitude;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 1 - 10000000)");
            return false;
        }
    }

    public double getProfundidade() {
        return profundidade;
    }

    public boolean setProfundidade(double profundidade) {
        if (profundidade > 0 && profundidade <= 300) {
            this.profundidade = profundidade;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA! : FORA DOS LIMITES (FAIXAS ACEITÁVEIS: 0 - 300)");
            return false;
        }

    }

    public void gerarRelatorioTerminal(){
        System.out.println("\nLatitude: " + getLatitude() + "\nLongitude: " + getLongitude() + "\nProfundidade: " + getProfundidade() + "\nID-Leituras.Sensor: " + getId());
    }
    public void gerarRelatorioJOP(){
        System.out.println("\nLatitude: " + getLatitude() + "\nLongitude: " + getLongitude() + "\nProfundidade: " + getProfundidade() + "\nID-Leituras.Sensor: " + getId());
    }

}
