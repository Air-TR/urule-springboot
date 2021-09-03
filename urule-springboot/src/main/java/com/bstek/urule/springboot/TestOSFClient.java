package com.bstek.urule.springboot;

import com.amarsoft.are.ARE;
import com.amarsoft.are.bm.ServiceMessage;
import com.amarsoft.are.lang.json.Json;
import com.amarsoft.are.lang.json.JsonElement;
import com.amarsoft.are.lang.json.JsonEncoder;
import com.amarsoft.are.lang.json.JsonObject;
import com.amarsoft.osf.client.OSFClient;
import com.amarsoft.osf.client.OSFClientManager;

/**
 * @author rtao
 * @date 2021/6/28 15:45
 */
public class TestOSFClient {

    public  static void main(String[] args) throws Exception {
        Json ruleBody = new JsonObject();
        ruleBody.putElement("ObjectNo","0000");
        ruleBody.putElement("ObjectType","Test001");
        ruleBody.putElement("PackageNo","Test002");
        ruleBody.putElement("ExecuateMethod","10");
        ruleBody.putElement("SystemNo","1");
        String packageNo="Test002";
        OSFClient client = OSFClientManager.newClient("osf:http://127.0.0.1:8081/ABRP2.4/services;messageFormat=json;messageEncoding=utf-8");
        ServiceMessage message = new ServiceMessage(ruleBody);
        message.getSysHead().setServiceName("com.amarsoft.app.rule.service." + packageNo.toLowerCase());
        message.getBody().putElement(JsonElement.valueOf("ObjectNo",ruleBody.getValue("ObjectNo")));
        message.getBody().putElement(JsonElement.valueOf("ObjectType",ruleBody.getValue("ObjectType")));
        ServiceMessage responseMessage = client.callService(message);
        ARE.getLog().info(JsonEncoder.encode(responseMessage));
    }

}
