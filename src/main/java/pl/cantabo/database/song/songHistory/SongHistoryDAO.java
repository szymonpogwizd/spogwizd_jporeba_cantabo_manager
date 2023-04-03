package pl.cantabo.database.song.songHistory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;

import java.util.Calendar;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "songHistories")
public class SongHistoryDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Calendar scheduledDate;
}
