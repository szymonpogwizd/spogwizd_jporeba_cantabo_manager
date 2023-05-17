package pl.cantabo.database.slide;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.song.SongDAO;

import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "slides")
public class SlideDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer itemOrder;

    @Column(columnDefinition = "text")
    private String body;

    private boolean defaultItem;

    @ManyToMany(mappedBy = "slides")
    private Set<PlaylistDAO> playlists;

    @ManyToMany(mappedBy = "slides")
    private Set<GroupDAO> groups;

    @ManyToOne
    @JoinColumn(name = "songId")
    private SongDAO song;

    public SlideDAO() {
    }

    public SlideDAO(UUID id, Integer itemOrder, String body, boolean defaultItem, Set<PlaylistDAO> playlists, Set<GroupDAO> groups, SongDAO song) {
        this.id = id;
        this.itemOrder = itemOrder;
        this.body = body;
        this.defaultItem = defaultItem;
        this.playlists = playlists;
        this.groups = groups;
        this.song = song;
    }
}
