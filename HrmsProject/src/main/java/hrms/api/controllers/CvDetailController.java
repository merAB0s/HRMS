package hrms.api.controllers;

import hrms.business.abstracts.CvDetailService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.CvDetail;
import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cvdetails")
public class CvDetailController {

    private CvDetailService cvDetailService;

    @Autowired
    public CvDetailController(CvDetailService cvDetailService) {
        this.cvDetailService = cvDetailService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvDetail>> getAll() {
        return this.cvDetailService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvDetail cvDetail) {
        return this.cvDetailService.add(cvDetail);
    }

    @PostMapping("/uploadPhoto")
    public Result uploadPhoto(@RequestParam("file") MultipartFile photoFile,@RequestParam int candidateId) {
        return this.cvDetailService.uploadPhoto(photoFile,candidateId);
    }


    @GetMapping("/getByCandidateId")
    public DataResult<CvDetail> getByCandidateId(@RequestParam int candidateId){
        return cvDetailService.getByCandidateId(candidateId);
    }







}
