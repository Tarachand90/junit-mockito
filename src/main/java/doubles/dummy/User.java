package doubles.dummy;

import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
}
