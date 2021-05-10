package com.proyectweb.mark.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;



    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = true, updatable = true)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private  Producto producto;

    @OneToMany(mappedBy = "producto")                       /* de una compra, podemos acceder a todas las compras */
    private List<ComprasProducto> productos;


    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
