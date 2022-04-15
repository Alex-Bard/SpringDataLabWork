package com.rs.lab5.model;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "UserException"/*, schema = "dbo", catalog = "AirLogger"*/)
public class UserExceptionEntity implements Serializable {
    private int id;
    @NotNull
    @NotEmpty
    private String message;
    private String targetSite;
    @NotNull
    private Date dateTIme;
    private Integer indexForm;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "targetSite")
    public String getTargetSite() {
        return targetSite;
    }

    public void setTargetSite(String targetSite) {
        this.targetSite = targetSite;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "dateTIme")
    @NotNull
    public Date getDateTIme() {
        return dateTIme;
    }


    public void setDateTIme(Date dateTIme) {
        this.dateTIme = dateTIme;
    }

    @Basic
    @Column(name = "indexForm")
    public Integer getIndexForm() {
        return indexForm;
    }

    public void setIndexForm(Integer indexForm) {
        this.indexForm = indexForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserExceptionEntity that = (UserExceptionEntity) o;
        return id == that.id && Objects.equals(message, that.message) && Objects.equals(targetSite, that.targetSite) && Objects.equals(dateTIme, that.dateTIme) && Objects.equals(indexForm, that.indexForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, targetSite, dateTIme, indexForm);
    }
}
