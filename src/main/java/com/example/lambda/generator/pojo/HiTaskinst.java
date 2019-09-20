package com.example.lambda.generator.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 
 *
 * @author Chao.Qin
 * @date 2019/09/17
 */

/**
* Created by Mybatis Generator on 2019/09/17
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HiTaskinst {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String procDefId;

    /**
     * 
     */
    private String taskDefKey;

    /**
     * 
     */
    private String procInstId;

    /**
     * 
     */
    private String executionId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String parentTaskId;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private String owner;

    /**
     * 
     */
    private String assignee;

    /**
     * 
     */
    private Date startTime;

    /**
     * 
     */
    private Date claimTime;

    /**
     * 
     */
    private Date endTime;

    /**
     * 
     */
    private Long duration;

    /**
     * 
     */
    private String deleteReason;

    /**
     * 
     */
    private Integer priority;

    /**
     * 
     */
    private Date dueDate;

    /**
     * 
     */
    private String formKey;

    /**
     * 
     */
    private String category;

    /**
     * 
     */
    private String tenantId;
}