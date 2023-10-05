package com.curso.model;


/**
 * Representa un modelo de Coches en el contexto de persistencia.
 * 
 * @author Luis Miguel Albarracín Castillo
 */

public class Coche {

   
    private int id;
    private String marca;
    private String modelo;
    private String matricula;

    /**
     * Constructor por defecto.
     */
    public Coche() {
        super();
    }

    /**
     * Constructor con solo ID.
     *
     * @param id identificador del coche.
     */
    public Coche(int id) {
        super();

    }

    /**
     * Constructor completo para instanciar un coche.
     *
     * @param id        identificador del coche.
     * @param marca     marca del coche.
     * @param modelo    modelo del coche.
     * @param matricula matrícula del coche.
     */
    public Coche(int id, String marca, String modelo, String matricula) {
        super();
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    // Getters y Setters

    /**
     * Devuelve el ID del coche.
     *
     * @return id del coche.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del coche.
     *
     * @param id identificador del coche.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve la marca del coche.
     *
     * @return marca del coche.
     */
    public String getMarca() {
        return marca;
    }

    /*
     * Establece la marca del coche.
     *
     * @param marca marca del coche.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el modelo del coche.
     *
     * @return modelo del coche.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del coche.
     *
     * @param modelo El nuevo modelo del coche.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la matrícula del coche.
     *
     * @return La matrícula del coche.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del coche.
     *
     * @param matricula La nueva matrícula del coche.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Calcula y devuelve un valor hash para el objeto Coches.
     *
     * @return El valor hash calculado para el objeto Coches.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**
     * Compara este objeto Coches con otro objeto para determinar si son iguales.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si los objetos son iguales; false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coche other = (Coche) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto Coches.
     *
     * @return Una cadena que contiene información sobre el objeto Coches.
     */
    @Override
    public String toString() {
        return "Coches [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + "]";
    }

}
