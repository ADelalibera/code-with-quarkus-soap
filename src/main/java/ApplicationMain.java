
import static java.lang.System.out;

public class ApplicationMain {
    
    public static void main(String[] args) {
        // Instancia o handler que faz a chamada SOAP
        CalculadoraHandler handler = new CalculadoraHandler();
        
        // Chama o método de soma passando os parâmetros
        long resultado = handler.soma(2, 3);
        
        // Exibe o resultado da soma
        out.println("Resultado: " + resultado);
    }   
}
