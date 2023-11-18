package com.example.learnspringframework2.examples.exercise1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;


interface DataService {
    int[] retrieveData();
}

@Configuration
@ComponentScan
public class RealWorldExampleContextLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(RealWorldExampleContextLauncherApplication.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }


        System.out.println(context.getBean(BusinessCalculationService.class).findMax());
    }
}

@Component
@Primary
class MongoDbDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[]{11, 22, 33, 44, 55};
    }
}


@Component
class MySQLDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}


@Component
class BusinessCalculationService {

    private final DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        // find the max value from the dataService.retrieveData()
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}