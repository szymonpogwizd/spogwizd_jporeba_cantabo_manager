package pl.cantabo.database;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "users")
public class UserDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text")
    @NotEmpty
    private String name;

    @Column(columnDefinition = "text")
    @NotEmpty
    private String type;

    @Column(columnDefinition = "text")
    @NotEmpty
    @Email
    private String email;

    @Column(columnDefinition = "text")
    private String password;

    private Boolean active;

    @Column(columnDefinition = "text")
    private String token;

    private ZonedDateTime tokenExpiration;
}
