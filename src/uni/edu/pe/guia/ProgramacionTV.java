package uni.edu.pe.guia;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProgramacionTV {
    protected Map<String,ProgramasTV> cadenasYProgramas;

    public ProgramacionTV() {
        cadenasYProgramas = new TreeMap<>();
    }
    public void agregar (String cadenaTV, ProgramasTV prog){
        cadenasYProgramas.put(cadenaTV,prog);
    }
    public void leerProgramas (String lineasProgramas){
        String[] lineas = lineasProgramas.split("#");
        for (String linea: lineas ) {
            String[] nomb = linea.split(">");
            String nombre = nomb[0];
            String[] nombP = nomb[1].split("@");
            String nombrePrograma = nombP[0];
            String[] h = nombP[1].split(":");
            int hora = Integer.parseInt(h[0]);
            String[] m = h[1].split("-");
            int min = Integer.parseInt(m[0]);
            int duracion = Integer.parseInt(m[1]);
            ProgramasTV program = new ProgramasTV(nombrePrograma,new Hora(hora,min), duracion);
            agregar(nombre,program);
        }
    }
    public void mostrarProgramas(){
        StringBuilder rep = new StringBuilder();
        rep.append(cadenasYProgramas);
    }
    public Set<ProgramasTV> filtrosProgramas(FlitrosProgramas seleccion){
        Set <ProgramasTV> nuevo = new TreeSet<>();
        return nuevo = seleccion.filtro();
    }
}
