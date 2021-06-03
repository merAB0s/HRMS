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
public class cvDto implements Dto {

        @JsonIgnore
        private Candidate candidate;

        private List<SchoolCandidate> schoolCandidates;
        private List<LanguageCandidate> languageCandidates;
        private List<WorkplaceCandidate> workplaceCandidates;
        private List<SocialMedia> socialMedia;
        private List<AbilityCandidate> abilityCandidates;






}
