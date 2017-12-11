package org.arpit.java2blog;

import org.kie.api.io.ResourceType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.technorage.demo.drools.DroolsResource;
import com.technorage.demo.drools.KieBuildException;
import com.technorage.demo.drools.ResourcePathType;
import com.technorage.demo.drools.spring.DefaultKieContainerBean;
import com.technorage.demo.drools.spring.DefaultKieServicesBean;
import com.technorage.demo.drools.spring.KieContainerBean;
import com.technorage.demo.drools.spring.KieServicesBean;

@Configuration
//@Profile("drools")
public class DemoKieConfig {

    @Bean(name = "demoKieServices")
    public KieServicesBean kieServices() throws KieBuildException {
        DroolsResource[] resources = new DroolsResource[]{ 
                new DroolsResource("rules/order-discount-rules.drl", 
                        ResourcePathType.CLASSPATH, 
                        ResourceType.DRL),new DroolsResource("rules/decide-winning-rule.drl", 
                                        ResourcePathType.CLASSPATH, 
                                        ResourceType.DRL)};
        KieServicesBean bean = new DefaultKieServicesBean(resources);
        return bean;
    }
    
    @Bean(name = "demoKieContainer")
    public KieContainerBean kieContainer(KieServicesBean kieServices) {
        KieContainerBean bean = new DefaultKieContainerBean(kieServices);
        return bean;
    }
    
}
