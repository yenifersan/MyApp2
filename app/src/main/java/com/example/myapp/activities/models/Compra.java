package com.example.myapp.activities.models;

public class Compra {

    private Integer id;
    private String anumordcom;
    private Integer afecordcom;
    private String cliente;
    private String formapago;
    private String moneda;
    private Double total;
    private Integer estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnumordcom() {
        return anumordcom;
    }

    public void setAnumordcom(String anumordcom) {
        this.anumordcom = anumordcom;
    }

    public Integer getAfecordcom() {
        return afecordcom;
    }

    public void setAfecordcom(Integer afecordcom) {
        this.afecordcom = afecordcom;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", anumordcom='" + anumordcom + '\'' +
                ", afecordcom=" + afecordcom +
                ", cliente='" + cliente + '\'' +
                ", formapago='" + formapago + '\'' +
                ", moneda='" + moneda + '\'' +
                ", total=" + total +
                ", estado=" + estado +
                '}';
    }
}
