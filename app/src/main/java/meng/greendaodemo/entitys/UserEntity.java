package meng.greendaodemo.entitys;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2016/11/22.
 */
@Entity
public class UserEntity {
    @Id
    private Long id;
    private String name;

    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
