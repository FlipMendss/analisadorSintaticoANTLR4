package org.example.felipe;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        String nomeArquivo = "teste.pas";

        String content = new String(Files.readAllBytes(Paths.get(nomeArquivo)));

        GramCompilador compilador = new GramCompilador(content);

        compilador.compile();



    }
}
