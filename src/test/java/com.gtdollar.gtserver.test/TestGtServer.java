package com.gtdollar.gtserver.test;

import com.gtdollar.gtserver.controller.TransferController;
import junit.framework.TestCase;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestGtServer  {

    private static Logger log = Logger.getLogger( TestGtServer.class );

    private HttpClient httpClient = null;
    private HttpPost method = null;

    String emailAddress = "name12@email.com";

    @Test
    public void test1Create() throws  Exception {

        JSONObject JsonObject = new JSONObject();
        JsonObject.put("email", emailAddress );

        StringEntity stringEntity = new StringEntity(JsonObject.toString());
        stringEntity.setContentType("application/json");

        String apiURL = "http://localhost:8080/gtserver/create";
        httpClient = HttpClients.createDefault();
        method = new HttpPost(apiURL);
        method.setHeader("Accept", "application/json");
        method.setEntity( stringEntity );

        HttpResponse response = httpClient.execute(method);

        assertEquals( response.getStatusLine().getStatusCode(), HttpStatus.OK.value() );

        if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value() ){
            HttpEntity entity = response.getEntity();

            String rst = EntityUtils.toString(entity);
            System.out.println( "out=" + rst );
            JSONObject rspJsonObject = JSONObject.fromObject( rst );
            Boolean success = (Boolean)rspJsonObject.get("success");
            System.out.println( "success=" + success );
            assertEquals( success, true );
        }

    }

    @Test
    public void test2Enquiry() throws  Exception {

        JSONObject JsonObject = new JSONObject();
        JsonObject.put("email", emailAddress );

        StringEntity stringEntity = new StringEntity(JsonObject.toString());
        stringEntity.setContentType("application/json");

        String apiURL = "http://localhost:8080/gtserver/enquiry";
        httpClient = HttpClients.createDefault();
        method = new HttpPost(apiURL);
        method.setHeader("Accept", "application/json");
        method.setEntity( stringEntity );

        HttpResponse response = httpClient.execute(method);

        assertEquals( response.getStatusLine().getStatusCode(), HttpStatus.OK.value() );

        if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
            HttpEntity entity = response.getEntity();

            String rst = EntityUtils.toString(entity);
            System.out.println( "enquery out=" + rst );
            JSONObject rspJsonObject = JSONObject.fromObject( rst );
            Boolean success = (Boolean)rspJsonObject.get("success");
            System.out.println( "enquery success=" + success );
            assertEquals( success, true );
        }

    }


    @Test
    public void test3Transfer() throws  Exception {

        JSONObject JsonObject = new JSONObject();
        JsonObject.put("email", emailAddress );
        JsonObject.put("transferee", "name1@email.com" );
        JsonObject.put("amount", new Double(20) );

        StringEntity stringEntity = new StringEntity(JsonObject.toString());
        stringEntity.setContentType("application/json");

        String apiURL = "http://localhost:8080/gtserver/transfer/transfer";
        httpClient = HttpClients.createDefault();
        method = new HttpPost(apiURL);
        method.setHeader("Accept", "application/json");
        method.setEntity( stringEntity );

        HttpResponse response = httpClient.execute(method);

        assertEquals( response.getStatusLine().getStatusCode(), HttpStatus.OK.value() );

        if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
            HttpEntity entity = response.getEntity();

            String rst = EntityUtils.toString(entity);
            System.out.println( "enquery out=" + rst );
            JSONObject rspJsonObject = JSONObject.fromObject( rst );
            Boolean success = (Boolean)rspJsonObject.get("success");
            System.out.println( "enquery success=" + success );
            assertEquals( success, true );
        }

    }

    @Test
    public void test4TransferEnquiry() throws  Exception {

        JSONObject JsonObject = new JSONObject();
        JsonObject.put("email", emailAddress );

        StringEntity stringEntity = new StringEntity(JsonObject.toString());
        stringEntity.setContentType("application/json");

        String apiURL = "http://localhost:8080/gtserver/transfer/enquiry";
        httpClient = HttpClients.createDefault();
        method = new HttpPost(apiURL);
        method.setHeader("Accept", "application/json");
        method.setEntity( stringEntity );

        HttpResponse response = httpClient.execute(method);

        assertEquals( response.getStatusLine().getStatusCode(), HttpStatus.OK.value() );

        if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
            HttpEntity entity = response.getEntity();

            String rst = EntityUtils.toString(entity);
            System.out.println( "enquery out=" + rst );
            JSONObject rspJsonObject = JSONObject.fromObject( rst );
            Boolean success = (Boolean)rspJsonObject.get("success");
            System.out.println( "enquery success=" + success );
            assertEquals( success, true );
        }

    }

    @Before
    public void setUp() throws Exception {

    }
    @After
    public void tearDown() throws Exception {

    }

}
