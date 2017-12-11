package ru.verlioka.cmf.appservices.yandexmapsample.models.suppie;

import javax.persistence.*;

@Entity
@Table(name = "operators")
public class OperatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operator_id")
    private Long id;

    @Column(name = "operator_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OperatorEntity that = (OperatorEntity) o;

        return getId().equals(that.getId()) && (getName() != null ? getName().equals(that.getName()) : that.getName() == null);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OperatorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
