package de.wilms.springtest.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Indexed
public class Citizen {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type="uuid-char")
    private UUID oid;

    @Size(min = 1, max = 50)
    private String name;

    @Size(max=50)
    private String currentJob;

    @Size(max=50)
    private String phoneNumber;


    @Pattern(regexp=".+@.+\\..+")
    @Size(max=150)
    private String mail;

    public Citizen() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UUID getOid() {
        return oid;
    }

    public void setOid(UUID oid) {
        this.oid = oid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        if (getOid() != null ? !getOid().equals(citizen.getOid()) : citizen.getOid() != null) return false;
        if (getName() != null ? !getName().equals(citizen.getName()) : citizen.getName() != null) return false;
        if (getCurrentJob() != null ? !getCurrentJob().equals(citizen.getCurrentJob()) : citizen.getCurrentJob() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(citizen.getPhoneNumber()) : citizen.getPhoneNumber() != null) return false;
        return getMail() != null ? getMail().equals(citizen.getMail()) : citizen.getMail() == null;
    }

    @Override
    public int hashCode() {
        int result = getOid() != null ? getOid().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCurrentJob() != null ? getCurrentJob().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getMail() != null ? getMail().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "oid=" + oid +
                ", name='" + name + '\'' +
                ", currentJob='" + currentJob + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
