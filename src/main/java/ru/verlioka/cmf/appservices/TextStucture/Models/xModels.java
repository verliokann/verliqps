package ru.verlioka.cmf.appservices.TextStucture.Models;

import javax.persistence.*;

@Entity
@Table(name = "xmodels")

public class xModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "modelname" )
    private String modelname;

    @Column (name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public String getDescription() {
        return description;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        xModels xModels = (xModels) o;

        if (!id.equals(xModels.id)) return false;
        if (!modelname.equals(xModels.modelname)) return false;
        return description.equals(xModels.description);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + modelname.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
