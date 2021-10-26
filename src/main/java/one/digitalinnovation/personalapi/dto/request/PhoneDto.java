package one.digitalinnovation.personalapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personalapi.enums.Phonetype;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private Phonetype type;

    @NotEmpty
    @Size(min =13, max=14)
    private String number;
}
