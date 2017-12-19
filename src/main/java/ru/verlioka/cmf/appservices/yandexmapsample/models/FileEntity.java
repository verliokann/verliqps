package ru.verlioka.cmf.appservices.yandexmapsample.models;

import javax.persistence.*;

@Entity
@Table( name = "file_storage" )
public class FileEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "file_id" )
    private Long id;

    @Column( name = "file_name" )
    private String fileName;

    @Lob
    @Column( name = "content" )
    private byte[] content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEntity that = (FileEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return fileName != null ? fileName.equals(that.fileName) : that.fileName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        return result;
    }
}
