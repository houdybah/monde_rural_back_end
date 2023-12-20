package mae.cna.di.monde_rural.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import mae.cna.di.monde_rural.domain.enumeration.EnumRole;


@Entity
public class Utilisateur extends AbstractDomainClass {

    @Column(name = "HASHED_PASSWORD", nullable = true)
    private String password;

    @Column(name = "EMAIL", unique = true, nullable = false)
    @Email(message = "Email should be valid")
    private String email;

    @ElementCollection
    @CollectionTable(name = "UTILISATEUR_ROLES", joinColumns = @JoinColumn(name = "USER_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private List<EnumRole> roles = new ArrayList<EnumRole>();

//    boolean nonExpired = true;
//
//    boolean nonLocked = true;
//
//    boolean Enabled = false;
    
    @OneToOne
    Personnel personnel;
    
    @OneToOne
    MembreEtProducteur membre;
    
    private boolean nonExpired ;

    public List<EnumRole> getRoles() {
		return roles;
	}



	private boolean nonLocked ;

    private boolean Enabled;

       
    
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNonExpired() {
        return nonExpired;
    }

    public boolean isNonLocked() {
        return nonLocked;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNonExpired(boolean nonExpired) {
        this.nonExpired = nonExpired;
    }

    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

    

    public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public void setRoles(List<EnumRole> roles) {
        this.roles = roles;
    }

	public MembreEtProducteur getMembre() {
		return membre;
	}

	public void setMembre(MembreEtProducteur membre) {
		this.membre = membre;
	}

	
	
}
