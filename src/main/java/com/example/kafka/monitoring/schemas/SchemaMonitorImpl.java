package com.example.kafka.monitoring.schemas;

import com.example.kafka.utils.ConfigReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SchemaMonitorImpl extends ConfigReader  implements SchemaMonitor {

    @Override
    public String read(String jsonPath)  throws IOException {
        String operationNodeIP = ConfigReader.getValue(jsonPath,"operationNode");

        String requestLink = "http://" + operationNodeIP + "/schema/subjects";

        Request request = Request.Get(requestLink);
        String html = "";
        HttpResponse httpResponse = request.execute().returnResponse();
        System.out.println(httpResponse.getStatusLine());
        if (httpResponse.getEntity() != null) {
            html = EntityUtils.toString(httpResponse.getEntity());
        }
        return html;
    }

}
