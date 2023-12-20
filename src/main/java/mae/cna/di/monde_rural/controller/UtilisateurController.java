
package mae.cna.di.monde_rural.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mae.cna.di.monde_rural.dto.UtilisateurDto;
import mae.cna.di.monde_rural.map.Mapper;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.UtilisateurService;

@RestController
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService; 
	
	@PostMapping("/utilisateur") 
	public UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto) {
		return Mapper.toUtilisateurDto(utilisateurService.save(utilisateurDto));	
	}
	
	@PostMapping("/utilisateurNew") 
	public UtilisateurDto newUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
		return utilisateurService.newUtilisateur(utilisateurDto);	
	}
	
	@PutMapping("/utilisateur/{uuid}")
	public UtilisateurDto update(@RequestBody  UtilisateurDto utilisateurDto,@PathVariable String uuid) {
		return utilisateurService.updateUtilisateur(utilisateurDto, uuid);
	}   
	
	@GetMapping("/utilisateur/{uuid}") 
	public UtilisateurDto findById(@PathVariable String uuid) {
		return utilisateurService.getUtilisateur(uuid);
	}
	
	
	@GetMapping("/utilisateurByMail/{uuid}") 
	public UtilisateurDto findByMail(@PathVariable String uuid) {
		return utilisateurService.getUtilisateurByEmail(uuid);
	}
	
	
	@GetMapping("/utilisateur")
    public PageDataDto<UtilisateurDto> getAllWithKeyAndPage(
    		@PathVariable String uuidUtilisateur,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return utilisateurService.findAll(key, page, size);
    }
	
	@DeleteMapping("/utilisateur/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		utilisateurService.deleteUtilisateur(uuid);
	}
}
