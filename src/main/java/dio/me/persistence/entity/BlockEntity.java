package dio.me.persistence.entity;

import java.time.OffsetDateTime;

import lombok.Data;
@Data


public class BlockEntity {
    private Long id;
    private OffsetDateTime blockedAt;
    private String blockReason;
    private OffsetDateTime unblockAt;
    private String unblockReason;

}
