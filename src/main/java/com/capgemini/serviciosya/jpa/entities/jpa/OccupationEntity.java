package com.capgemini.serviciosya.jpa.entities.jpa;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table (name="occupation")
@Entity (name="Occupation")
public class OccupationEntity {

    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "occu_id")

    private Integer id = null;


    @Size(max = 48)
    @Column(name = "occu_name", nullable = false, length = 48)
    private String name = null;

    @Size(max = 128)
    @Column(name = "occu_descr", nullable = false, length = 128)
    private String description = null;

    @Column(name = "occu_parent")
    private Integer parent;


    public OccupationEntity() {
        super();
    }


    public OccupationEntity(Integer id, String name, String description, Integer parent) {

        super();

        this.id = id;
        this.name = name;
        this.description = description;
        this.parent = parent;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        OccupationEntity other = (OccupationEntity) object;

        if (!this.id.equals (other.getId ())) {
            return false;
        }

        return true;

        }

    }


