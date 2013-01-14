package com.jvmdramas.app

class DramaCategory {
    Date dateCreated
    Date lastUpdated

    String name
    static hasMany = [childCategories: DramaCategory]
    static belongsTo = [parentCategory: DramaCategory]
    
    static constraints = {
    }
}
