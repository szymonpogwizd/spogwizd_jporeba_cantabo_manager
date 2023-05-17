package pl.cantabo.database.song.songCategory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.song.SongDAO;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "songCategories")
public class SongCategoryDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text", nullable = false, unique = true)
    @NotEmpty
    private String name;

    private boolean defaultItem;

    @ManyToMany(mappedBy = "songCategories")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SongDAO> songs;

    @ManyToMany(mappedBy = "songCategories")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<GroupDAO> groups;

    public SongCategoryDAO() {
    }

    public SongCategoryDAO(UUID id, String name, boolean defaultItem, Set<SongDAO> songs, Set<GroupDAO> groups) {
        this.id = id;
        this.name = name;
        this.defaultItem = defaultItem;
        this.songs = songs;
        this.groups = groups;
    }
}
