package com.example.movierental.mybatis.model;

public class Genre {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GENRE.ID
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GENRE.NAME
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GENRE.ID
     *
     * @return the value of PUBLIC.GENRE.ID
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GENRE.ID
     *
     * @param id the value for PUBLIC.GENRE.ID
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GENRE.NAME
     *
     * @return the value of PUBLIC.GENRE.NAME
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GENRE.NAME
     *
     * @param name the value for PUBLIC.GENRE.NAME
     *
     * @mbg.generated Mon Apr 17 17:44:09 EEST 2023
     */
    public void setName(String name) {
        this.name = name;
    }
}