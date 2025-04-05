package com.lms.mgmt.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class PlanDTO {
    private String planId;
    private List<CategoryDTO> categories;
}
