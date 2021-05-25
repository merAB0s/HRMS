package kodlamaio.HrmsProject.core.utilities.services.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.core.utilities.results.Result;

@Service
public interface EmailService {
    Result sendEmail();

}
