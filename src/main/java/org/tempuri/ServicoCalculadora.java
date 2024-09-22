package org.tempuri;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.5
 * 2024-09-22T19:28:26.543-03:00
 * Generated source version: 4.0.5
 *
 */
@WebServiceClient(name = "ServicoCalculadora",
                  wsdlLocation = "file:/home/delalibera/app/code-with-quarkus-soap/src/main/resources/ServicoCalculadora.wsdl",
                  targetNamespace = "http://tempuri.org/")
public class ServicoCalculadora extends Service {

    public static final URL WSDL_LOCATION;

    public static final QName SERVICE = new QName("http://tempuri.org/", "ServicoCalculadora");
    public static final QName CustomBindingIServicoCalculadora = new QName("http://tempuri.org/", "CustomBinding_IServicoCalculadora");
    static {
        URL url = null;
        try {
            url = URI.create("file:/home/delalibera/app/code-with-quarkus-soap/src/main/resources/ServicoCalculadora.wsdl").toURL();
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ServicoCalculadora.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/delalibera/app/code-with-quarkus-soap/src/main/resources/ServicoCalculadora.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ServicoCalculadora(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServicoCalculadora(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicoCalculadora() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ServicoCalculadora(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ServicoCalculadora(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ServicoCalculadora(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns IServicoCalculadora
     */
    @WebEndpoint(name = "CustomBinding_IServicoCalculadora")
    public IServicoCalculadora getCustomBindingIServicoCalculadora() {
        return super.getPort(CustomBindingIServicoCalculadora, IServicoCalculadora.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IServicoCalculadora
     */
    @WebEndpoint(name = "CustomBinding_IServicoCalculadora")
    public IServicoCalculadora getCustomBindingIServicoCalculadora(WebServiceFeature... features) {
        return super.getPort(CustomBindingIServicoCalculadora, IServicoCalculadora.class, features);
    }

}
