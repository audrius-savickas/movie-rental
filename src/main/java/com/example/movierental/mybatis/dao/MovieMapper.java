package com.example.movierental.mybatis.dao;

import com.example.movierental.mybatis.model.Movie;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    int insert(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    Movie selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    List<Movie> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    int updateByPrimaryKey(Movie record);
}