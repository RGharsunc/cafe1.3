package com.example.demo.entity;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Vardan on 05.09.2017.
 */


    public class CurrentUser extends  org.springframework.security.core.userdetails.User{

        private User user;
        public CurrentUser (User user){
            super(user.getUsername(),user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public Long getId(){return user.getId();}
        public Role getRole(){return  user.getRole();}


        @Override
        public String toString() {
            return "CurrentUser{" +
                    "user=" + user +
                    '}';
        }
    }

