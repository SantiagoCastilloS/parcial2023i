package uni.edu.pe.guia;

public class ProgramacionTVPublicidad extends ProgramacionTV {
    @Override
    public void agregar(String cadenaTV, ProgramasTV prog) {
        super.agregar(cadenaTV, prog);
        ProgramasTV comercial = new ProgramasTV("Commercial", prog.getHora(),5);
        cadenasYProgramas.put(cadenaTV, comercial);
    }
}
