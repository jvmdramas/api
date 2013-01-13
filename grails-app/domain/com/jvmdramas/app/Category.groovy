package com.jvmdramas.app

class Category {
    Date dateCreated
    Date lastUpdated

    String name
    static hasMany = [childCategories: Category]
    static belongsTo = [parentCategory: Category]
    static constraints = {
    }
}
