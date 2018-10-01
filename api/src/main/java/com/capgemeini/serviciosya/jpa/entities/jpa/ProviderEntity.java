package com.capgemeini.serviciosya.jpa.entities.jpa;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Table (name="provider")
@Entity (name="Provider")
public class ProviderEntity {

    @Id
    @GeneratedValue
    @Basic (optional=false)
    @Column (name="prov_id"  )

    private Integer id = null;


    @Size (max = 48)
    @Column (name="prov_name", nullable=false, length = 48)
    private String   name = null;

    @Size (max = 48)
    @Column (name="prov_lastname", nullable=false, length = 48)
    private String   lastname = null;


    @Column (name="prov_dni", nullable=false)
    private Integer   dni = null;

    @Size (max = 128)
    @Column (name="prov_email", nullable=false, length = 128)
    private String   email = null;

    @Size (max = 48)
    @Column (name="prov_phone", nullable=false, length = 48)
    private String   phone = null;



    @Column (name="prov_cityid", nullable=false)
    private Integer   cityid = null;

    @Size (max = 128)
    @Column (name="prov_adress", nullable=false, length = 128)
    private String   adress = null;


    @Column (name="prov_name", nullable=false)
    private Integer   status = null;


    public ProviderEntity(){
        super();
    }


    public ProviderEntity(Integer id,String name, String lastname, Integer dni, String email, String phone, Integer cityid, String adress, Integer status) {

        super ();

        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.cityid = cityid;
        this.adress = adress;
        this.status = status;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public int hashCode () {

        int hash = 0;
        hash += (this.getId () != null ? this.getId ().hashCode () : 0);

        return hash;
    }


    @Override
    public boolean equals (Object object) {

        if (this == object)  {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (getClass () != object.getClass ()) {
            return false;
        }

        ProviderEntity other = (ProviderEntity) object;
        if (!this.id.equals (other.getId ())) {
            return false;
        }

        return true;
    }




}
