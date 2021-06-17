package com.bstek.urule.springboot.service.impl;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.bstek.urule.springboot.entity.Customer;
import com.bstek.urule.springboot.service.InvokeService;
import org.springframework.stereotype.Service;

@Service
public class InvokeServiceImpl implements InvokeService {

    @Override
    public void invokeDemo() throws Exception {
        //从Spring中获取KnowledgeService接口实例
        KnowledgeService service=(KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        //通过KnowledgeService接口获取指定的资源包"projectName/test123"
        KnowledgePackage knowledgePackage=service.getKnowledge("demo/demo");
        //通过取到的KnowledgePackage对象创建KnowledgeSession对象
        KnowledgeSession session= KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Customer customer = new Customer();
        customer.setAge(20);
        customer.setLevel(15);
        //将业务数据对象Employee插入到KnowledgeSession中
        session.insert(customer);
        //执行所有满足条件的规则
        session.fireRules();
        System.out.println(customer.getName());
    }

}
