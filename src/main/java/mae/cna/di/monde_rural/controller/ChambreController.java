
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

import mae.cna.di.monde_rural.dto.ChambreDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.ChambreService;

@RestController
public class ChambreController {
	
	@Autowired
	private ChambreService chambreService; 
	
	@PostMapping("/chambre") 
	public ChambreDto save(@RequestBody ChambreDto chambreDto) {
		return chambreService.save(chambreDto);	
	}
	
	@PutMapping("/chambre/{uuid}")
	public ChambreDto update(@RequestBody  ChambreDto chambreDto,@PathVariable String uuid) {
		return chambreService.update(chambreDto, uuid);
	}   
	
	@GetMapping("/chambre/{uuid}") 
	public ChambreDto findById(@PathVariable String uuid) {
		return chambreService.getOne(uuid);
	}
	
	
	@GetMapping("/chambre")
    public PageDataDto<ChambreDto> getAllWithKeyAndPage(
    		@PathVariable String uuidChambre,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return chambreService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/chambre/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		chambreService.delete(uuid);
	}
}
