package hrms.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "abocloud",
                "api_key", "753536877227738",
                "api_secret", "fr-hyl3Wmhjr9jgMiH9-ocwGEjU"));
    }

}
