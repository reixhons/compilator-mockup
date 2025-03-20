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

       private static double evaluateExpression(String expression, Map<String, Double> variables) {
        if (expression.contains("+")) {
            String[] parts = expression.split("\\+");
            return getValueOf(parts[0].trim(), variables) + getValueOf(parts[1].trim(), variables);
        } else if (expression.contains("-")) {
            String[] parts = expression.split("-");
            return getValueOf(parts[0].trim(), variables) - getValueOf(parts[1].trim(), variables);
        } else if (expression.contains("*")) {
            String[] parts = expression.split("\\*");
            return getValueOf(parts[0].trim(), variables) * getValueOf(parts[1].trim(), variables);
        } else if (expression.contains("/")) {
            String[] parts = expression.split("/");
            double divisor = getValueOf(parts[1].trim(), variables);
            if (divisor == 0) {
                throw new RuntimeException("Pjesetim me zero o mjeshter");
            }
            return getValueOf(parts[0].trim(), variables) / divisor;
        } else {
            return getValueOf(expression, variables);
        }
    }

    private static double getValueOf(String term, Map<String, Double> variables) {
        try {
            return Double.parseDouble(term);
        } catch (NumberFormatException e) {
            if (variables.containsKey(term)) {
                return variables.get(term);
            } else {
                throw new RuntimeException("Variabla '" + term + "' nuk eshte definuar");
            }
        }
    }
}
