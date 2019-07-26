package Practica2;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import Practica2.Estudiante;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Template {

    List<Estudiante> listaEstudiante = new ArrayList<>();

    public void manejoTemplate(){
        TemplateFreeMaker();
    }
    int i, id;
    public void TemplateFreeMaker(){
        //Indicar la ruta del FreeMaker!!!
        staticFiles.location("/public");

        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Template.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);
        List<Estudiante> listaEstudiante = new ArrayList<>();
        /*Formulario en
        *http://localhost:4567/formulario
         */
        get("/formulario", (request, response)->{
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario de Edgar en FreeMaker");
            return new ModelAndView(attributes, "Form1.ftl");
        }, freeMarkerEngine);

        /*
         * http://localhost:4567/ProcesarFormulario/
         */
        post("/ProcesarFormulario/",(request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String carrera = request.queryParams("carrera");
            String telefono = request.queryParams("telefono");

            listaEstudiante.add(new Estudiante(matricula, nombre, apellido, carrera, telefono));

            Map<String, Object> attributes = new HashMap<>();
            //enviando los parametros a la vista.
            response.redirect("/formulario");
            return "";
        });

//        http://localhost:4567/Datosprocesado
        get("/Datosprocesado",(request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listaEstudiante", listaEstudiante);
            return new ModelAndView(attributes, "FormularioProcesado.ftl");
        } ,freeMarkerEngine);

//        Eliminar estudiante
//        Debo recibir desde Datosprocesado para Poder mostrar los Datos y cuando elimino vuelvo a cargar el mismo ftl**
//        http://localhost:4567/Datoseliminado/:matricula/
        post("/Datoseliminado/:matricula",(request, response) -> {
           // System.out.println(request.params("matricula"));
            int matricula = Integer.parseInt(request.params("matricula"));
            for(Estudiante estudiante : listaEstudiante){
                int contador = 0;
                if(estudiante.getMatricula() == matricula){
                    listaEstudiante.remove(estudiante);
                }
                contador++;
                response.redirect("/Datosprocesado");
            }

            return "";
        });

//        Recibir para modificar!
        get("/Modificar/:matricula", (request, response)->{
            freemarker.template.Template resultTemplate = configuration.getTemplate("/EditarDatos.ftl");
            StringWriter writer = new StringWriter();
            int matricula = Integer.parseInt(request.params("matricula"));
            int contador =0;
            for(Estudiante est: listaEstudiante){
                if(est.getMatricula() == matricula){
                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("listaEstudiante", listaEstudiante.get(contador));
                    resultTemplate.process(attributes, writer);
                    return writer;
              }
                contador++;
           }
            return "";
        });

//       Datos Editados!
//        http://localhost:4567/DatosEdit/
        post("/DatosEdit",(request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String carrera = request.queryParams("carrera");
            String telefono = request.queryParams("telefono");
            Estudiante estudiante = new Estudiante(matricula, nombre, apellido, carrera, telefono);
          //  System.out.println(estudiante.getMatricula());

            for(Estudiante es : listaEstudiante)
            {
               // System.out.println(es.getMatricula());
               // System.out.println(estudiante.getMatricula());
                if(estudiante.getMatricula() != es.getMatricula())
                {   //System.out.println("Funciona OK123");
                    es.setMatricula(estudiante.getMatricula());
                    es.setNombre(estudiante.getNombre());
                    es.setApellido(estudiante.getApellido());
                    es.setCarrera(estudiante.getCarrera());
                    es.setTelefono(estudiante.getTelefono());
                    break;
                }

            }

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario de Edgar en FreeMaker");
            //enviando los parametros a la vista.
            response.redirect("/formulario");
            return "";
        });


    }
}
