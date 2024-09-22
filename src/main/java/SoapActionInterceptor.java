// import org.apache.cxf.binding.soap.SoapMessage;
// import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
// import org.apache.cxf.interceptor.Fault;
// import org.apache.cxf.phase.Phase;

// public class SoapActionInterceptor extends AbstractSoapInterceptor {

//     private String soapAction;

//     public SoapActionInterceptor(String soapAction) {
//         super(Phase.PREPARE_SEND); // Fase em que o interceptor vai atuar
//         this.soapAction = soapAction;
//     }

//     @Override
//     public void handleMessage(SoapMessage message) throws Fault {
//         // Adicionando o cabeçalho SOAPAction na requisição
//         message.put("SOAPAction", soapAction);
//     }
// }

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SoapActionInterceptor extends AbstractSoapInterceptor {

    private String soapAction;

    public SoapActionInterceptor(String soapAction) {
        super(Phase.PREPARE_SEND); // Fase em que o interceptor vai atuar
        this.soapAction = soapAction;
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        try {
            // Cria uma instância do DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Cria um novo documento para o cabeçalho SOAP
            Document doc = builder.newDocument();

            // Cria o elemento do cabeçalho 'Action' com o namespace correto
            Element actionElement = doc.createElementNS("http://www.w3.org/2005/08/addressing", "Action");

            // Define o valor da ação (SOAPAction)
            actionElement.setTextContent(soapAction);

            // Adiciona o atributo "mustUnderstand" ao elemento
            actionElement.setAttribute("mustUnderstand", "1");

            // Cria um QName para o cabeçalho
            QName qname = new QName("http://www.w3.org/2005/08/addressing", "Action");

            // Cria um SoapHeader e o adiciona à mensagem
            SoapHeader soapHeader = new SoapHeader(qname, actionElement);
            message.getHeaders().add(soapHeader);

        } catch (Exception e) {
            throw new Fault(e);
        }
    }
}
