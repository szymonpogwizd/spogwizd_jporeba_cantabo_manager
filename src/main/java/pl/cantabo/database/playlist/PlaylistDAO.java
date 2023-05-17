package pl.cantabo.database.playlist;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

    @Column(columnDefinition = "text", nullable = false, unique = true)
    @NotEmpty
    private String name;

    private boolean defaultItem;

    @ManyToMany
    @JoinTable(
            name = "playlistsPlaylistCategories",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "playlistCategoryId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PlaylistCategoryDAO> playlistCategories;

    @ManyToMany
    @JoinTable(
            name = "playlistsSlides",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "slideId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SlideDAO> slides;

    @ManyToMany(mappedBy = "playlists")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<GroupDAO> groups;

    public PlaylistDAO() {
    }

    public PlaylistDAO(UUID id, String name, boolean defaultItem, Set<PlaylistCategoryDAO> playlistCategories, Set<SlideDAO> slides, Set<GroupDAO> groups) {
        this.id = id;
        this.name = name;
        this.defaultItem = defaultItem;
        this.playlistCategories = playlistCategories;
        this.slides = slides;
        this.groups = groups;
    }
}
