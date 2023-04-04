package pl.cantabo.database.song;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.slide.SlideDAO;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songHistory.SongHistoryDAO;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "songs")
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

    @ManyToMany
    @JoinTable(
            name = "songsSongCategories",
            joinColumns = @JoinColumn(name = "songId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<SongCategoryDAO> songCategories;

    @ManyToMany(mappedBy = "songs")
    private Set<GroupDAO> groups;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SlideDAO> slides;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SongHistoryDAO> songHistory;
}
