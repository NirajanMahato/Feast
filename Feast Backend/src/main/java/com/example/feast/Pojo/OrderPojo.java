package com.example.feast.Pojo;

import com.example.feast.Entity.Items;
import com.example.feast.Entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderPojo {

    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Items item;

    @NotNull
    private Date createdDate;

    @NotNull
    private Integer quantity;

}
