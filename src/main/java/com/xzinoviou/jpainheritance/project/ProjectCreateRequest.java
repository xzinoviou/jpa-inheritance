package com.xzinoviou.jpainheritance.project;

import lombok.Getter;

import java.util.Set;

/**
 * @author : Xenofon Zinoviou
 */
@Getter
public class ProjectCreateRequest {

    private String title;

    private Set<Long> projectMembersIds;

    private Long projectOwnerId;
}
