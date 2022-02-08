package com.bstek.urule.springboot.aaa;

import com.amarsoft.are.ARE;
import com.amarsoft.are.bm.ServiceMessage;
import com.amarsoft.are.lang.json.Json;
import com.amarsoft.are.lang.json.JsonElement;
import com.amarsoft.are.lang.json.JsonEncoder;
import com.amarsoft.are.lang.json.JsonObject;
import com.amarsoft.osf.client.OSFClient;
import com.amarsoft.osf.client.OSFClientManager;
import com.bstek.urule.springboot.entity.FinancialStatement;

/**
 * 安硕规则引擎调用
 *
 * @author rtao
 * @date 2021/6/28 15:45
 */
public class TestOSFClient {

    public  static void main(String[] args) throws Exception {
        Json ruleBody = new JsonObject();
        ruleBody.putElement("ObjectNo","TR");		    // 业务编号（必填）
        ruleBody.putElement("ObjectType","Amix");		// 业务类型（必填）
        ruleBody.putElement("PackageNo","TR");		    // 规则包编号（必填）
        ruleBody.putElement("ExecuateMethod","10");		// 执行方式（必填）：10-同步；11-异步（推送）；12-异步（不推送）；20-查询
        ruleBody.putElement("SystemNo","MAIN-AMIX-APP");// 系统编号（必填）
        FinancialStatement financialStatement = new FinancialStatement();
        financialStatement.setAssetLiabilityRate((double) 60);
        financialStatement.setLiquidityRate((double) 80);
        financialStatement.setQuickRate((double) 90);
        financialStatement.setReceivableTurnoverRate((double) 599);
        ruleBody.putElement("FinancialStatement", financialStatement);
        String packageNo = "TR";
        OSFClient client = OSFClientManager.newClient("osf:http://127.0.0.1:8080/ABRP2.4/services;messageFormat=json;messageEncoding=utf-8");
        ServiceMessage message = new ServiceMessage(ruleBody);
        message.getSysHead().setServiceName("com.amarsoft.app.rule.service." + packageNo.toLowerCase());
        message.getBody().putElement(JsonElement.valueOf("ObjectNo",ruleBody.getValue("ObjectNo")));
        message.getBody().putElement(JsonElement.valueOf("ObjectType",ruleBody.getValue("ObjectType")));
        ServiceMessage responseMessage = client.callService(message);
        ARE.getLog().info(JsonEncoder.encode(responseMessage));
    }

}
