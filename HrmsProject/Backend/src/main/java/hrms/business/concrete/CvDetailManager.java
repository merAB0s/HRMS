package hrms.business.concrete;

import hrms.business.abstracts.CvDetailService;
import hrms.core.utilities.helpers.imageHelpers.ImageUploadService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.CvDetailDto;
import hrms.entities.concretes.CvDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class CvDetailManager implements CvDetailService {

    private CvDetailDto cvDetailDto;
    private ImageUploadService imageUploadService;

    @Autowired
    public CvDetailManager(CvDetailDto cvDetailDto,ImageUploadService imageUploadService) {
        this.cvDetailDto = cvDetailDto;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public DataResult<List<CvDetail>> getAll() {
        return new SuccessDataResult<List<CvDetail>>(this.cvDetailDto.findAll(),"Data Listelendi.");
    }

    @Override
    public DataResult<CvDetail> getByCandidateId(int candidateId) {
        return new SuccessDataResult<CvDetail>(cvDetailDto.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(CvDetail cvDetail) {
        cvDetailDto.save(cvDetail);
        return new SuccessResult("Başarıyla Eklendi.");
    }

    @Override
    public Result uploadPhoto(MultipartFile file,int candidateId) {
        CvDetail cvDetail = this.getByCandidateId(candidateId).getData();



        Map<String,String> result = (Map<String, String>) imageUploadService.upload(file).getData();
        String url = result.get("url");
        cvDetail.setCvPhotoUrl(url);

        cvDetailDto.save(cvDetail);
        return new SuccessResult("Başarılı");

    }


}
