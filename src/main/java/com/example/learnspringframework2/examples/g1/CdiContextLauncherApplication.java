package com.example.learnspringframework2.examples.g1;


import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Jakarta Inject를 사용하면 Spring의 어노테이션을 대체할수 있다.
// 예를 들어 @Component -> @Named으로 대체가 가능하고 , @Autowired -> @Inject으로 대체가 가능하다.

// CDI 주입은 @Component 어노테이션 대신 @Named 어노테이션을 사용한다.
// @Component
@Named
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }


    // CDI 주입을 사용하면 @Autowired 대신에 @Inject를 사용할수 있다.
    // @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

}


// @Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }


        System.out.println(context.getBean(BusinessService.class).getDataService());
    }
}

