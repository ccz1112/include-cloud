package com.include.comm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 【请填写功能名称】对象 sys_phrase
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncludePhrase extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 轮数 */
    private Integer convolution;

    /** 房间编号 */
    private String roomCode;

    private Integer joinNum;

    private Integer roomState;

    private Integer countDown;



}
