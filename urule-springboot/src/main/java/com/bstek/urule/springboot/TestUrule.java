package com.bstek.urule.springboot;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.bstek.urule.springboot.entity.Customer;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author rtao
 * @date 2021/9/2 10:53
 */
@Component
public class TestUrule {

    public static void main(String[] args) throws IOException {
        //从Spring中获取KnowledgeService接口实例
        KnowledgeService service=(KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        //通过KnowledgeService接口获取指定的资源包，格式：项目名/知识包ID
        KnowledgePackage knowledgePackage=service.getKnowledge("demo/jclKno");
        //通过取到的KnowledgePackage对象创建KnowledgeSession对象
        KnowledgeSession session= KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Customer customer = new Customer();
        customer.setAge(20);
        customer.setLevel(15);
        //将业务数据对象Employee插入到KnowledgeSession中
        session.insert(customer);
        //执行所有满足条件的规则
//        session.fireRules();
        //执行决策流，输入决策流ID
        session.startProcess("JCL001");
        //执行结果
        System.out.println(customer.getScore());
    }
}
