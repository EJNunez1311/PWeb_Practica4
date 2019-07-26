package Practica2;
import static spark.Spark.*;


public class Main {

    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        setPort(port);

        new Template().manejoTemplate();

    }

}