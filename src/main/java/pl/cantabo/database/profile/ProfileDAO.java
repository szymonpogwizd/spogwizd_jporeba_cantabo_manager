package pl.cantabo.database.profile;

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
@Table(name = "profiles")
public class ProfileDAO  extends Auditable<UUID>  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text")
    @NotEmpty
    private String name;

    private Boolean active;

    private boolean sortByUsed;

    private int bgColor;

    private int txColor;

    private int stopColor;

    private String fontStyle;

    private float margin;

    private float maxFont;

    private float maxMin;

    private String align;

    private String algorithmRange;

    private boolean showTitle;

    private boolean allBig;

    private boolean showEmptySlide;

    private boolean invertColors;

    private boolean expandedList;

    private boolean defaultItem;
}
