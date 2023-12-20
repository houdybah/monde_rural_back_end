
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
public class CooperativeController {
	
	@Autowired
	private CooperativeService cooperativeService; 
	
	@PostMapping("/cooperative") 
	public CooperativeDto save(@RequestBody CooperativeDto cooperativeDto) {
		return cooperativeService.save(cooperativeDto);	
	}
	
	@PutMapping("/cooperative/{uuid}")
	public CooperativeDto update(@RequestBody  CooperativeDto cooperativeDto,@PathVariable String uuid) {
		return cooperativeService.update(cooperativeDto, uuid);
	}   
	
	@GetMapping("/cooperative/{uuid}") 
	public CooperativeDto findById(@PathVariable String uuid) {
		return cooperativeService.getOne(uuid);
	}
	
	
	@GetMapping("/cooperative")
    public PageDataDto<CooperativeDto> getAllWithKeyAndPage(
    		@PathVariable String uuidCooperative,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return cooperativeService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/cooperative/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		cooperativeService.delete(uuid);
	}
}
