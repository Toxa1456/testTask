package com.task.crud;

import com.task.crud.console.PersonView;
import com.task.crud.controller.PersonController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(CrudApplication.class)
                .run(args);
        PersonView view = new PersonView(context.getBean(PersonController.class));
        view.start();
    }

}
