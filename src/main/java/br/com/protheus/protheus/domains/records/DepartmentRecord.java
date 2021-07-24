package br.com.protheus.protheus.domains.records;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Departments")
public class DepartmentRecord {

    @Id
    private String id;

    @Indexed
    private String name;
}
