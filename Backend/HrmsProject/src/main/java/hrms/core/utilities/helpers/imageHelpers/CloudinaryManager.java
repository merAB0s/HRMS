package hrms.core.utilities.helpers.imageHelpers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements ImageUploadService {

    private Cloudinary cloudinary;

    public CloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<Map> upload(MultipartFile multipartFile) {

        Map uploadResult = null;

        try {
            File file = convert(multipartFile);
            uploadResult = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SuccessDataResult<Map>(uploadResult);

    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
