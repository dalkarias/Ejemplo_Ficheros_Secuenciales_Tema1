package Ejemplo07_LecturaXml.Modelos;

public class Empleado {

    private int id;
    private String apellidos;
    private int dep;
    private float salario;

    public Empleado() {
    }

    public Empleado(int id, String apellidos, int dep, float salario) {
        this.id = id;
        this.apellidos = apellidos;
        this.dep = dep;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n"+
                "apellidos = " + apellidos + "\n"+
                "dep = " + dep + "\n"+
                "salario = " + salario;
    }
}
