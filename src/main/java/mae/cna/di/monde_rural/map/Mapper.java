package mae.cna.di.monde_rural.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import mae.cna.di.monde_rural.domain.Chambre;
import mae.cna.di.monde_rural.domain.Cooperative;
import mae.cna.di.monde_rural.domain.DistrictQuartier;
import mae.cna.di.monde_rural.domain.Domaine;
import mae.cna.di.monde_rural.domain.DomainesCooperative;
import mae.cna.di.monde_rural.domain.Espece;
import mae.cna.di.monde_rural.domain.Lieu;
import mae.cna.di.monde_rural.domain.MembreEtProducteur;
import mae.cna.di.monde_rural.domain.Personnel;
import mae.cna.di.monde_rural.domain.Prefecture;
import mae.cna.di.monde_rural.domain.RaceFamille;
import mae.cna.di.monde_rural.domain.RegionAdministrative;
import mae.cna.di.monde_rural.domain.RegionNaturelle;
import mae.cna.di.monde_rural.domain.SousPrefecture;
import mae.cna.di.monde_rural.domain.StoredFile;
import mae.cna.di.monde_rural.domain.TypeDomaine;
import mae.cna.di.monde_rural.domain.Utilisateur;
import mae.cna.di.monde_rural.domain.VillageSecteur;
import mae.cna.di.monde_rural.domain.enumeration.EnumRole;
import mae.cna.di.monde_rural.dto.ChambreDto;
import mae.cna.di.monde_rural.dto.CooperativeDto;
import mae.cna.di.monde_rural.dto.DistrictQuartierDto;
import mae.cna.di.monde_rural.dto.DomaineDto;
import mae.cna.di.monde_rural.dto.DomainesCooperativeDto;
import mae.cna.di.monde_rural.dto.EspeceDto;
import mae.cna.di.monde_rural.dto.LieuDto;
import mae.cna.di.monde_rural.dto.MembreEtProducteurDto;
import mae.cna.di.monde_rural.dto.PersonnelDto;
import mae.cna.di.monde_rural.dto.PrefectureDto;
import mae.cna.di.monde_rural.dto.RaceFamilleDto;
import mae.cna.di.monde_rural.dto.RegionAdministrativeDto;
import mae.cna.di.monde_rural.dto.RegionNaturelleDto;
import mae.cna.di.monde_rural.dto.SousPrefectureDto;
import mae.cna.di.monde_rural.dto.StoredFileDto;
import mae.cna.di.monde_rural.dto.StoredFileInfoDto;
import mae.cna.di.monde_rural.dto.TypeDomaineDto;
import mae.cna.di.monde_rural.dto.UtilisateurDto;
import mae.cna.di.monde_rural.dto.VillageSecteurDto;

@Component
public class Mapper {
	public static StoredFileDto toStoreFileDto(StoredFile fileDB) {
		StoredFileDto result = new StoredFileDto();
		result.setBytes(fileDB.getBytes());
		result.setName(fileDB.getName());
		result.setUuid(fileDB.getUuid());
		result.setType(fileDB.getType());
		return result;
	}

	public static StoredFileInfoDto toStoredFileInfoDto(StoredFile fileDB) {
		StoredFileInfoDto result = new StoredFileInfoDto();
		result.setName(fileDB.getName());
		result.setUuid(fileDB.getUuid());
		return result;
	}
	
	
	public static UserDetails toUserDetails(Utilisateur user) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (Iterator iterator = user.getRoles().iterator(); iterator.hasNext();) {
			EnumRole enumRole = (EnumRole) iterator.next();
			authorities.add(new SimpleGrantedAuthority(enumRole.name()));
		}
		UserDetails userdetails = new User(user.getEmail(), user.getPassword(), authorities);

		return userdetails;
	}
	
	public static Utilisateur toUser(UtilisateurDto user) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(user.getEmail());
		return utilisateur;
	}

	public static UtilisateurDto toUtilisateurDto(Utilisateur user) {
		UtilisateurDto utilisateurDto = new UtilisateurDto();
		utilisateurDto.setUuid(user.getUuid());
		utilisateurDto.setEmail(user.getEmail());
		utilisateurDto.setEnabled(user.isEnabled());
		utilisateurDto.setNonExpired(user.isNonExpired());
		utilisateurDto.setNonLocked(user.isNonLocked());
//		if (user.getAgent() != null) {
//			utilisateurDto.setUuidAgent(user.getAgent().getUuid());
//			utilisateurDto.setMatriculeAgent(user.getAgent().getMatricule());
//			utilisateurDto.setNomAgent(user.getAgent().getNom());
//			utilisateurDto.setPrenomAgent(user.getAgent().getPrenom());
//		}
//       List<EnumRole> roles = new ArrayList<EnumRole>();
		utilisateurDto.setRoles(user.getRoles());
		return utilisateurDto;
	}
	
	public static CooperativeDto toCooperativeDto(Cooperative cooperative) {
		CooperativeDto cooperativeDto =  new CooperativeDto();
		cooperativeDto.setUuid(cooperative.getUuid());
		cooperativeDto.setCode(cooperative.getCode());
		cooperativeDto.setAdresse(cooperative.getAdresse());
		cooperativeDto.setContact(cooperative.getContact());
		cooperativeDto.setDateCreation(cooperative.getDateCreation());
		cooperativeDto.setDescription(cooperative.getDescription());
		cooperativeDto.setEmail(cooperative.getEmail());
		cooperativeDto.setLibelle(cooperative.getLibelle());
		cooperativeDto.setPlateForme(cooperative.getPlateForme());
		cooperativeDto.setReferenceAgrement(cooperative.getReferenceAgrement());
		if(cooperative.getCopieAgrement()!=null)
		{
			cooperativeDto.setCopieAgrementUuid(cooperative.getCopieAgrement().getUuid());
		}
		return cooperativeDto;
	}
	
	public static ChambreDto toChambreDto (Chambre chambre) {
		
		ChambreDto chambreDto = new ChambreDto();
		chambreDto.setUuid(chambre.getUuid());
		chambreDto.setCode(chambre.getCode());
		chambreDto.setDescription(chambre.getDescription());
		chambreDto.setLibelle(chambre.getLibelle());
		return chambreDto;
		
	}
	
	public static DistrictQuartierDto toDistrictQuartierDto (DistrictQuartier districtQuartier) {
		
		DistrictQuartierDto districtQuartierDto = new DistrictQuartierDto();
		districtQuartierDto.setUuid(districtQuartier.getUuid());
		districtQuartierDto.setCode(districtQuartier.getCode());
		districtQuartierDto.setDescription(districtQuartier.getDescription());
		districtQuartierDto.setLibelle(districtQuartier.getLibelle());
		return districtQuartierDto;
		
	}
	
	
	public static DomaineDto toDomaineDto (Domaine domaine) {
		
		DomaineDto domaineDto = new DomaineDto();
		domaineDto.setUuid(domaine.getUuid());
		domaineDto.setDescription(domaine.getDescription());
		domaineDto.setLibelle(domaine.getLibelle());
		domaineDto.setTypeDomaineLibelle(domaine.getTypeDomaine().getLibelle());
		domaineDto.setTypeDomaineUuid(domaine.getTypeDomaine().getUuid());
		return domaineDto;
		
	}
	
	public static DomainesCooperativeDto toDomainesCooperativeDto (DomainesCooperative domainesCooperative) {
		
		DomainesCooperativeDto domainesCooperativeDto = new DomainesCooperativeDto();
		domainesCooperativeDto.setUuid(domainesCooperative.getUuid());
		domainesCooperativeDto.setActivites(domainesCooperative.getActivites());
		domainesCooperativeDto.setCooperativeLibelle(domainesCooperative.getCooperative().getLibelle());
		domainesCooperativeDto.setCooperativeUuid(domainesCooperative.getCooperative().getUuid());
		domainesCooperativeDto.setDateDebut(domainesCooperative.getDateDebut());
		domainesCooperativeDto.setDateFin(domainesCooperative.getDateFin());
		domainesCooperativeDto.setDomaineLibelle(domainesCooperative.getDomaine().getLibelle());
		domainesCooperativeDto.setDomaineUuid(domainesCooperative.getDomaine().getUuid());
		return domainesCooperativeDto;
		
	}
	
	
   public static EspeceDto toEspeceDto (Espece espece) {
		
	    EspeceDto especeDto = new EspeceDto();
		especeDto.setUuid(espece.getUuid());
		especeDto.setCode(espece.getCode());
		especeDto.setDescription(espece.getDescription());
		especeDto.setDomaineLibelle(espece.getDomaine().getLibelle());
		especeDto.setDomaineUuid(espece.getDomaine().getUuid());
		especeDto.setLibelle(espece.getLibelle());
		return especeDto;
		
	}
   
   
   public static LieuDto toLieuDto (Lieu lieu) {
		
	    LieuDto lieuDto = new LieuDto();
	    lieuDto.setUuid(lieu.getUuid());
	    lieuDto.setDescription(lieu.getDescription());
	    lieuDto.setLatitude(lieu.getLatitude());
	    lieuDto.setLongitude(lieu.getLongitude());
	    lieuDto.setVillageSecteurLibelle(lieu.getVillageSecteur().getLibelle());
	    lieuDto.setVillageSecteurUuid(lieu.getVillageSecteur().getUuid());
		return lieuDto;
		
	}
   
   
   public static MembreEtProducteurDto toMembreEtProducteurDto (MembreEtProducteur membreEtProducteur) {
		
	    MembreEtProducteurDto membreEtProducteurDto = new MembreEtProducteurDto();
	    membreEtProducteurDto.setUuid(membreEtProducteur.getUuid());
	    membreEtProducteurDto.setAdresse(membreEtProducteur.getAdresse());
	    membreEtProducteurDto.setContact(membreEtProducteur.getContact());
	    membreEtProducteurDto.setDateNaissance(membreEtProducteur.getDateNaissance());
	    membreEtProducteurDto.setEmail(membreEtProducteur.getEmail());
	    membreEtProducteurDto.setGenre(membreEtProducteur.getGenre());
	    membreEtProducteurDto.setLieuNaissance(membreEtProducteur.getLieuNaissance());
	    membreEtProducteurDto.setMatricule(membreEtProducteur.getMatricule());
	    membreEtProducteurDto.setNom(membreEtProducteur.getNom());
	    membreEtProducteurDto.setNomMere(membreEtProducteur.getNomMere());
	    membreEtProducteurDto.setPrenomMere(membreEtProducteur.getPrenomMere());
	    membreEtProducteurDto.setPrenomPere(membreEtProducteur.getPrenomPere());
	    membreEtProducteurDto.setResponsabilite(membreEtProducteur.getResponsabilite());
	    membreEtProducteurDto.setPrenom(membreEtProducteur.getPrenom());
	    if(membreEtProducteur.getCooperative() != null)
	    {
	    	membreEtProducteurDto.setCooperativeLibelle(membreEtProducteur.getCooperative().getLibelle());
		    membreEtProducteurDto.setCooperativeUuid(membreEtProducteur.getCooperative().getUuid());
	    }
		return membreEtProducteurDto;
		
	}
   
   
   public static PersonnelDto toPersonnelDto (Personnel personnel) {
		
	   PersonnelDto personnelDto = new PersonnelDto();
	    personnelDto.setUuid(personnel.getUuid());
	    personnelDto.setAdresse(personnel.getAdresse());
	    personnelDto.setContact(personnel.getContact());
	    personnelDto.setDateNaissance(personnel.getDateNaissance());
	    personnelDto.setEmail(personnel.getEmail());
	    personnelDto.setGenre(personnel.getGenre());
	    personnelDto.setLieuNaissance(personnel.getLieuNaissance());
	    personnelDto.setMatricule(personnel.getMatricule());
	    personnelDto.setNom(personnel.getNom());
	    personnelDto.setNomMere(personnel.getNomMere());
	    personnelDto.setPrenomMere(personnel.getPrenomMere());
	    personnelDto.setPrenomPere(personnel.getPrenomPere());
	    personnelDto.setPrenom(personnel.getPrenom());
	    
		return personnelDto;
		
	}
   
   
   public static PrefectureDto toPrefectureDto (Prefecture prefecture) {
		
		PrefectureDto prefectureDto = new PrefectureDto();
		prefectureDto.setUuid(prefecture.getUuid());
		prefectureDto.setCode(prefecture.getCode());
		prefectureDto.setDescription(prefecture.getDescription());
		prefectureDto.setLibelle(prefecture.getLibelle());
		prefectureDto.setRegionAdministrativeLibelle(prefecture.getRegionAdministrative().getLibelle());
		prefectureDto.setRegionAdministrativeUuid(prefecture.getRegionAdministrative().getUuid());
		return prefectureDto;
		
	}
   
   
   public static RaceFamilleDto toRaceFamilleDto (RaceFamille raceFamille) {
		
		RaceFamilleDto raceFamilleDto = new RaceFamilleDto();
		raceFamilleDto.setUuid(raceFamille.getUuid());
		raceFamilleDto.setCode(raceFamille.getCode());
		raceFamilleDto.setDescription(raceFamille.getDescription());
		raceFamilleDto.setLibelle(raceFamille.getLibelle());
		raceFamilleDto.setEspeceLibelle(raceFamille.getEspece().getLibelle());
		raceFamilleDto.setEspeceUuid(raceFamille.getEspece().getUuid());
		return raceFamilleDto;
		
	}
   
   public static RegionAdministrativeDto toRegionAdministrativeDto (RegionAdministrative regionAdministrative) {
		
		RegionAdministrativeDto regionAdministrativeDto = new RegionAdministrativeDto();
		regionAdministrativeDto.setUuid(regionAdministrative.getUuid());
		regionAdministrativeDto.setCode(regionAdministrative.getCode());
		regionAdministrativeDto.setDescription(regionAdministrative.getDescription());
		regionAdministrativeDto.setLibelle(regionAdministrative.getLibelle());
		regionAdministrativeDto.setRegionNaturelleLibelle(regionAdministrative.getRegionNaturelle().getLibelle());
		regionAdministrativeDto.setRegionNaturelleUuid(regionAdministrative.getRegionNaturelle().getUuid());
		return regionAdministrativeDto;
		
	}
   
   
   public static RegionNaturelleDto toRegionNaturelleDto (RegionNaturelle regionNaturelle) {
		
		RegionNaturelleDto regionNaturelleDto = new RegionNaturelleDto();
		regionNaturelleDto.setUuid(regionNaturelle.getUuid());
		regionNaturelleDto.setCode(regionNaturelle.getCode());
		regionNaturelleDto.setDescription(regionNaturelle.getDescription());
		regionNaturelleDto.setLibelle(regionNaturelle.getLibelle());
		return regionNaturelleDto;
		
	}
	
   
   public static SousPrefectureDto toSousPrefectureDto (SousPrefecture sousPrefecture) {
		
	   SousPrefectureDto sousPrefectureDto = new SousPrefectureDto();
	   sousPrefectureDto.setUuid(sousPrefecture.getUuid());
	   sousPrefectureDto.setCode(sousPrefecture.getCode());
	   sousPrefectureDto.setDescription(sousPrefecture.getDescription());
	   sousPrefectureDto.setLibelle(sousPrefecture.getLibelle());
	   sousPrefectureDto.setPrefectureLibelle(sousPrefecture.getPrefecture().getLibelle());
	   sousPrefectureDto.setPrefectureUuid(sousPrefecture.getPrefecture().getUuid());
	   return sousPrefectureDto;
		
	}
   
   
   public static TypeDomaineDto toTypeDomaineDto (TypeDomaine typeDomaine) {
		
		TypeDomaineDto typeDomaineDto = new TypeDomaineDto();
		typeDomaineDto.setUuid(typeDomaine.getUuid());
		typeDomaineDto.setDescription(typeDomaine.getDescription());
		typeDomaineDto.setLibelle(typeDomaine.getLibelle());
		return typeDomaineDto;
		
	}
   
   
   public static VillageSecteurDto toVillageSecteurDto (VillageSecteur villageSecteur) {
		
		VillageSecteurDto villageSecteurDto = new VillageSecteurDto();
		villageSecteurDto.setUuid(villageSecteur.getUuid());
		villageSecteurDto.setCode(villageSecteur.getCode());
		villageSecteurDto.setDescription(villageSecteur.getDescription());
		villageSecteurDto.setLibelle(villageSecteur.getLibelle());
		return villageSecteurDto;
		
	}
	
}