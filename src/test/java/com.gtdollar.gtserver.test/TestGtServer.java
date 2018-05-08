package com.gtdollar.gtserver.test;

import junit.framework.TestCase;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.HttpStatus;




/**
 * Created by ok on 7/5/18.
 */
public class TestGtServer extends TestCase {

    private HttpClient httpClient = null;
    private HttpPost method = null;

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testCreate() throws  Exception {

        JSONObject JsonObject = new JSONObject();
        JsonObject.put("email", "name1@email.com");

        StringEntity stringEntity = new StringEntity(JsonObject.toString());
        stringEntity.setContentType("application/json");

        String apiURL = "http://localhost:8080/gtserver/create";
        httpClient = HttpClients.createDefault();
        method = new HttpPost(apiURL);
        method.setHeader("Accept", "application/json");
        method.setEntity( stringEntity );

        HttpResponse response = httpClient.execute(method);

        JSONObject responseObject = null;
        if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
            HttpEntity entity = response.getEntity();

            String rst = EntityUtils.toString(entity);
            System.out.println( "out=" + rst );
            JSONObject rspJsonObject = JSONObject.fromObject( rst );
            Boolean success = (Boolean)rspJsonObject.get("success");
            System.out.println( "success=" + success );
            assertTrue( success == true );
        }

    }

    @Test
    public void testEnquiry() throws  Exception {

        JSONObject JsonObject = new JSONObject();
        JsonObject.put("email", "name1@email.com");

        StringEntity stringEntity = new StringEntity(JsonObject.toString());
        stringEntity.setContentType("application/json");

        String apiURL = "http://localhost:8080/gtserver/enquiry";
        httpClient = HttpClients.createDefault();
        method = new HttpPost(apiURL);
        method.setHeader("Accept", "application/json");
        method.setEntity( stringEntity );

        HttpResponse response = httpClient.execute(method);

        JSONObject responseObject = null;
        if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
            HttpEntity entity = response.getEntity();

            String rst = EntityUtils.toString(entity);
            System.out.println( "enquery out=" + rst );
            JSONObject rspJsonObject = JSONObject.fromObject( rst );
            Boolean success = (Boolean)rspJsonObject.get("success");
            System.out.println( "enquery success=" + success );
            assertTrue( success == true );
        }

    }
}
