package com.task.crud.model;

import lombok.Getter;


@Getter
public enum Message {

    LINE("-----------------------------------------"),
    HELP("Неверный ввод. Введите help, чтобы получить справку по коммандам"),
    COMMAND_LIST("add - позволяет добавить пользователя \n" +
            "change - позволяет изменить пользователя \n" +
            "find - позволяет найти пользователя по id \n" +
            "delete - позволяет удалить пользователя \n" +
            "all - выводит список всех пользоватей \n" +
            "close - закрывает приложения после выполнения текущей команды. Если сейчас никакой команды не выполняется, то сразу закрывает приложение."),
    EMPTY_LIST("Список пользователей пуст."),
    INVALID_INPUT("Неверный ввод! \n"),
    NOT_FOUND("Пользователь не найден!");


    private final String massage;


    Message(String message) {
        this.massage = message;
    }
}
