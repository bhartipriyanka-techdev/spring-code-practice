package org.spring;

public class MyDataSource {
    private String userName;
    private String password;
    private String url;
    private String driverClassName;
    private String mappingResource;
    private String hbm2ddl_auto;
    private String format_sql;
    private String show_sql;
    public void display() {
        System.out.println("User Name is :" + userName);
        System.out.println("User Password is :" + password);
        System.out.println("URL is :" + url);
        System.out.println("Driver Class Name is :" + driverClassName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getMappingResource() {
        return mappingResource;
    }

    public void setMappingResource(String mappingResource) {
        this.mappingResource = mappingResource;
    }

    public String getHbm2ddl_auto() {
        return hbm2ddl_auto;
    }

    public void setHbm2ddl_auto(String hbm2ddl_auto) {
        this.hbm2ddl_auto = hbm2ddl_auto;
    }

    public String getFormat_sql() {
        return format_sql;
    }

    public void setFormat_sql(String format_sql) {
        this.format_sql = format_sql;
    }

    public String getShow_sql() {
        return show_sql;
    }

    public void setShow_sql(String show_sql) {
        this.show_sql = show_sql;
    }
}
