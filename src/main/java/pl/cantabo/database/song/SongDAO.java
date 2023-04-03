package pl.cantabo.database.song;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "users")
public class SongDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text")
    @NotEmpty
    private String name;

    @Column(columnDefinition = "text")
    private String musicAuthor;

    @Column(columnDefinition = "text")
    private String wordsAuthor;

    private long viewCounter;

    private boolean defaultItem;

    private UUID parentId;
}
