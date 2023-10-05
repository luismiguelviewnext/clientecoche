package com.curso.model;

public class Cliente {
    
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    
    
    public Cliente() {
        super();


    }
    public Cliente(int id) {
        super();
        this.id = id;
    }
    public Cliente(int id, String marca, String modelo, String matricula) {
        super();
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + "]";
    }

    

    


    

    


    
}
