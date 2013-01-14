package com.jvmdramas.app

class Drama {
    String title
    String url
    String drama
    
    Date dateCreated
    Date lastUpdated

    static constraints = {
      title blank: false, maxSize: 200
      url blank: false, maxSize: 500, url: true
      drama blank: false
    }
    static mapping = {
        drama type: 'text'
    }
}
