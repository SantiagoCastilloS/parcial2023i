package uni.edu.pe.guia;

import java.util.Set;
import java.util.TreeSet;


public class ProgramasTVCortos implements FlitrosProgramas {
    private int duracionRef;

    public ProgramasTVCortos(int duracionRef) {
        this.duracionRef = duracionRef;
    }
    @Override
    public Set<ProgramasTV> filtro() {
        Set<ProgramasTV> programa = new TreeSet<>();
        for (ProgramasTV program: progs){
            if (program.getDuracion() < this.duracionRef)
                programa.add(program);
        }
        return  programa;
    }
}
