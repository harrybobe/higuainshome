package com.example.demo.common;

public enum RoleEnum {

    MASTER("master", "管理员"),
    TEACHER("teacher", "老师");

    private String name ;
    private String value ;

    private RoleEnum(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 通过name取描述
     * @param value
     * @return
     */
    public static String getValueByKey(String value){
        for (RoleEnum roleEnum : RoleEnum.values()){
            if (roleEnum.getName().equals(value) ){
                return roleEnum.getValue();
            }
        }
        return "";
    }

    /**
     * 通过name取描述
     * @param value
     * @return
     */
    public static RoleEnum getRoleEnumByKey(String value){
        for (RoleEnum roleEnum : RoleEnum.values()){
            if (roleEnum.getName().equals(value) ){
                return roleEnum;
            }
        }
        return null;
    }
}
