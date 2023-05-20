package uni.edu.pe.main;
import uni.edu.pe.guia.ProgramacionTV;
import uni.edu.pe.guia.GuiaException;
import uni.edu.pe.guia.ProgramasTVCortos;

import java.io.IOException;

public class MainProgramacion {
    public static void main(String[] args) throws IOException {
        String cadenaEntrada = "BBC One>Money for Nothing@14:15-40#Sky News>Kay Burley@8:00-25#Sky News>Kay Burley@8:30-25#Channel 4>Channel 4 News@19:00-55#BBC Two>Saving Lives at Sea@19:30-25#Channel 4>Hollyoaks@18:30-25#BBC Two>Richard Osman's House of Games@18:00-25#BBC Two>The Farmer's Country Showdown@18:30-55#Channel 4>Food Unwrapped's Sweet Treat@20:00-55#ITV>The Chase@17:00-55#ITV>Tipping point@16:00-55#ITV>Tenable@15:00-55#Channel 4>Suspect@21:00-25#BBC One>Bargain Hunt@12:15-40#BBC One>News at One@13:00-25#ITV>ITV News Regional@18:00-25#ITV>Coronation Street@20:00-25#ITV>Emmerdale@18:30-55#BBC One>Doctors@13:45-25#BBC One>BBC London@13:30-10#ITV>ITV Evening News@18:30-55";
        // Variable para almacenar una guia de programación
        ProgramacionTV guia;

        // Se inicialza guia con los datos de la cadena de texto
        guia = crearGuia(cadenaEntrada);

        try {
            // Se muestra la información de la guia en la consola de salida
            guia.mostrarProgramas();

            // Se consulta la consistencia de la guia de "ITV", que debe ser false
            // Para que sea consistente basta eliminar la última línea de la cadena.
            validarConsistencia(guia, "ITV");
            // Se consulta la consistencia de la guia de "BBC One", que debe ser true
            validarConsistencia(guia, "BBC One");
            // Se consulta la consistencia de la guia de "NBC", que debe producir una
            // excepción, porque la cadena NBC no está en la guia.
            validarConsistencia(guia, "NBC");
        } catch (GuiaException pe) {
            System.err.println(pe.getMessage());
        }

        // Se seleccionan los programas que tienen 30 minutos o menos
        System.out.println("Los programas de menos de media hora son: \n" + guia.filtrosProgramas(new ProgramasTVCortos(30)));
    }

    /**
     * Devuelve un objeto ProgramacionTV a partir de la información almacenada
     * en la cadena que se pasa como argumento
     *
     * @return Una ProgramacionTV
     */
    private static ProgramacionTV crearGuia(String cadena){
        ProgramacionTV res = new ProgramacionTV();
        res.leerProgramas(cadena);
        return res;
    }

    private static void validarConsistencia(ProgramacionTV guia, String cadena) {
        String esNoEs = guia.esConsistente(cadena) ? " es " : " no es ";
        System.out.println("La cadena " + cadena + esNoEs + "consistente");
    }
}
