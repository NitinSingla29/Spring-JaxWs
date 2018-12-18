# CustomerJaxWS
It represent a  test saop based service based on JAX WS. It exposes getCustomerById interface to find any customer for given id. As of now it just return a Mock customer for testing purpose

# CustomerWsClient
Its a REST based service which exposes folowing url to find the customer by id. This service internaly rely on above mentioned soap service to find customer.
http://localhost:8081/customer
# Sample Input 
{
 "id": "1" 
}

# Steps to Execute
- Do maven Build and Start CustomerJaxWS
- Generate source for CustomerWsClient using mvn generate-sources
- Do maven Build and Start CustomerWsClient
- Hit the http://localhost:8081/customer with sample input as shown above
