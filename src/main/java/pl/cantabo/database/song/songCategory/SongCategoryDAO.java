package pl.cantabo.database.song.songCategory;

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
@Table(name = "songCategories")
public class SongCategoryDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text")
    @NotEmpty
    private String name;

    private boolean defaultItem;
}
