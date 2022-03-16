package edu.escuelaing.arep;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class App {

    private static Mongo mongo = new Mongo();

    public static void main( String ... args ) {

        staticFileLocation("/public");
        port(getPort());

        get("/logService",(request,response)->
        {
            response.type("application/json");
            mongo.addString(request.queryParams("cadena"));
            return new Gson().toJson(mongo.getStrings());
        });
        }






    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
