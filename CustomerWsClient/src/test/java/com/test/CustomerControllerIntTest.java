package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.beans.CustomerFindRequest;
import com.test.beans.CustomerFindResponse;
import com.test.beans.Status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntTest {

    @LocalServerPort
    private int port;
    
    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void testValidCustomer() {
    	CustomerFindRequest customerFindRequest = new CustomerFindRequest("1");
    	ResponseEntity<CustomerFindResponse> response = template.postForEntity(createUrl("/customer"), customerFindRequest, CustomerFindResponse.class);
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(response.getBody().getCustomer().getName(), "TestCustomer");
        assertEquals(response.getBody().getCustomer().getId(), customerFindRequest.getId());
        assertEquals(response.getBody().getStatus(), Status.SUCCESS);
    }

    @Test
    public void mockException() {
        CustomerFindRequest customerFindRequest = new CustomerFindRequest();
        ResponseEntity<Status> response = template.postForEntity(createUrl("/customer"), customerFindRequest, Status.class);
        assertEquals(response.getStatusCodeValue(), 400);
        assertEquals(response.getBody().name(), Status.FAILURE.name());
    }

    private String createUrl(String uri) {
        return "http://localhost:" + port + uri;
    }
}
