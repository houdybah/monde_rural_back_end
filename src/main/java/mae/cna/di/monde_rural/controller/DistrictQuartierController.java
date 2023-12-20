
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

import mae.cna.di.monde_rural.dto.DistrictQuartierDto;
import mae.cna.di.monde_rural.dto.PageDataDto;
import mae.cna.di.monde_rural.service.DistrictQuartierService;

@RestController
public class DistrictQuartierController {
	
	@Autowired
	private DistrictQuartierService districtQuartierService; 
	
	@PostMapping("/districtQuartier") 
	public DistrictQuartierDto save(@RequestBody DistrictQuartierDto districtQuartierDto) {
		return districtQuartierService.save(districtQuartierDto);	
	}
	
	@PutMapping("/districtQuartier/{uuid}")
	public DistrictQuartierDto update(@RequestBody  DistrictQuartierDto districtQuartierDto,@PathVariable String uuid) {
		return districtQuartierService.update(districtQuartierDto, uuid);
	}   
	
	@GetMapping("/districtQuartier/{uuid}") 
	public DistrictQuartierDto findById(@PathVariable String uuid) {
		return districtQuartierService.getOne(uuid);
	}
	
	
	@GetMapping("/districtQuartier")
    public PageDataDto<DistrictQuartierDto> getAllWithKeyAndPage(
    		@PathVariable String uuidDistrictQuartier,
    		@RequestParam(required = false) String key, 
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "10") int size) 
	{
        return districtQuartierService.getAllKeyedAndOrPageed(key, page, size);
    }
	
	@DeleteMapping("/districtQuartier/{uuid}")	
	void deleteEntity(@PathVariable String uuid) {
		districtQuartierService.delete(uuid);
	}
}
