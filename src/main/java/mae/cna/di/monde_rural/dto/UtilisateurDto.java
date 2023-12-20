package mae.cna.di.monde_rural.dto;

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

public class UtilisateurDto {

    private String uuid;

    private String password;

    private String email;
    
    private String matriculeAgent;
    
    private String nomAgent;
    
    private String prenomAgent;
    
    private boolean nonExpired ;

    private boolean nonLocked ;

    private boolean Enabled;
    
    private String uuidAgent;

    private List<EnumRole> roles = new ArrayList<EnumRole>();


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EnumRole> getRoles() {
        return roles;
    }

    public void setRoles(List<EnumRole> roles) {
        this.roles = roles;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

	public String getUuidAgent() {
		return uuidAgent;
	}

	public void setUuidAgent(String uuidAgent) {
		this.uuidAgent = uuidAgent;
	}

	public boolean isNonExpired() {
		return nonExpired;
	}

	public void setNonExpired(boolean nonExpired) {
		this.nonExpired = nonExpired;
	}

	public boolean isNonLocked() {
		return nonLocked;
	}

	public void setNonLocked(boolean nonLocked) {
		this.nonLocked = nonLocked;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}

	public String getMatriculeAgent() {
		return matriculeAgent;
	}

	public void setMatriculeAgent(String matriculeAgent) {
		this.matriculeAgent = matriculeAgent;
	}

	public String getNomAgent() {
		return nomAgent;
	}

	public void setNomAgent(String nomAgent) {
		this.nomAgent = nomAgent;
	}

	public String getPrenomAgent() {
		return prenomAgent;
	}

	public void setPrenomAgent(String prenomAgent) {
		this.prenomAgent = prenomAgent;
	}
    
    

}
