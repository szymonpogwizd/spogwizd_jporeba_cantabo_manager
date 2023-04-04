package pl.cantabo.database.song.songCategory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

    @Column(columnDefinition = "text")
    @NotEmpty
    private String name;

    private boolean defaultItem;

    @ManyToMany(mappedBy = "songCategories")
    private Set<SongDAO> songs;

    @ManyToMany(mappedBy = "songCategories")
    private Set<GroupDAO> groups;
}
