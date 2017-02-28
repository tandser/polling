package ru.tandser.polling.util;

import ru.tandser.polling.domain.AbstractEntity;
import ru.tandser.polling.service.exc.NotFoundException;
import ru.tandser.polling.web.exc.BadRequestException;

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

    public static void requireNew(AbstractEntity entity) {
        if (entity == null || !entity.isNew()) {
            throw new BadRequestException();
        }
    }

    public static void requireConsistency(AbstractEntity entity, int id) {
        if (entity == null || (!entity.isNew() && entity.getId() != id)) {
            throw new BadRequestException();
        } else if (entity.isNew()) {
            entity.setId(id);
        }
    }
}