package com.xzinoviou.jpainheritance.project;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Xenofon Zinoviou
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberId implements Serializable {

    private Long employeeId;

    private Long projectId;

}
