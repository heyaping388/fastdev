package com.xhe.modules.entity;

import com.xhe.common.validator.group.AddGroup;
import com.xhe.common.validator.group.DelGroup;
import com.xhe.common.validator.group.UpdateGroup;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Xhe
 * @Date: 2018/12/1 11:58
 * @Description:
 */
@Data
public class UserEntity {
    @NotNull(message = "uuid不能为空",groups = {DelGroup.class})
    private Long uuid;
    @NotNull(message = "年龄不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private Integer age;
    @NotBlank(message = "姓名不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private String name;
}
