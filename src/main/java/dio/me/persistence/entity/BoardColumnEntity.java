package dio.me.persistence.entity;

import lombok.Data;

@Data
public class BoardColumnEntity {

    private Long id;
    private String name;
    private int order;
    private BoardCollumnKindEnum kind;

}
