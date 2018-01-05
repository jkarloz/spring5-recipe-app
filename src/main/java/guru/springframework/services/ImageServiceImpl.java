package guru.springframework.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Juan Carlos - 2018/01/04
 *
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {

        log.debug("Received a file");

    }

}
