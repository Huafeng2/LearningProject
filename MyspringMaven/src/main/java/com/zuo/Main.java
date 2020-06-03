package com.zuo;

import com.zuo.initspringbean.CustomerService;
import com.zuo.spingaop.customerAOP;
import com.zuo.util.Chinese;
import com.zuo.util.HeNanPerson;
import com.zuo.util.Person;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerService customerService = (CustomerService) context.getBean("customerService");
//        System.out.println(customerService);
//
//        Customer1 customer1 = (Customer1) context.getBean("customer1");
//        System.out.println(customer1);
//
//        Customer2 customer2 = (Customer2) context.getBean("Customer2");
//        System.out.println(customer2);
//        context.close();
//
//        ExpressionParser parser = new SpelExpressionParser();
//        Expression exp = parser.parseExpression("'put spel expression here'");
//        String msg = exp.getValue(String.class);
//
//        Item item = new Item("yiibai", 100);
//        StandardEvaluationContext itemContext = new StandardEvaluationContext(item);
//        //display the value of item.name property
//        Expression exp1 = parser.parseExpression("name");
//        String msg1 = exp.getValue(itemContext, String.class);

//        customerAOP custP = (customerAOP) context.getBean("customerAOP");
//        customerAOP cust = (customerAOP) context.getBean("customerAOPProxy");
//        System.out.println("*************************");
//        cust.printName();
//        System.out.println("*************************");
//        cust.printURL();
//        System.out.println("*************************");
//        try {
//            cust.printThrowException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        int length = 10;
        System.out.println(length >> 1);
        Set<HeNanPerson> set = new TreeSet<HeNanPerson>();
        HeNanPerson heNanPerson = new HeNanPerson("Nan yang");
        HeNanPerson heNanPerson2 = new HeNanPerson("Xin yang");
        HeNanPerson heNanPerson3 = new HeNanPerson("An yang");
        set.add(heNanPerson);
        set.add(heNanPerson2);
        ArrayList<Chinese> arrayList = new ArrayList<Chinese>(set);
        arrayList.get(0);
        arrayList.add(1,heNanPerson3);
        System.out.println(arrayList);

    }
}
