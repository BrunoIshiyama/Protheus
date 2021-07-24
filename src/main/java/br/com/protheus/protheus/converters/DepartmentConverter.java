package br.com.protheus.protheus.converters;

import br.com.protheus.protheus.domains.Department;
import br.com.protheus.protheus.domains.records.DepartmentRecord;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DepartmentConverter {
    public static Department toDomain(final DepartmentRecord departmentRecord) {
        return Department.builder()
                .id(departmentRecord.getId())
                .name(departmentRecord.getName())
                .build();
    }

    public static DepartmentRecord toRecord(final Department department) {
        final var departmentRecord = new DepartmentRecord();
        departmentRecord.setId(department.getId());
        departmentRecord.setName(department.getName());
        return departmentRecord;
    }
}
