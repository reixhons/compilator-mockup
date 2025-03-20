import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        String filePath = "src/file.txt";
        Map<String, Double> variables = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        try {

            //! Perdorim StringBuilder sepse String eshte Immutable - pra krijohet objekt i ri ne cdo modifikim
            //! dhe ze memorje

            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line);
                }
            }
            
            String content = contentBuilder.toString();
            
            String[] commands = content.split(";");
            
            for (String command : commands) {
                command = command.trim();
                if (!command.isEmpty()) {
                    // Ekzekuto funskionin
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error gjate leximit te skedarit: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
