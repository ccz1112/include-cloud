package com.include.comm.constatant;

/**
 * @projectName include-cloud-common
 * @packageName com.include.comm.constatant
 * @className ColumnConstant
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-23 17:39
 */
public interface Column {

    /**常用字段**/
    interface Comm{
        String ID = "id";
        String CREATE_TIME = "create_time";
        String CREATE_BY = "create_by";
        String UPDATE_TIME = "update_time";
        String UPDATE_BY = "update_by";
    }
    /**include_user表字段**/
    interface IncludeUser{
        String ID = "id";
        String USER_NAME = "user_name";
        String AGE = "age";
        String SEX = "sex";
        String PHONE = "phone";
        String EMAIL = "email";
        String CREATE_TIME = "create_time";
        String PASSWORD = "password";
        String MONEY = "money";
    }

    /**include_menu表字段**/
    interface IncludeMenu{
        String ID = "id";
        String PARENT_ID = "parent_id";
        String ROUTE = "route";
        String MENU_NAME = "menu_name";
        String WHITE = "white";
        String PERMISSION = "permission";
        String ROLE_ID = "role_id";
    }

}
