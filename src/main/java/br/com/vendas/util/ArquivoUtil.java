package br.com.vendas.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ArquivoUtil {

    private static final String SEPARADOR = "--------------------------------------------------";

    public static void registrar(String nomeArquivo, String conteudo) {
        registrar(nomeArquivo, conteudo, true);
    }

    public static void registrar(String nomeArquivo, String conteudo, boolean incluirTimestamp) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            if (incluirTimestamp) {
                bw.write("[" + LocalDateTime.now() + "] ");
            }
            bw.write(conteudo);
            bw.newLine();
            bw.write(SEPARADOR);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Erro ao escrever no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}
