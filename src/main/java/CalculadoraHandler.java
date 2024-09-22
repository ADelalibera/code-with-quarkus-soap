import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.tempuri.IServicoCalculadora; // Use a interface correta
import org.tempuri.Soma;

import jakarta.xml.ws.BindingProvider;

public class CalculadoraHandler {

    private IServicoCalculadora createServicoCalculadora(String endpoint, String soapAction) {
        // Cria a fábrica para o cliente SOAP
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IServicoCalculadora.class); // Usar a interface correta
        factory.setAddress(endpoint); // Configura o endpoint diretamente no factory

        // Cria o cliente
        IServicoCalculadora calculadora = (IServicoCalculadora) factory.create();

        // Configura o BindingProvider para adicionar configurações como o endereço de endpoint
        BindingProvider bindingProvider = (BindingProvider) calculadora;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

        // Adiciona o interceptor para a SOAPAction
        // Client client = ClientProxy.getClient(calculadora);
        // client.getOutInterceptors().add(new SoapActionInterceptor(soapAction));

        Client client = ClientProxy.getClient(calculadora);
        client.getOutInterceptors().add(new SoapActionInterceptor(soapAction));
        
        return calculadora;
    }    

    // private IServicoCalculadora createServicoCalculadora(String endpoint, String soapAction) {
    //     // Cria a fábrica para o cliente SOAP
    //     JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
    //     factory.setServiceClass(IServicoCalculadora.class); // Usar a interface, não a classe
    //     factory.setAddress(endpoint);

    //     // Cria o cliente
    //     IServicoCalculadora calculadora = (IServicoCalculadora) factory.create();

    //     // Configura o BindingProvider para adicionar configurações como o endereço de endpoint
    //     // BindingProvider bindingProvider = (BindingProvider) calculadora;
    //     // bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

    //     factory.getProperties().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);    

    //     // Adiciona o interceptor para a SOAPAction
    //     Client client = ClientProxy.getClient(calculadora);
    //     client.getOutInterceptors().add(new SoapActionInterceptor(soapAction));

    //     return calculadora;
    // }

    public long soma(long x, long y) {
        // Cria o serviço calculadora com as configurações apropriadas
        IServicoCalculadora service = createServicoCalculadora(
            "http://192.168.68.111:8000/ServicoCalculadora", 
            "http://tempuri.org/IServicoCalculadora/Soma"
        );

     Soma somaRequest = new Soma();
        somaRequest.setX(x);
        somaRequest.setY(y);

          return service.soma(somaRequest.getX(), somaRequest.getY());
          


        // Chama o método remoto 'soma' no serviço SOAP
        //return service.soma(x, y);
    }
}
