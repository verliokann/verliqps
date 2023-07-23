package ru.verlioka.cmf.appservices.TextStucture.Models;


import javax.persistence.*;
import javax.persistence.metamodel.Type;

@Entity
@Table(name = "provider")
public class type_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "type_id" )
    private Type type;

    @ManyToOne
    @JoinColumn( name = "model_id" )
    private Long model;

    @Override
    public String toString() {
        return "type_model{" +
                "id=" + id +
                ", type=" + type +
                ", model=" + model +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        type_model that = (type_model) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return model != null ? model.equals(that.model) : that.model == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Long getModel() {
        return model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setModel(Long model) {
        this.model = model;
    }


}
