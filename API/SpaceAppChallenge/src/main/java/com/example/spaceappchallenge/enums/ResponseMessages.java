package com.example.spaceappchallenge.enums;

public enum ResponseMessages {
    USER_NOT_FOUND{
        @Override
        public String toString(){return "User with id: %d not found.";}
    },
    PROJECT_NOT_FOUND{
        @Override
        public String toString(){return "Project with id: %d not found.";}
    },
}
