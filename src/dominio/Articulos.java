/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Docente
 */
@Entity
@Table(name = "articulos", catalog = "pedidos", schema = "")
@NamedQueries({@NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a"), @NamedQuery(name = "Articulos.findByCodigo", query = "SELECT a FROM Articulos a WHERE a.codigo = :codigo"), @NamedQuery(name = "Articulos.findByPrecio", query = "SELECT a FROM Articulos a WHERE a.precio = :precio"), @NamedQuery(name = "Articulos.findByKgs", query = "SELECT a FROM Articulos a WHERE a.kgs = :kgs"), @NamedQuery(name = "Articulos.findByNombre", query = "SELECT a FROM Articulos a WHERE a.nombre = :nombre"), @NamedQuery(name = "Articulos.findActivos", query = "SELECT a FROM Articulos a WHERE a.estado = 1")})
public class Articulos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Lob
    @Column(name = "nombre", length = 65535)
    private String nombre;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "kgs")
    private Integer kgs;
    @OneToMany(mappedBy = "idArticulo")
    private Collection<Pedidos> pedidosCollection;
    @Column(name="estado")
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Articulos() {
    }

    public Articulos(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        Integer oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public Integer getKgs() {
        return kgs;
    }

    public void setKgs(Integer kgs) {
        Integer oldKgs = this.kgs;
        this.kgs = kgs;
        changeSupport.firePropertyChange("kgs", oldKgs, kgs);
    }

    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Articulos[codigo=" + codigo + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
