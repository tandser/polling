package ru.tandser.polling.util;

import ru.tandser.polling.service.exc.NotFoundException;

public class Inspector {

    private Inspector() {}

    public static <T> T requireExist(T result) {
        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

    public static int requireUpdate(int result) {
        if (result == 0) {
            throw new NotFoundException();
        }

        return result;
    }
}