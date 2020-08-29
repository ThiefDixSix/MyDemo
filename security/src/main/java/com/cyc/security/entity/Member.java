package com.cyc.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cyc
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private Integer sex;

    private Integer dd;


    @Override
    protected Serializable pkVal() {
        return this.name;
    }

}
