package uni.edu.pe.guia;

import java.util.Objects;

public class ProgramasTV implements Comparable<ProgramasTV>{
    private String nombre;
    private Hora hora;
    private int duracion;

    public ProgramasTV(String nombre, Hora hora, int duracion) {
        if (duracion < 0)
            throw new GuiaException("La duracion no puede ser negativa");
        this.nombre = nombre;
        this.hora = hora;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Hora getHoraFin(){
        return new Hora(hora.getHora(), hora.getMinuto() + duracion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramasTV that = (ProgramasTV) o;
        return duracion == that.duracion && nombre.equalsIgnoreCase(that.nombre) && hora.equals(that.hora);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, hora, duracion);
    }

    @Override
    public String toString() {
        return nombre.toUpperCase() + "@[" + hora.getHora() + ":" + hora.getMinuto() + "]-" + duracion ;
    }
    public int compareaTo1(ProgramasTV programasTV){
        int compareName = this.nombre.compareToIgnoreCase(programasTV.nombre);
        if (compareName == 0)
            return this.duracion - programasTV.getDuracion();
        return compareName;
    }

    @Override
    public int compareTo(ProgramasTV o) {
        int h1 = this.hora.getHora() * 60 + this.hora.getMinuto();
        int h2 = o.hora.getHora()*60 + o.hora.getMinuto();
        int compareH = h1 - h2;
        if (compareH == 0){
            return  this.duracion - o.duracion;
        }
        return compareH;
    }

    public int compareAlt(ProgramasTV o) {
        int compareN = this.nombre.toUpperCase().compareTo(o.nombre.toUpperCase());
        if (compareN == 0){
            return   (this.hora.getHora()*60 + this.hora.getMinuto()) - (o.hora.getHora()*60 + o.hora.getMinuto());
        }
        return compareN;
    }
}
