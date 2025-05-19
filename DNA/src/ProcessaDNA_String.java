import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.LinkedList;

class ProcessaDNA_String implements IProcessaDNA {
    private String sDna;

    public ProcessaDNA_String() {
        sDna = null;
    }

    public String getDNA() {
        return sDna;
    }

    public boolean carregaDados(String fname) {
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nomeCaminhoCompleto = currDir + "/" + fname;
        Path path = Paths.get(nomeCaminhoCompleto);

        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            sDna = sc.nextLine();
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
            return false;
        }
        return true;
    }

    @Override
    public String degradaDNA() {
        if (sDna == null || sDna.length() < 2) {
            return sDna != null ? sDna : "none";
        }

        LinkedList<Character> dnaList = new LinkedList<>();
        for (char c : sDna.toCharArray()) {
            dnaList.add(c);
        }

        boolean mudou;
        do {
            mudou = false;
            int i = 0;
            while (i < dnaList.size() - 1) {
                char atual = dnaList.get(i);
                char proximo = dnaList.get(i + 1);
                
                if (atual != proximo) {
                    char novaBase = IProcessaDNA.defineNova(atual, proximo);
                    dnaList.remove(i);
                    dnaList.remove(i);
                    dnaList.addLast(novaBase);
                    mudou = true;
                    if (i > 0) i--;
                } else {
                    i++;
                }
            }
        } while (mudou);

        StringBuilder resultado = new StringBuilder();
        for (char c : dnaList) {
            resultado.append(c);
        }
        sDna = resultado.toString();
        return sDna;
    }
}