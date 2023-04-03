package pl.cantabo.database.playlist.playlistCategory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "playlistCategories"
)
public class PlaylistCategoryDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text")
    @NotEmpty
    private String name;

    private boolean defaultItem;
}
