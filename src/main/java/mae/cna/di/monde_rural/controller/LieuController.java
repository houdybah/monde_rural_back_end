
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

import mae.cna.di.monde_rural.dto.LieuDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.LieuService;

@RestController
public class LieuController {
	
	@Autowired
	private LieuService lieuService; 
	
	@PostMapping("/lieu") 
	public LieuDto save(@RequestBody LieuDto lieuDto) {
		return lieuService.save(lieuDto);	
	}
	
	@PutMapping("/lieu/{uuid}")
	public LieuDto update(@RequestBody  LieuDto lieuDto,@PathVariable String uuid) {
		return lieuService.update(lieuDto, uuid);
	}   
	
	@GetMapping("/lieu/{uuid}") 
	public LieuDto findById(@PathVariable String uuid) {
		return lieuService.getOne(uuid);
	}
	
	
	@GetMapping("/lieu")
    public PageDataDto<LieuDto> getAllWithKeyAndPage(
    		@PathVariable String uuidLieu,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return lieuService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/lieu/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		lieuService.delete(uuid);
	}
}
