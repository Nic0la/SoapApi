package com.lipariconsulting.springapi.config;

import com.lipariconsulting.springapi.client.NumberConversion;
import com.lipariconsulting.springapi.client.NumberConversionSoapType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.baeldung.springsoap.gen"); //Generated classes' Package
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri("http://localhost:8080/ws/countries.wsdl"); // SOAP service URL
        return template;
    }

//    @Bean
//    public NumberConversionSoapType numberConversionClient() {
//        NumberConversion service = new NumberConversion();
//        return service.getNumberConversionSoap();
//    }

//
    @Bean
    public NumberConversionSoapType numberConversionClient() {
        try {
            // URL del WSDL del servizio SOAP
            URL wsdlLocation = new URL("http://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");

            // Namespace e nome del servizio definiti nel WSDL
            QName serviceName = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversion");

            // Crea il servizio SOAP utilizzando JAX-WS
            Service service = Service.create(wsdlLocation, serviceName);

            // Ottieni il port client generato
            return service.getPort(NumberConversionSoapType.class);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la creazione del client SOAP", e);
        }
    }


}
