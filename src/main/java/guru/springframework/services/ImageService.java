package guru.springframework.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Juan Carlos - 2018/01/04
 *
 */
public interface ImageService {
	void saveImageFile(Long recipeId, MultipartFile file);
}
