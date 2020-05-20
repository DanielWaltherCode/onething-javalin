package org.graphite.onething;

import io.javalin.Javalin;
import org.graphite.onething.controller.UserController;

import static io.javalin.apibuilder.ApiBuilder.crud;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.enableWebjars();
            javalinConfig.addStaticFiles("/style");
        }).start(7070);

        app.routes(() -> {
            crud("api/user/:userId", new UserController());
        });
        app.get("/", context -> context.html("Working"));
    }
}
