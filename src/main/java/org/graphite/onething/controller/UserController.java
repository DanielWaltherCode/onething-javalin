package org.graphite.onething.controller;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.graphite.onething.repository.UserRepository;
import org.graphite.onething.tables.pojos.UserTable;
import org.jetbrains.annotations.NotNull;

public class UserController implements CrudHandler {

    private UserRepository userRepository = new UserRepository();
    @Override
    public void create(@NotNull Context context) {

    }

    @Override
    public void delete(@NotNull Context context, @NotNull String s) {

    }

    @Override
    public void getAll(@NotNull Context context) {

    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        Integer id = Integer.parseInt(s);
        UserTable userTable = userRepository.getUser(id);
        if (userTable == null) {
            throw new NotFoundResponse();
        }
        context.json(userTable);
    }

    @Override
    public void update(@NotNull Context context, @NotNull String s) {

    }
}
