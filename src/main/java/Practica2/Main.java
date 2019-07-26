package Practica2;
import static spark.Spark.*;
public class Main {

    public static void main(String[] args) {
        port(getPuertoHeroku());
        new Template().manejoTemplate();

    }
    static int getPuertoHeroku() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //En caso de no pasar la información, toma el puerto 4567
    }
}
