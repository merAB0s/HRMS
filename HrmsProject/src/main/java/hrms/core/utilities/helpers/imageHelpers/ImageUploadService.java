package hrms.core.utilities.helpers.imageHelpers;

import hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {

    DataResult<Map> upload(MultipartFile file);

}
