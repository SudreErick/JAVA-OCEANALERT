import ENUMS.Direcao;
import ENUMS.EspecialidadeProfissional;
import ENUMS.Regiao;
import ENUMS.TipoAnalise;
import Leituras.AnaliseComunidade;
import Leituras.LeituraSensor;
import Leituras.Profissional;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class PainelControle {

    public static void main(String[] args) {
        // VARIÁVEIS DE INTERAÇÃO
        String aux, escolha = "sim", acessoConcedido;
        int opcao;

        //VARIÁVEIS PROFISSIONAL
        TipoAnalise analise;
        EspecialidadeProfissional especialidade;
        String identificador;
        String nomeProfissional;
        String senha;

        //VARIAVEIS ANALISE_COMUNIDADE
        TipoAnalise analiseComunidade;
        String nomePessoa;
        Regiao regiao;
        LocalDate dataOcorrencia;
        String descricao;

        //VARIAVÉIS LEITURA SENSOR
        double latitude;
        double longitude;
        double profundidade;
        double temperatura;
        double salinidade;
        double nivelOxigenio;
        double nivelPlasticos;
        double nivelQuimicos;
        double nivelPH;
        double nivelTurbidez;
        double nivelNutrientes;
        double velocidadeCorrente;
        String presencaFitoplancton;
        String presencaZooplancton;
        String presencaMetaisPesados;
        Direcao direcaoCorrente;
        LocalDateTime momentoLeitura;

        // INTERAÇÃO COM USUÁRIO (JOPOTIONPANE):

        try {

            do {

                JOptionPane.showMessageDialog(null, "BEM VINDO AO PAINEL DE CONTROLE OCEAN ALERT!");
                analise = getAnalise();
                switch (analise) {
                    case PROFISSIONAL -> {
                        //REGISTRO PROFISSIONAL
                        Profissional profissional = new Profissional();
                        profissional.setAnalise(TipoAnalise.PROFISSIONAL);

                        nomeProfissional = JOptionPane.showInputDialog("Informe o seu nome: ");
                        profissional.setNome(nomeProfissional);

                        especialidade = getEspecialidadeProfissional();
                        profissional.setEspecialidade(especialidade);

                        getIdentificador(profissional);

                        getSenha(profissional);

                        JOptionPane.showMessageDialog(null, "Olá " + nomeProfissional + " BEM-VINDO AO SISTEMA OCEAN ALERT!");

                        //REGISTRO ANALISE PROFISSIONAL
                        JOptionPane.showMessageDialog(null, "BEM-VINDO AO PAINEL DE CONTROLE! " + "\nFaça o registro das 14 informações marítimas coletadas pelos sensores.");
                        LeituraSensor leitura = new LeituraSensor();

                        momentoLeitura = getMomento();
                        leitura.setMomentoLeitura(momentoLeitura);

                        //INICIANDO RELATÓRIO

                        getLatitude(leitura);

                        getLongitude(leitura);

                        getProfundidade(leitura);

                        getDirecaoDaCorrente(leitura);

                        getTemperatura(leitura);

                        getNivelDeSal(leitura);

                        getNivelOxigenio(leitura);

                        getNivelPlasticos(leitura);

                        getNivelQuimicos(leitura);

                        getNivelPh(leitura);

                        getNivelTurbidez(leitura);

                        getNivelNutrientes(leitura);

                        getVelocidadeCorrente(leitura);

                        getPresencaFitoplancton(leitura);

                        getPresencaZooplancton(leitura);

                        getPresencaMetaisPesados(leitura);

                        JOptionPane.showMessageDialog(null, "ANALISE ENCERRADA, O SOFTWARE IRÁ GERAR UM RELATÓRIO DE TODAS AS INFORMAÇÕES A SEGUIR.");
                        leitura.gerarRelatorioJOP();
                        JOptionPane.showMessageDialog(null, "Análise registrada por: " + profissional.getNome() + " Especialidade: " + profissional.getEspecialidade());
                        leitura.gerarRelatorioTerminal();
                    }
                    case COMUNITARIA -> {
                        AnaliseComunidade comunidade = new AnaliseComunidade();

                        getNomePessoa(comunidade);

                        getRegiao(comunidade);

                        getDescricao(comunidade);

                        //Utilizando método de SOBRECARGA - MOMENTO
                        dataOcorrencia = LocalDate.from(getMomento(LocalDateTime.now()));

                        comunidade.setDataOcorrencia(dataOcorrencia);

                        JOptionPane.showMessageDialog(null, "Análise registrada, Obrigado pela cooperação!" +
                                "\nVamos Juntos, por um futuro mais sustentável!");
                        comunidade.regristarAnalise();
                    }
                }
                escolha = JOptionPane.showInputDialog("Deseja continuar? \r\n[SIM] CONTINUAR \r\n[ENTER] SAIR ");
            } while (escolha.equalsIgnoreCase("sim"));
        } catch (Exception e) {
            System.out.println("REGISTRO INVÁLIDO");
        }
        JOptionPane.showMessageDialog(null, "FIM de programa. Volte sempre!");

    }

    private static void getSenha(Profissional profissional) {
        String senha;
        boolean valido = false;
        do {
            senha = JOptionPane.showInputDialog("Digite a sua senha: ");
            valido = profissional.setSenha(senha);
        }while(valido == false);
    }

    private static void getIdentificador(Profissional profissional) {
        String identificador;
        boolean valido = false;
        do {
            identificador = JOptionPane.showInputDialog("Digite o seu código identificador de profissional: ");
            valido = profissional.setIdentificador(identificador);
        }while(valido == false);
    }

    private static void getNomePessoa(AnaliseComunidade comunidade) {
        String nomePessoa;
        boolean valido = false;
        do {
            nomePessoa = JOptionPane.showInputDialog("Informe o seu nome: ");
            valido = comunidade.setNomePessoa(nomePessoa);
        } while (valido == false);
    }

    private static void getDescricao(AnaliseComunidade comunidade) {
        String descricao;
        boolean valido = false;
        do {
            descricao = JOptionPane.showInputDialog("Descreva a ocorrência: ");
            valido = comunidade.setDescricao(descricao);
        } while (valido == false);
    }

    //MENU DE OPÇÕES REGIOES DO BRASIL (ANALISE COMUNITARIA)

    private static void getRegiao(AnaliseComunidade comunidade) {
        Regiao regiao;
        regiao = (Regiao) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Informe a Região de Análise: ",
                "Região",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                Regiao.values(), // Número da opção
                Regiao.COSTA_NORTE);
        comunidade.setRegiao(regiao);
    }

    private static void getLongitude(LeituraSensor leitura) {
        double longitude;
        boolean valido = false;
        do {
            longitude = Double.parseDouble(JOptionPane.showInputDialog("Informe a longitude da região marítima registrada pelo sensor: (FAIXAS ACEITÁVEIS: 1 - 10000000) "));
            valido = leitura.setLatitude(longitude);
        } while (valido == false);
    }

    private static void getLatitude(LeituraSensor leitura) {
        double latitude;
        boolean valido = false;
        do {
            latitude = Double.parseDouble(JOptionPane.showInputDialog("Informe a latitude da região marítima registrada pelo sensor: (FAIXAS ACEITÁVEIS: 1 - 10000000)"));
            valido = leitura.setLatitude(latitude);
        } while (valido == false);
    }

    private static void getPresencaMetaisPesados(LeituraSensor leitura) {
        String presencaMetaisPesados;
        boolean valido = false;
        do {
            presencaMetaisPesados = JOptionPane.showInputDialog("Há presença de Metais Pesados na Região analisada?: "+"\n[SIM] [NAO]");
            valido = leitura.setPresencaMetaisPesados(presencaMetaisPesados);
        } while (valido == false);
    }

    private static void getPresencaZooplancton(LeituraSensor leitura) {
        String presencaZooplancton;
        boolean valido = false;
        do {
            presencaZooplancton = JOptionPane.showInputDialog("Há presença de Zooplanctons na Região analisada?:" + "\n[SIM] [NAO]");
            valido = leitura.setPresencaZooplancton(presencaZooplancton);
        } while (valido == false);
    }

    private static void getPresencaFitoplancton(LeituraSensor leitura) {
        String presencaFitoplancton;
        boolean valido = false;
        do {
            presencaFitoplancton = JOptionPane.showInputDialog("Há presença de Fitoplanctons na Região analisada?: "+"\n[SIM] [NAO]");
            valido = leitura.setPresencaFitoplancton(presencaFitoplancton);
        } while (valido == false);
    }

    private static void getVelocidadeCorrente(LeituraSensor leitura) {
        double velocidadeCorrente;
        boolean valido = false;
        do {
            velocidadeCorrente = Double.parseDouble(JOptionPane.showInputDialog("Informe a Velocidade da Corrente marítima registrada pelo sensor: (FAIXAS ACEITÁVEIS: 0 ms - 200 ms)"));
            valido = leitura.setVelocidadeCorrente(velocidadeCorrente);
        } while (valido == false);
    }

    private static void getNivelNutrientes(LeituraSensor leitura) {
        double nivelNutrientes;
        boolean valido = false;
        do {
            nivelNutrientes = Double.parseDouble(JOptionPane.showInputDialog("Informe o nível de Nutrientes registrado pelo sensor: (FAIXAS ACEITÁVEIS: 0.5ppm - 5ppm)"));
            valido = leitura.setNivelNutrientes(nivelNutrientes);
        } while (valido == false);
    }

    private static void getNivelTurbidez(LeituraSensor leitura) {
        double nivelTurbidez;
        boolean valido = false;
        do {
            nivelTurbidez = Double.parseDouble(JOptionPane.showInputDialog("Informe o nível de Turbidez registrado pelo sensor: (FAIXAS ACEITÁVEIS: 0 NTU - 10 NTU)"));
            valido = leitura.setNivelTurbidez(nivelTurbidez);
        } while (valido == false);
    }

    private static void getNivelPh(LeituraSensor leitura) {
        double nivelPH;
        boolean valido = false;
        do {
            nivelPH = Double.parseDouble(JOptionPane.showInputDialog("Informe o nível de PH registrado pelo sensor: (FAIXAS ACEITÁVEIS: 7.2 - 8.6)"));
            valido = leitura.setNivelPH(nivelPH);
        } while (valido == false);
    }

    private static void getNivelQuimicos(LeituraSensor leitura) {
        double nivelQuimicos;
        boolean valido = false;
        do {
            nivelQuimicos = Double.parseDouble(JOptionPane.showInputDialog("Informe o nível de substâncias químicas registradas pelo sensor: (FAIXAS ACEITÁVEIS: 2ppm - 20ppm)"));
            valido = leitura.setNivelQuimicos(nivelQuimicos);
        } while (valido = false);
    }

    private static void getNivelPlasticos(LeituraSensor leitura) {
        double nivelPlasticos;
        boolean valido = false;
        do {
            nivelPlasticos = Double.parseDouble(JOptionPane.showInputDialog("Informe o nível de Plásticos registrado pelo sensor: (FAIXAS ACEITÁVEIS: 5ppm - 50ppm)"));
            valido = leitura.setNivelPlasticos(nivelPlasticos);
        } while (valido == false);
    }

    private static void getNivelOxigenio(LeituraSensor leitura) {
        double nivelOxigenio;
        boolean valido = false;
        do {
            nivelOxigenio = Double.parseDouble(JOptionPane.showInputDialog("Informe o nível de Oxigênio registrado pelo sensor: (FAIXAS ACEITÁVEIS: 5 mg/L - 15 mg/L)"));
            valido = leitura.setNivelOxigenio(nivelOxigenio);
        } while (valido == false);
    }

    private static void getNivelDeSal(LeituraSensor leitura) {
        double salinidade;
        boolean valido = false;
        do {
            salinidade = Double.parseDouble(JOptionPane.showInputDialog("Informe a salinidade marítima registrada pelo sensor: (FAIXAS ACEITÁVEIS: 32ppt - 38ppt)"));
            valido = leitura.setSalinidade(salinidade);
        } while (valido == false);
    }

    private static void getTemperatura(LeituraSensor leitura) {
        double temperatura;
        boolean valido = false;
        do {
            temperatura = Double.parseDouble(JOptionPane.showInputDialog("Informe a temperatura marítima registrada pelo sensor: (FAIXAS ACEITÁVEIS: -2°C - 35°C)"));
            valido = leitura.setTemperatura(temperatura);
        } while (valido == false);
    }

    private static void getDirecaoDaCorrente(LeituraSensor leitura) {
        Direcao direcaoCorrente;
        direcaoCorrente = (Direcao) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Informe a Direção da Corrente Marítima registrada pelo sensor: ",
                "Direção da Corrente",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                Direcao.values(), // Número da opção
                Direcao.NORTE);

        leitura.setDirecaoCorrente(direcaoCorrente);
    }

    private static void getProfundidade(LeituraSensor leitura) {
        double profundidade;
        var valido = false;
        do {
            profundidade = Double.parseDouble(JOptionPane.showInputDialog("Informe a profundidade registrada pelo sensor: (FAIXAS ACEITÁVEIS: 0 - 300)"));
            valido = leitura.setProfundidade(profundidade);
        } while (valido == false);
    }

    //MENU DE OPÇÕES TIPO DE ESPECIALIDADE DO PROFISSIONAL
    private static EspecialidadeProfissional getEspecialidadeProfissional() {
        EspecialidadeProfissional especialidade;
        especialidade = (EspecialidadeProfissional) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Selecione a sua Especialidade Leituras.Profissional",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                EspecialidadeProfissional.values(), // Número da opção
                EspecialidadeProfissional.ENGENHEIRO_AMBIENTAL);
        return especialidade;
    }

    //MENU DE OPÇÕES TIPO DE ANALISE (COMUNITARIA OU PROFISSIONAL)

    private static TipoAnalise getAnalise() {
        TipoAnalise analise;
        analise = (TipoAnalise) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Selecione o Tipo de Analise",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                TipoAnalise.values(), // Número da opção
                TipoAnalise.PROFISSIONAL);
        return analise;
    }

    //SOBRECARGA DE METODOS
    private static LocalDateTime getMomento() {
        LocalDateTime momentoLeitura;
        momentoLeitura = LocalDateTime.now();
        String mesLeitura = momentoLeitura.getMonthValue() > 9 ? "" + momentoLeitura.getMonthValue() : "0" + momentoLeitura.getMonthValue();
        String diaLeitura = momentoLeitura.getDayOfMonth() > 9 ? "" + momentoLeitura.getDayOfMonth() : "0" + momentoLeitura.getDayOfMonth();
        String dataLeitura = JOptionPane.showInputDialog("Qual a data da leitura no formato DD/MM/AAAA", diaLeitura + "/" + mesLeitura + "/" + momentoLeitura.getYear());
        String horaLeitura = JOptionPane.showInputDialog("Qual a hora da leitura no formato HH:MM", momentoLeitura.getHour() + ":" + momentoLeitura.getMinute());
        int ano = Integer.parseInt(dataLeitura.substring(6, 10));
        int mes = Integer.parseInt(dataLeitura.substring(3, 5));
        int dia = Integer.parseInt(dataLeitura.substring(0, 2));
        int hora = Integer.parseInt(horaLeitura.substring(0, 2));
        int minuto = Integer.parseInt(horaLeitura.substring(3, 5));
        momentoLeitura = LocalDateTime.of(ano, mes, dia, hora, minuto);
        return momentoLeitura;
    }

    //SOBRECARGA DE METODOS
    private static LocalDateTime getMomento(LocalDateTime momentoLeitura) {
        if (Objects.isNull(momentoLeitura))
            momentoLeitura = LocalDateTime.now();
        String mesLeitura = momentoLeitura.getMonthValue() > 9 ? "" + momentoLeitura.getMonthValue() : "0" + momentoLeitura.getMonthValue();
        String diaLeitura = momentoLeitura.getDayOfMonth() > 9 ? "" + momentoLeitura.getDayOfMonth() : "0" + momentoLeitura.getDayOfMonth();
        String dataLeitura = JOptionPane.showInputDialog("Qual a data da leitura no formato DD/MM/AAAA", diaLeitura + "/" + mesLeitura + "/" + momentoLeitura.getYear());
        String horaLeitura = JOptionPane.showInputDialog("Qual a hora da leitura no formato HH:MM", momentoLeitura.getHour() + ":" + momentoLeitura.getMinute());
        int ano = Integer.parseInt(dataLeitura.substring(6, 10));
        int mes = Integer.parseInt(dataLeitura.substring(3, 5));
        int dia = Integer.parseInt(dataLeitura.substring(0, 2));
        int hora = Integer.parseInt(horaLeitura.substring(0, 2));
        int minuto = Integer.parseInt(horaLeitura.substring(3, 5));
        momentoLeitura = LocalDateTime.of(ano, mes, dia, hora, minuto);
        return momentoLeitura;
    }
}
