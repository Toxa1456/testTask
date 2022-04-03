package com.task.crud.console;


import com.task.crud.controller.PersonController;
import com.task.crud.model.Message;
import com.task.crud.model.Person;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonView {

    private String id = "Введите ID: \n";
    private String name = "Введите имя: \n";
    private String lastName = "Введите фамилию: \n";
    private String patronymic = "Введите отчество: \n";
    private String post = "Введите должность: \n";
    private String organization = "Введите организацию: \n";
    private String mail = "Введите mail: \n";
    private String number = "Введите номера телефонов: \n";
    private String ok = "Операция успешно выполнена";
    private boolean work = true;
    private final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));


    private final PersonController controller;

    public PersonView(PersonController personController) {
        this.controller = personController;
    }

    public void start() throws IOException {
        while (work) {
            String test = scanner.readLine().toLowerCase();
            switch (test) {
                case "add":
                    String chek = controller.add(addPerson());
                    if (chek.equals("error")) {
                        System.out.println(Message.INVALID_INPUT.getMassage());
                    }  else {
                        System.out.println(ok);
                    }
                    break;
                case "change":
                    System.out.println(id);
                    String person_id = scanner.readLine();
                    Person person = controller.find(chekId(person_id));
                    if (person == null) {
                        System.out.println(Message.NOT_FOUND.getMassage());
                    } else {
                        System.out.println(person);
                        chek = controller.change(changePerson(person));
                        if (chek.equals("error")) {
                            System.out.println(Message.INVALID_INPUT.getMassage());
                        } else {
                            System.out.println(ok);
                        }
                    }
                    break;
                case "find":
                    System.out.println(id);
                    person_id = scanner.readLine();
                    person = controller.find(chekId(person_id));
                    if (person == null) {
                        System.out.println(Message.NOT_FOUND.getMassage());
                    }  else {
                        System.out.println(person);
                    }
                    break;
                case "delete":
                    System.out.println(id);
                    person_id = scanner.readLine();
                    person = controller.find(chekId(person_id));
                    if (person == null) {
                        System.out.println(Message.NOT_FOUND.getMassage());
                    }  else {
                        chek = controller.delete(chekId(person_id));
                        if (chek.equals("error")) {
                            System.out.println(Message.INVALID_INPUT.getMassage());
                        } else {
                            System.out.println(ok);
                        }
                    }
                    break;
                case "all":
                    List<Person> list = controller.showAll();
                    if (list == null) {
                        System.out.println(Message.EMPTY_LIST.getMassage());
                    } else {
                        if (list.isEmpty()) {
                            System.out.println(Message.EMPTY_LIST.getMassage());
                        } else {
                            for (Person p : list) {
                                System.out.println(p.toString());
                            }
                        }
                    }
                    break;
                case "close":
                    work = false;
                    break;
                case "help":
                    System.out.println(Message.LINE.getMassage());
                    System.out.println(Message.COMMAND_LIST.getMassage());
                    System.out.println(Message.LINE.getMassage());
                    break;
                default:
                    System.out.println(Message.LINE.getMassage());
                    System.out.println(Message.HELP.getMassage());
                    System.out.println(Message.LINE.getMassage());
            }
        }
    }

    private Person addPerson() throws IOException {
        Person person = new Person();
        return writePerson(person);
    }

    private Person changePerson(Person person) throws IOException {
        return writePerson(person);
    }


    private void backOrClose(String text) {
        if(text.equals("close")) {
            work = false;
        }
    }

    private Long chekId(String id) {
        long personId;
        backOrClose(id);
        try {
            personId = Long.parseLong(id);
            return personId;
        } catch (IllegalArgumentException exception) {
            System.out.println(Message.INVALID_INPUT.getMassage());
        }
        return 0L;
    }

    private Person writePerson(Person person) throws IOException {
        System.out.println(name);
        String firstName = scanner.readLine();
        backOrClose(firstName);
        person.setFirstName(firstName);

        System.out.println(lastName);
        String secondName = scanner.readLine();
        backOrClose(secondName);
        person.setLastName(secondName);


        System.out.println(patronymic);
        String pat = scanner.readLine();
        backOrClose(pat);
        person.setPatronymic(pat);

        System.out.println(post);
        String po = scanner.readLine();
        backOrClose(po);
        person.setPost(po);

        System.out.println(organization);

        String org = scanner.readLine();
        backOrClose(org);
        person.setOrganization(org);

        System.out.println(mail);
        String ma = scanner.readLine();
        backOrClose(ma);
        person.setMail(ma);

        System.out.println(number);
        List<String> list = Arrays.stream(scanner.readLine().split(" ")).collect(Collectors.toList());
        if (list.isEmpty()) {
            System.out.println(Message.INVALID_INPUT.getMassage());
        }
        person.setTelephoneNumbers(list);


        return person;
    }
}
