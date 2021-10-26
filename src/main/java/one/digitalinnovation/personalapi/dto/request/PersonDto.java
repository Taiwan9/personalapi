package one.digitalinnovation.personalapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personalapi.entity.Phone;

import java.time.LocalDate;
import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;

    @NotEmpty
    @size(min =2, max =100)
    private String firstName;

    @NotEmpty
    @size(min =2, max =100)
    private String lastName;

    @notEmpty
    @CPF
    private String cpf;

    private LocalDate birthDate;



    @Valid
    @NotEmpty
    private List<Phone> phones;
}
