import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class LombokConstr {

    private String name;

    @NonNull
    @ToString.Exclude
    private int age;

    @NonNull
    private Date date;
}
