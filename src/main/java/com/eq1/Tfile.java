package com.eq1;

/**
 * @Auther: szp
 * @Date: 2019/12/14 22:31
 * @Description: 沈泽鹏写点注释吧
 */
public class Tfile {
    private Long id;
    private String username;
    private String filename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Tfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
