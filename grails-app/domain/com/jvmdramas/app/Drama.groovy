package com.jvmdramas.app

class Drama {
    String title
    String url
    String drama
    
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
    static mapping = {
        drama type: 'text'
    }
}
