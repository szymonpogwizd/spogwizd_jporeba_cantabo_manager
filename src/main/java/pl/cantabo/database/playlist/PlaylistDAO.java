package pl.cantabo.database.playlist;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.slide.SlideDAO;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "playlists")
public class PlaylistDAO  extends Auditable<UUID>  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text")
    @NotEmpty
    private String name;

    private boolean defaultItem;

    @ManyToMany
    @JoinTable(
            name = "playlistsPlaylistCategories",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "playlistCategoryId"))
    private Set<PlaylistCategoryDAO> playlistCategories;

    @ManyToMany
    @JoinTable(
            name = "playlistsSlides",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "slideId"))
    private Set<SlideDAO> slides;

    @ManyToMany(mappedBy = "playlists")
    private Set<GroupDAO> groups;
}
