package hrms.entities.dtos;

import hrms.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAndEmployerDto implements Dto {

    private String companyName;
    private String jobTitle;
    private int quota;
    private LocalDate applicationDeadline;
    private LocalDateTime createdDate;
}
