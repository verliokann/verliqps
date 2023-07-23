package ru.verlioka.cmf.appservices.TextStucture.Models;

import javax.persistence.*;

@Entity
@Table(name = "texttype")
public class TextType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "type_name" )
    private String type_name;

    @Column (name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextType textType = (TextType) o;

        if (!id.equals(textType.id)) return false;
        if (!type_name.equals(textType.type_name)) return false;
        return description.equals(textType.description);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + type_name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
