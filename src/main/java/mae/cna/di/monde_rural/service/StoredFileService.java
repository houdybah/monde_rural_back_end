package mae.cna.di.monde_rural.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import mae.cna.di.monde_rural.domain.StoredFile;

public interface StoredFileService {

    StoredFile store(MultipartFile file) throws IOException;

    StoredFile getFile(String uuid);

    StoredFile getFileById(String uuid);
}
