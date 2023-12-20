package mae.cna.di.monde_rural.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import mae.cna.di.monde_rural.domain.StoredFile;
import mae.cna.di.monde_rural.repository.StoredFilesRepository;
import mae.cna.di.monde_rural.service.StoredFileService;

@Service
public class StoredFileServiceImpl implements StoredFileService {

    @Autowired
    private StoredFilesRepository fileDBRepository;
    
   

    @Override
    public StoredFile store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        
        StoredFile StoredFile = new StoredFile(fileName, file.getContentType(), file.getBytes());
        return fileDBRepository.save(StoredFile);
    }

    @Override
    public StoredFile getFile(String uuid) {
        return fileDBRepository.findById(uuid).get();
    }
    
    @Override
    public StoredFile getFileById(String uuid) {
        return fileDBRepository.findByUuid(uuid);
    }

}
