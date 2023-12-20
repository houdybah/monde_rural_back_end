
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

import mae.cna.di.monde_rural.dto.CooperativeDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.CooperativeService;

@RestController
public class DomaineCooperativeController {
	
	@Autowired
	private CooperativeService domainesCooperativeService; 
	
	@PostMapping("/domainesCooperative") 
	public CooperativeDto save(@RequestBody CooperativeDto domainesCooperativeDto) {
		return domainesCooperativeService.save(domainesCooperativeDto);	
	}
	
	@PutMapping("/domainesCooperative/{uuid}")
	public CooperativeDto update(@RequestBody  CooperativeDto domainesCooperativeDto,@PathVariable String uuid) {
		return domainesCooperativeService.update(domainesCooperativeDto, uuid);
	}   
	
	@GetMapping("/domainesCooperative/{uuid}") 
	public CooperativeDto findById(@PathVariable String uuid) {
		return domainesCooperativeService.getOne(uuid);
	}
	
	
	@GetMapping("/domainesCooperative")
    public PageDataDto<CooperativeDto> getAllWithKeyAndPage(
    		@PathVariable String uuidCooperative,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return domainesCooperativeService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/domainesCooperative/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		domainesCooperativeService.delete(uuid);
	}
}
