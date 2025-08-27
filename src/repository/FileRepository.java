package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRepository {
    static Path pathForm = Paths.get("src\\data\\formulario.txt");

    public void createFile() {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1 - Qual o nome e sobrenome do pet?\\n2 - Qual o tipo do pet (Cachorro/Gato)\\n3 - Qual o sexo do animal?\\n4 - Qual endereço e bairro que ele foi encontrado?\\n5 - Qual a idade aproximada do pet?\\n6 - Qual o peso aproximado do pet?\\n7 - Qual a raça do pet?\"");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
