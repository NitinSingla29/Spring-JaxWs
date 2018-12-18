package com.test.configuration.ws.customer;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.test.jax.ws.service.CustomerService;

@Configuration
public class CustomerServiceConfiguration {
	
	@Value("${CUSTOMER_SERVICE_NAME}")
	private String CUSTOMER_SERVICE_NAME;

	@Value("${NAMESPACE_URI}")
	private String NAMESPACE_URI;

	@Value("${WSDL_LOCATION}")
	private String WSDL_LOCATION;

	@Value("${END_POINT_URL}")
	private String END_POINT_URL;
	
	@Bean
	public JaxWsPortProxyFactoryBean customerServiceService() throws MalformedURLException {
		JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean = new JaxWsPortProxyFactoryBean();
		jaxWsPortProxyFactoryBean.setServiceInterface(CustomerService.class);
		jaxWsPortProxyFactoryBean.setWsdlDocumentUrl(new URL(WSDL_LOCATION));
		jaxWsPortProxyFactoryBean.setNamespaceUri(NAMESPACE_URI);
		jaxWsPortProxyFactoryBean.setServiceName(CUSTOMER_SERVICE_NAME);
		jaxWsPortProxyFactoryBean.setEndpointAddress(END_POINT_URL);
		return jaxWsPortProxyFactoryBean;
	}

}
