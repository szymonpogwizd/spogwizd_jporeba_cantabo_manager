package pl.cantabo.database.playlist.playlistCategory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.playlist.PlaylistDAO;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
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

    @ManyToMany(mappedBy = "playlistCategories")
    private Set<PlaylistDAO> playlists;

    @ManyToMany(mappedBy = "playlistCategories")
    private Set<GroupDAO> groups;
}
