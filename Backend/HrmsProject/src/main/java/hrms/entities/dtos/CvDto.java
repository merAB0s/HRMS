package hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hrms.entities.abstracts.Dto;
import hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto implements Dto {

        @JsonIgnore
        private Candidate candidate;

        private List<SchoolCandidate> schoolCandidates;
        private List<LanguageCandidate> languageCandidates;
        private List<WorkplaceCandidate> workplaceCandidates;
        private List<SocialMedia> socialMedias;
        private List<AbilityCandidate> abilityCandidates;
        private CvDetail cvDetail;






}
